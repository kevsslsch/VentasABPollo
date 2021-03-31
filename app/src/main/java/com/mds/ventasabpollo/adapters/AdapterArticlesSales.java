package com.mds.ventasabpollo.adapters;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.activities.SalesActivity;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.Articles;
import com.mds.ventasabpollo.models.DetailsSales;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static android.view.View.VISIBLE;

public class AdapterArticlesSales extends RecyclerView.Adapter<AdapterArticlesSales.ArticlesViewHolder>{
       
    private Context context;
  
    private List<Articles> articlesList;
    private View popupInputDialogView;
    AlertDialog alert;
    ProgressDialog progress;
    LinearLayout layoutDialogAlert;

    TextView txtDialogPrice, txtDialogNameArticle, txtDialogArticleKey, txtDialogUM, txtDialogDescription, txtViewDialogImport, txtDialogIVA, txtViewDialogIVA, txtDialogTotal, txtViewDialogTotal;
    EditText editTxtDialogPrice, editTxtDialogAmount;
    ImageView imgDialogArticle;
    Button btnDialogSave, btnDialogCancel;

    private Realm realm;
    String valuePrice, valueAmount;
    double price, amount, amountDouble, totalImport;

    private long mLastClickTime = 0;
    int nVisit, nClient, idRoute;

    public AdapterArticlesSales(Context context, List<Articles> articlesList) {
        this.context = context;
        this.articlesList = articlesList;
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_articles_b, parent, false);
        return new ArticlesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ArticlesViewHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        realm = Realm.getDefaultInstance();
        nVisit = spClass.intGetSP("nVisit");

        RealmResults<DetailsSales> listDetails = realm.where(DetailsSales.class).equalTo("visita", nVisit).equalTo("clave_articulo", articlesList.get(position).getClave_articulo()).findAll();

        if (spClass.intGetSP("nClient") != 0) {
            nClient = spClass.intGetSP("nClient");
        } else {
            nClient = 0;
        }

        Bitmap bitmap;
        if (functionsapp.getBase64(articlesList.get(position).getClave_articulo(), "articles").isEmpty()) {
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.no_foto);
        } else {
            byte[] decodedString = Base64.decode(functionsapp.getBase64(articlesList.get(position).getClave_articulo(), "articles"), Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        }

        BitmapDrawable mDrawable = new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(bitmap, 150, 150, true));
        holder.imgArticle.setImageDrawable(mDrawable);

        holder.txtName_Article.setText(articlesList.get(position).getNombre_articulo().trim());

        if(listDetails.size() > 0){
            holder.editTxtAmount.setText(""+(int)listDetails.get(0).getCantidad());
        }else{
            holder.editTxtAmount.setText("0");
        }

        /*holder.layoutArticle.setOnClickListener(view -> {

                    if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                        return;
                    } else {
                        showDialog(holder);
                        functionsapp.clickArticle(articlesList.get(position).getClave_articulo());
                    }
                    mLastClickTime = SystemClock.elapsedRealtime();
                });*/

        holder.editTxtAmount.setSelectAllOnFocus(true);
        holder.editTxtAmount.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                valueAmount = holder.editTxtAmount.getText().toString();
                idRoute = spClass.intGetSP("idRoute");

                if (valueAmount.length() == 0 || valueAmount.equals(".")) {
                    valueAmount = "0";
                }

                amountDouble = Double.parseDouble(valueAmount);

                amount = Double.parseDouble(valueAmount);
                price = Double.parseDouble(functionsapp.getDataPrices(nClient, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), "precio_contado"));
                totalImport = price * amount;

                saveDetail(holder);
            }
        });

        if(functionsapp.getIsVisitFinished(nVisit)){
            holder.editTxtAmount.setEnabled(false);
        }else{
            holder.editTxtAmount.setEnabled(true);
        }

    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public class ArticlesViewHolder extends RecyclerView.ViewHolder {

        ImageView imgArticle;
        TextView txtName_Article;
        EditText editTxtAmount;
        LinearLayout layoutArticle;

        public ArticlesViewHolder(View itemView) {
            super(itemView);

            imgArticle = itemView.findViewById(R.id.imgArticle);
            editTxtAmount = itemView.findViewById(R.id.editTxtAmount);
            txtName_Article = itemView.findViewById(R.id.txtNameArticle);
            layoutArticle = itemView.findViewById(R.id.layoutArticle);
        }
    }

    public void showDialog(final ArticlesViewHolder holder){
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        try {
            alert = new AlertDialog.Builder(context).create();

            LayoutInflater layoutInflater = LayoutInflater.from(context);

            popupInputDialogView = layoutInflater.inflate(R.layout.dialog_product, null);

            txtDialogPrice = popupInputDialogView.findViewById(R.id.txtDialogPrice);
            editTxtDialogPrice = popupInputDialogView.findViewById(R.id.editTxtDialogPrice);
            editTxtDialogAmount = popupInputDialogView.findViewById(R.id.editTxtDialogAmount);
            txtViewDialogImport = popupInputDialogView.findViewById(R.id.txtViewDialogImport);
            btnDialogSave = popupInputDialogView.findViewById(R.id.btnDialogSave);
            btnDialogCancel = popupInputDialogView.findViewById(R.id.btnDialogCancel);
            txtDialogNameArticle = popupInputDialogView.findViewById(R.id.txtDialogNameArticle);
            txtDialogArticleKey = popupInputDialogView.findViewById(R.id.txtDialogArticleKey);
            txtDialogUM = popupInputDialogView.findViewById(R.id.txtDialogUM);
            txtDialogDescription = popupInputDialogView.findViewById(R.id.txtDialogDescription);
            txtDialogIVA  = popupInputDialogView.findViewById(R.id.txtDialogIVA);
            txtViewDialogIVA = popupInputDialogView.findViewById(R.id.txtViewDialogIVA);
            txtDialogTotal = popupInputDialogView.findViewById(R.id.txtDialogTotal);
            txtViewDialogTotal = popupInputDialogView.findViewById(R.id.txtViewDialogTotal);

            imgDialogArticle = popupInputDialogView.findViewById(R.id.imgDialogArticle);
            layoutDialogAlert = popupInputDialogView.findViewById(R.id.layoutDialogAlert);

            editTxtDialogPrice.setSelectAllOnFocus(true);
            editTxtDialogAmount.setSelectAllOnFocus(true);

            if (verifyExistDetail(articlesList.get(holder.getAdapterPosition()).getArticulo())) {
                layoutDialogAlert.setVisibility(VISIBLE);
            } else {
                layoutDialogAlert.setVisibility(View.GONE);
            }

            txtDialogArticleKey.setText("Artículo: " + articlesList.get(holder.getAdapterPosition()).getArticulo().trim());
            txtDialogNameArticle.setText(articlesList.get(holder.getAdapterPosition()).getNombre_articulo().trim());
            txtDialogUM.setText("Unidad de Medida: " + articlesList.get(holder.getAdapterPosition()).getNombre_unidad().trim());
            txtDialogDescription.setText("Descripción: " + articlesList.get(holder.getAdapterPosition()).getDescripcion_extendida().trim());
            txtDialogIVA.setText("I.V.A. (" + baseApp.getPercentage(functionsapp.getDataPrices(nClient, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva")) + ")");

            txtDialogPrice.setText("Precio a Contado");
            editTxtDialogPrice.setText("" + functionsapp.getDataPrices(nClient, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), "precio_contado"));

            Bitmap bitmap;
            if (functionsapp.getBase64(articlesList.get(holder.getAdapterPosition()).getClave_articulo(), "articles").isEmpty()) {
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.no_foto);
            } else {
                byte[] decodedString = Base64.decode(functionsapp.getBase64(articlesList.get(holder.getAdapterPosition()).getClave_articulo(), "articles"), Base64.DEFAULT);
                bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            }

            BitmapDrawable mDrawable = new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(bitmap, 150, 150, true));
            imgDialogArticle.setImageDrawable(mDrawable);

            valueAmount = editTxtDialogAmount.getText().toString();
            valuePrice = editTxtDialogPrice.getText().toString();

            editTxtDialogPrice.setEnabled(false);
            editTxtDialogPrice.setFocusable(false);

            if (valuePrice.length() == 0 || valuePrice.isEmpty()) {
                valuePrice = "0";
            }

            if (valueAmount.length() == 0 || valueAmount.isEmpty() || valueAmount.equals(".")) {
                valueAmount = "0";
            }

            try {
                price = Double.parseDouble(valuePrice);
                amount = Double.parseDouble(valueAmount);
            }catch (Exception ex){
                baseApp.showToast("Error, repórtalo al dpto de Sistemas: " + ex);
                txtViewDialogImport.setText("0.0");
            }

            totalImport = price * amount;
            txtViewDialogImport.setText("" + baseApp.formattedNumber(totalImport));
            txtViewDialogIVA.setText("" + baseApp.formattedNumber(Double.parseDouble(functionsapp.getDataPrices(nClient, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva")) * totalImport));
            txtViewDialogTotal.setText("" + baseApp.formattedNumber((Double.parseDouble(functionsapp.getDataPrices(nClient, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva")) * totalImport) + totalImport));

            baseApp.showKeyboardEditText(editTxtDialogAmount);

            alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alert.setView(popupInputDialogView);
            editTxtDialogPrice.addTextChangedListener(new TextWatcher() {

                public void afterTextChanged(Editable s) {
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    valuePrice = editTxtDialogPrice.getText().toString();
                    valueAmount = editTxtDialogAmount.getText().toString();

                    if (valuePrice.length() == 0 || valuePrice.isEmpty()) {
                        valuePrice = "0";
                    }

                    if (valueAmount.length() == 0 || valueAmount.isEmpty() || valueAmount.equals(".")) {
                        valueAmount = "0";
                    }

                    price = Double.parseDouble(valuePrice);
                    amount = Double.parseDouble(valueAmount);

                    totalImport = price * amount;
                    txtViewDialogImport.setText(String.valueOf(totalImport));
                    txtViewDialogIVA.setText("" + baseApp.formattedNumber(Double.parseDouble(functionsapp.getDataPrices(nClient, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva")) * totalImport));
                    txtViewDialogTotal.setText("" + baseApp.formattedNumber((Double.parseDouble(functionsapp.getDataPrices(nClient, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva")) * totalImport) + totalImport));
                }
            });

            editTxtDialogAmount.addTextChangedListener(new TextWatcher() {

                public void afterTextChanged(Editable s) {
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    valuePrice = editTxtDialogPrice.getText().toString();
                    valueAmount = editTxtDialogAmount.getText().toString();
                    idRoute = spClass.intGetSP("idRoute");

                    if(editTxtDialogAmount.getText().toString().length() > 0){

                        double amountDouble;
                        String amountString = editTxtDialogAmount.getText().toString();

                        if(amountString.substring(amountString.length() - 1).equals(".")){
                            String removePoint = amountString.substring(0, amountString.length() - 1);
                            amountDouble = Double.parseDouble(removePoint);
                        }else{
                            amountDouble = Double.parseDouble(amountString);
                        }

                        if(!functionsapp.checkAmountSale(idRoute, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), amountDouble)){
                            baseApp.showToast("La cantidad supera a la existente en inventario, se remplazará a la máxima posible.");
                            editTxtDialogAmount.setText(Double.toString(functionsapp.getAmountArticleRoute(idRoute, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), false, false)));
                            editTxtDialogAmount.setSelection(editTxtDialogAmount.getText().length());
                        }
                    }

                    if (valuePrice.length() == 0) {
                        valuePrice = "0";
                    }

                    if (valueAmount.length() == 0 || valueAmount.equals(".")) {
                        valueAmount = "0";
                    }

                    try {
                    price = Double.parseDouble(valuePrice);
                    amount = Double.parseDouble(valueAmount);

                    totalImport = price * amount;
                    txtViewDialogImport.setText("" + baseApp.formattedNumber(totalImport));
                    txtViewDialogIVA.setText("" + baseApp.formattedNumber(Double.parseDouble(functionsapp.getDataPrices(nClient, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva")) * totalImport));
                    txtViewDialogTotal.setText("" + baseApp.formattedNumber((Double.parseDouble(functionsapp.getDataPrices(nClient, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva")) * totalImport) + totalImport));

                    }catch (Exception ex){
                        baseApp.showToast("Ocurrió un error inesperado... " + ex);
                    }
                }
            });

            alert.show();

            btnDialogSave.setOnClickListener(view -> saveDetail(holder));

            btnDialogCancel.setOnClickListener(view -> alert.cancel());
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error, repórtalo al departamento de Sistemas: " + ex);
        }
    }

    public boolean verifyExistDetail(String article){
        SPClass spClass = new SPClass(context);

        if(spClass.intGetSP("nVisit") != 0){
            nVisit = spClass.intGetSP("nVisit");
        }else{
            nVisit = 0;
        }

       realm = Realm.getDefaultInstance();
       RealmResults<DetailsSales> countDetails;
       countDetails = realm.where(DetailsSales.class).equalTo("articulo", article).equalTo("visita", nVisit).findAll();

       if (countDetails.size() > 0) {
           return true;
       }else{
           return false;
       }
    }

    public void saveDetail(ArticlesViewHolder holder) {
        BaseApp baseApp = new BaseApp(context);
        FunctionsApp functionsapp = new FunctionsApp(context);
        SPClass spClass = new SPClass(context);

        try {
            realm = Realm.getDefaultInstance();

            if (spClass.intGetSP("nVisit") != 0) {
                nVisit = spClass.intGetSP("nVisit");
            } else {
                nVisit = 0;
            }

            idRoute = spClass.intGetSP("idRoute");

            if(amount == 0){
                realm.beginTransaction();
                RealmResults<DetailsSales> results = realm.where(DetailsSales.class).equalTo("articulo", articlesList.get(holder.getAdapterPosition()).getArticulo()).equalTo("visita", nVisit).findAll();
                results.deleteAllFromRealm();
                realm.commitTransaction();

                if (context instanceof SalesActivity) {
                    ((SalesActivity) context).refreshTotal();
                }
            }else{

                if (!functionsapp.checkAmountSale(idRoute, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), Integer.parseInt(holder.editTxtAmount.getText().toString()))) {
                    baseApp.showToast("La cantidad supera a la existente en el inventario que es " + functionsapp.getAmountArticleRoute(idRoute, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), false, false));
                    holder.editTxtAmount.setText(Double.toString(functionsapp.getAmountArticleRoute(idRoute, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), false, false)));
                    holder.editTxtAmount.setSelection(holder.editTxtAmount.getText().length());
                }else if (price == 0) {
                    baseApp.showToast("Este cliente no tiene precio configurado para este artículo, revisa en el Sistema.");
                    holder.editTxtAmount.setText("0");
                    holder.editTxtAmount.setSelection(holder.editTxtAmount.getText().length());
                } else {

                    progress = ProgressDialog.show(context, "Registrando artículo",
                            "Espere por favor un momento...");

                    DetailsSales detailsSales;

                    double lnTasaIVA, lnTasaIEPS, lnIVA, lnIEPS;
                    String lcArticulo;

                    lcArticulo = articlesList.get(holder.getAdapterPosition()).getArticulo();
                    lnTasaIVA = Double.parseDouble((functionsapp.getDataPrices(nClient, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva")));
                    lnTasaIEPS = Double.parseDouble((functionsapp.getDataPrices(nClient, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_IEPS")));

                    lnIVA = totalImport * lnTasaIVA;
                    lnIEPS = totalImport * lnTasaIEPS;
                    totalImport = totalImport + lnIVA + lnIEPS;

                    //functionsapp.changeMovementsSalesArticle(idRoute, nVisit, articlesList.get(holder.getAdapterPosition()).getClave_articulo(), Integer.parseInt(editTxtDialogAmount.getText().toString()));

                    realm.beginTransaction();
                    RealmResults<DetailsSales> results = realm.where(DetailsSales.class).equalTo("articulo", articlesList.get(holder.getAdapterPosition()).getArticulo()).equalTo("visita", nVisit).findAll();
                    results.deleteAllFromRealm();
                    realm.commitTransaction();

                    realm.beginTransaction();
                    detailsSales = new DetailsSales(
                            idRoute,
                            nVisit,
                            articlesList.get(holder.getAdapterPosition()).getClave_articulo(),
                            lcArticulo,
                            articlesList.get(holder.getAdapterPosition()).getNombre_articulo().trim(),
                            articlesList.get(holder.getAdapterPosition()).getNombre_unidad(),
                            articlesList.get(holder.getAdapterPosition()).getDescripcion_extendida(),
                            amount,
                            price,
                            lnIVA,
                            lnIEPS,
                            lnTasaIVA,
                            lnTasaIEPS,
                            totalImport);

                    realm.insertOrUpdate(detailsSales);
                    realm.commitTransaction();
                    progress.dismiss();

                    //baseApp.showToast("Artículo registrado");

                    if (context instanceof SalesActivity) {
                        ((SalesActivity) context).refreshTotal();
                    }
                }
            }
                //alert.dismiss();
        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error, repórtalo al departamento de Sistemas: " + ex);
        }
    }
}