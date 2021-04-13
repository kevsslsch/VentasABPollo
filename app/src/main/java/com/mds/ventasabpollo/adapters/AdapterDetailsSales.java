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
import com.mds.ventasabpollo.activities.DetailsSalesActivity;
import com.mds.ventasabpollo.activities.FinalReportActivity;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.Clients;
import com.mds.ventasabpollo.models.DetailsSales;
import com.mds.ventasabpollo.models.VisitsClients;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class AdapterDetailsSales extends RecyclerView.Adapter<AdapterDetailsSales.DetailViewHolder>
        implements View.OnClickListener{

    private Context context;
    private View.OnClickListener listener;
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
    double price, amount, totalImport;
    int idRoute, nVisit, nClient;
    private long mLastClickTime = 0;

    private List<DetailsSales> DetailsSalesList;

    public AdapterDetailsSales(Context context, List<DetailsSales> DetailsSalesList) {
        this.context = context;
        this.DetailsSalesList = DetailsSalesList;
    }

    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_details, parent, false);
        view.setOnClickListener(this);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DetailViewHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final SPClass spClass = new SPClass(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);

        realm = Realm.getDefaultInstance();

        holder.txtDetailNameArticle.setText(DetailsSalesList.get(position).getNombre_articulo().trim());
        holder.txtDetailPrice.setText(baseApp.formattedNumber(DetailsSalesList.get(position).getPrecio()));
        holder.txtDetailAmount.setText(String.valueOf(DetailsSalesList.get(position).getCantidad()));
        holder.txtDetailImport.setText(baseApp.formattedNumber(DetailsSalesList.get(position).getImporte()));

        if(functionsapp.getIsVisitFinished(nVisit)){
                nVisit = DetailsSalesList.get(position).getVisita();
        }else{
            if (spClass.intGetSP("nVisit") != 0) {
                nVisit = spClass.intGetSP("nVisit");
            } else {
                nVisit = 0;
            }
        }

        if(functionsapp.getIsVisitFinished(nVisit)){
            RealmResults<VisitsClients> visits = realm.where(VisitsClients.class).equalTo("id", nVisit).sort("id", Sort.DESCENDING).findAll();
            nClient = visits.get(0).getCliente();
        }else{
            if(spClass.intGetSP("nClient") != 0) {
                nClient = spClass.intGetSP("nClient");
            }else{
                nClient = 0;
            }
        }

        if(context instanceof FinalReportActivity){
            try{
                VisitsClients visit = realm.where(VisitsClients.class).equalTo("id", DetailsSalesList.get(position).getVisita()).findFirst();

                if(visit != null){
                    String name_client = realm.where(Clients.class).equalTo("cliente", visit.getCliente()).findFirst().getNombre_cliente().trim();

                    holder.txtDetailClient.setVisibility(View.VISIBLE);
                    holder.txtDetailClient.setText(name_client);
                }
            }catch (Exception ex) {
                baseApp.showToast("Error al mostrar el nombre de un cliente.");
                ex.printStackTrace();
            }
        }else{
            holder.txtDetailClient.setVisibility(View.GONE);
        }

       holder.layoutDetail.setOnLongClickListener(v -> {

           /*
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                } else {
                    //if (!functionsapp.getIsVisitFinished(nVisit)) {
                        /*if(functionsapp.isSuperUser()) {
                            showDialog(holder);
                        }else{
                            functionsapp.showToast("Función editar desactivada temporalmente.");
                        }*/

                    /*if(functionsapp.getIsVisitFinished(nVisit)){
                        baseApp.showToast("Visita finalizada, no se pueden modificar los datos");
                    }else{
                        if (!functionsapp.getIsVisitSendedDB(nVisit)) {
                            showDialog(holder);
                        }else{
                            baseApp.showToast("No se puede modificar un pedido si ya se envio al Servidor");
                        }
                    }

                    //}
                }
                mLastClickTime = SystemClock.elapsedRealtime();*/
                return false;
            });

       /*holder.layoutDetail.setOnClickListener(new DoubleClickListener() {
                public void onDoubleClick(View v) {
                    if (context instanceof DetailsSalesActivity) {
                        if (!functionsapp.getIsVisitSendedDB(nVisit)) {
                            ((DetailsSalesActivity) context).deleteDetail(DetailsSalesList.get(position).getClave_articulo(), DetailsSalesList.get(position).getArticulo(), DetailsSalesList.get(position).getNombre_articulo());
                            ((DetailsSalesActivity) context).getDetailsSale();
                        }else{
                            baseApp.showToast("No se puede borrar un registro si ya se envio al Servidor");
                        }
                    }
                }
            });*/
    }

    @Override
    public int getItemCount() {
        return DetailsSalesList.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder {

        TextView txtDetailNameArticle, txtDetailClient, txtDetailPieces, txtDetailPrice, txtDetailAmount, txtDetailImport;
        LinearLayout layoutDetail;

        public DetailViewHolder(View itemView) {
            super(itemView);

            txtDetailClient = itemView.findViewById(R.id.txtDetailClient);
            txtDetailNameArticle = itemView.findViewById(R.id.txtDetailNameArticle);
            txtDetailPrice = itemView.findViewById(R.id.txtDetailPrice);
            txtDetailAmount = itemView.findViewById(R.id.txtDetailAmount);
            txtDetailImport = itemView.findViewById(R.id.txtDetailImport);
            layoutDetail = itemView.findViewById(R.id.layoutDetail);
        }
    }

    public void showDialog(final DetailViewHolder holder){
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
            editTxtDialogAmount.setText(String.valueOf(DetailsSalesList.get(holder.getAdapterPosition()).getCantidad()));

            editTxtDialogPrice.setSelectAllOnFocus(true);
            editTxtDialogAmount.setSelectAllOnFocus(true);

            layoutDialogAlert.setVisibility(View.GONE);

            txtDialogArticleKey.setText("Artículo: " + DetailsSalesList.get(holder.getAdapterPosition()).getArticulo().trim());
            txtDialogNameArticle.setText(DetailsSalesList.get(holder.getAdapterPosition()).getNombre_articulo().trim());
            txtDialogUM.setText("Unidad de Medida: " + DetailsSalesList.get(holder.getAdapterPosition()).getNombre_unidad().trim());
            txtDialogDescription.setText("Descripción: " + DetailsSalesList.get(holder.getAdapterPosition()).getDescripcion_extendida().trim());
            txtDialogIVA.setText("I.V.A. (" + baseApp.getPercentage(functionsapp.getDataPrices(nClient, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva")) + ")");

            editTxtDialogPrice.setText(baseApp.formattedNumber(DetailsSalesList.get(holder.getAdapterPosition()).getPrecio()));

            Bitmap bitmap;
            if (functionsapp.getBase64(DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), "articles").isEmpty()) {
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.no_foto);
            } else {
                byte[] decodedString = Base64.decode(functionsapp.getBase64(DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), "articles"), Base64.DEFAULT);
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

            txtViewDialogImport.setText(baseApp.formattedNumber(totalImport));
            txtViewDialogIVA.setText(baseApp.formattedNumber(Double.parseDouble(functionsapp.getDataPrices(nClient, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva")) * totalImport));

            double tasaIVA, totalIVA, totalImportWithIVA;
            tasaIVA = Double.parseDouble(functionsapp.getDataPrices(nClient, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva"));
            totalIVA = tasaIVA * totalImport;
            totalImportWithIVA = totalIVA + totalImport;

            txtViewDialogTotal.setText(baseApp.formattedNumber(totalImportWithIVA));

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

                    try {
                        price = Double.parseDouble(valuePrice);
                        amount = Double.parseDouble(valueAmount);
                    } catch (Exception ex) {
                        baseApp.showToast("Error, repórtalo al dpto de Sistemas: " + ex);
                        txtViewDialogImport.setText("0.0");
                    }

                    //totalImport = functionsapp.round(price * amount);
                    totalImport = price * amount;

                    txtViewDialogImport.setText(baseApp.formattedNumber(totalImport));
                    txtViewDialogIVA.setText(baseApp.formattedNumber(Double.parseDouble(functionsapp.getDataPrices(nClient, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva")) * totalImport));

                    double tasaIVA, totalIVA, totalImportWithIVA;
                    tasaIVA = Double.parseDouble(functionsapp.getDataPrices(nClient, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva"));
                    totalIVA = tasaIVA * totalImport;
                    totalImportWithIVA = totalIVA + totalImport;

                    txtViewDialogTotal.setText(baseApp.formattedNumber(totalImportWithIVA));
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
                        if(!functionsapp.checkAmountSale(idRoute, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), Double.parseDouble(editTxtDialogAmount.getText().toString()))){
                            baseApp.showToast("La cantidad supera a la existente en inventario, se remplazará a la máxima posible.");
                            editTxtDialogAmount.setText(Double.toString(functionsapp.getAmountArticleRoute(idRoute, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), false, false)));
                            editTxtDialogAmount.setSelection(editTxtDialogAmount.getText().length());
                        }
                    }

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

                    txtViewDialogImport.setText(baseApp.formattedNumber(totalImport));
                    txtViewDialogIVA.setText(baseApp.formattedNumber(Double.parseDouble(functionsapp.getDataPrices(nClient, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva")) * totalImport));

                    double tasaIVA, totalIVA, totalImportWithIVA;
                    tasaIVA = Double.parseDouble(functionsapp.getDataPrices(nClient, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva"));
                    totalIVA = tasaIVA * totalImport;
                    totalImportWithIVA = totalIVA + totalImport;

                    txtViewDialogTotal.setText(baseApp.formattedNumber(totalImportWithIVA));
                }
            });

            alert.show();

            btnDialogSave.setOnClickListener(v -> updateDetail(holder));

            btnDialogCancel.setOnClickListener(view -> {
                alert.cancel();
                //closeKeyboard();
            });
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error, repórtalo al departamento de Sistemas: " + ex);
        }
    }

    public void updateDetail(DetailViewHolder holder) {
        BaseApp baseApp = new BaseApp(context);
        FunctionsApp functionsApp = new FunctionsApp(context);
        SPClass spClass = new SPClass(context);

        try {
            realm = Realm.getDefaultInstance();

            if (amount == 0) {
                baseApp.showAlert("Error", "No puedes actualizar un detalle sin cantidad");
            } else if (price == 0) {
                baseApp.showAlert("Error", "No puedes actualizar un detalle con precio $0");
            } else {

                progress = ProgressDialog.show(context, "Actualizando artículo",
                        "Espere por favor un momento...");

                DetailsSales detail = null;

                double lnTasaIVA, lnTasaIEPS, lnIVA, lnIEPS;
                String lcArticulo;

                lcArticulo = DetailsSalesList.get(holder.getAdapterPosition()).getArticulo();
                lnTasaIVA = Double.parseDouble((functionsApp.getDataPrices(nClient, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_iva")));
                lnTasaIEPS = Double.parseDouble((functionsApp.getDataPrices(nClient, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), "tasa_IEPS")));

                lnIVA = totalImport * lnTasaIVA;
                lnIEPS = totalImport * lnTasaIEPS;
                totalImport = totalImport + lnIVA + lnIEPS;

                if(functionsApp.checkAmountSale(idRoute, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), Double.parseDouble(editTxtDialogAmount.getText().toString()))) {
                    //functionsApp.changeMovementsSalesArticle(idRoute, nVisit, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), Integer.parseInt(editTxtDialogAmount.getText().toString()));

                    RealmResults<DetailsSales> details = realm.where(DetailsSales.class).equalTo("clave_articulo", DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo()).equalTo("visita", nVisit).findAll();

                    realm.beginTransaction();
                    detail = details.get(0);
                    detail.setCantidad(amount);
                    detail.setImporte(totalImport);
                    detail.setIVA(lnIVA);
                    detail.setIEPS(lnIEPS);

                    realm.insertOrUpdate(detail);
                    realm.commitTransaction();
                    progress.dismiss();
                    baseApp.showToast("Artículo actualizado");

                    if (context instanceof DetailsSalesActivity) {
                        ((DetailsSalesActivity) context).refreshTotales();
                        ((DetailsSalesActivity) context).getDetailsSale();
                    }
                }else{
                    baseApp.showToast("La cantidad supera a la existente en el inventario que es: " + functionsApp.getAmountArticleRoute(idRoute, DetailsSalesList.get(holder.getAdapterPosition()).getClave_articulo(), false, false));
                }

                alert.dismiss();
            }
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error, repórtalo al departamento de Sistemas: " + ex);
        }
    }
}