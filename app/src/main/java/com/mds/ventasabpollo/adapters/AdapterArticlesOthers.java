package com.mds.ventasabpollo.adapters;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.Articles;
import com.mds.ventasabpollo.models.VisitsMovements;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmResults;

public class AdapterArticlesOthers extends RecyclerView.Adapter<AdapterArticlesOthers.ArticlesViewHolder>{

    private Context context;
    private List<Articles> listArticles;
    int nClient, nVisit, idRoute;
    double initialAmountSale, initialAmountDevolution, initialAmountChanges, initialAmountSeparated;

    final Calendar myCalendar = Calendar.getInstance();

    VisitsMovements movements;
    Realm realm;

    private static List<Double> mEditTextValuesDevolutions = new ArrayList<>();
    private static List<Double> mEditTextValuesChanges = new ArrayList<>();

    public AdapterArticlesOthers(Context context, List<Articles> listArticles) {
        this.context = context;
        this.listArticles = listArticles;

        if (mEditTextValuesDevolutions != null) {
            mEditTextValuesDevolutions.clear();
        }

        if (mEditTextValuesChanges != null) {
            mEditTextValuesChanges.clear();
        }

        for (int i = 1; i <= listArticles.size(); i++) {
            mEditTextValuesDevolutions.add(0.0);
            mEditTextValuesChanges.add(0.0);
        }
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_articles_others, parent, false);
        return new ArticlesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ArticlesViewHolder holder, final int position) {
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);
        double amountDevolution, amountChanges;

        realm = Realm.getDefaultInstance();

        idRoute = spClass.intGetSP("idRoute");
        nVisit  = spClass.intGetSP("nVisit");

        if(spClass.intGetSP("nClient") != 0) {
            nClient = spClass.intGetSP("nClient");
        }else{
            nClient = 0;
        }

        try{
            movements = realm.where(VisitsMovements.class).equalTo("ruta", idRoute)
                    .equalTo("visita", nVisit)
                    .equalTo("clave_articulo", listArticles.get(position).getClave_articulo())
                    .findFirst();
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error");
        }

        //initialiteAmounts(position);

        amountDevolution = movements.getPiezas_devolucion();
        amountChanges = movements.getPiezas_cambio();

        holder.editTxtAmountDevolution.setTag(position);
        holder.editTxtAmountChanges.setTag(position);

        holder.editTxtAmountDevolution.setSelectAllOnFocus(true);
        holder.editTxtAmountChanges.setSelectAllOnFocus(true);
        holder.editTxtAmountSeparated.setSelectAllOnFocus(true);

        holder.txtName_Article.setText(listArticles.get(position).getNombre_articulo().trim());

        if(mEditTextValuesDevolutions.get(position) == 0 && amountDevolution != 0){
            mEditTextValuesDevolutions.set(position, amountDevolution);
            holder.editTxtAmountDevolution.setText(Double.toString(amountDevolution));
        }else{
            holder.editTxtAmountDevolution.setText(Double.toString(mEditTextValuesDevolutions.get(position)));
        }

        if(mEditTextValuesChanges.get(position) == 0 && amountChanges != 0){
            mEditTextValuesChanges.set(position, amountChanges);
            holder.editTxtAmountChanges.setText(Double.toString(amountChanges));
        }else{
            holder.editTxtAmountChanges.setText(Double.toString(mEditTextValuesChanges.get(position)));
        }

        //holder.editTxtAmountSeparated.setText(Double.toString(functionsapp.getDataInventoryVisit(idRoute, nVisit, listArticles.get(position).getClave_articulo(), "apartado")));

        //refreshFlags(holder, position);
        //verifyChanges(holder, position);

        holder.editTxtAmountDevolution.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(holder.editTxtAmountDevolution.getText().length() > 0){
                    if(!functionsapp.checkAmountDevolution(idRoute, listArticles.get(holder.getAdapterPosition()).getClave_articulo(), Double.parseDouble(holder.editTxtAmountDevolution.getText().toString()))){
                        baseApp.showToast("La cantidad supera a la existente en inventario, se remplazará a la máxima posible.");
                        holder.editTxtAmountDevolution.setText(Double.toString(functionsapp.getAmountArticleRoute(idRoute, listArticles.get(holder.getAdapterPosition()).getClave_articulo(), true, false)));
                        holder.editTxtAmountDevolution.setSelection(holder.editTxtAmountDevolution.getText().length());
                    }
                }

                saveInfo(holder, position);
            }
        });


        holder.editTxtAmountChanges.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(holder.editTxtAmountChanges.getText().length() > 0){
                    if(!functionsapp.checkAmountDevolution(idRoute, listArticles.get(holder.getAdapterPosition()).getClave_articulo(), Double.parseDouble(holder.editTxtAmountChanges.getText().toString()))){
                        baseApp.showToast("La cantidad supera a la existente en inventario, se remplazará a la máxima posible.");
                        holder.editTxtAmountChanges.setText(Double.toString(functionsapp.getAmountArticleRoute(idRoute, listArticles.get(holder.getAdapterPosition()).getClave_articulo(), true, false)));
                        holder.editTxtAmountChanges.setSelection(holder.editTxtAmountChanges.getText().length());
                    }
                }
                saveInfo(holder, position);
            }
        });

        /*
        holder.editTxtAmountSeparated.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                saveInfo(holder, position);
            }
        });

        holder.editDateValue.setOnClickListener(v -> {
            if(!functionsapp.getIsVisitFinished(nVisit)){
                showCalendar(holder, position);
            }
        });*/

        if(functionsapp.getIsVisitFinished(nVisit)){
            holder.editTxtAmountDevolution.setEnabled(false);
            holder.editTxtAmountChanges.setEnabled(false);
            holder.editTxtAmountSeparated.setEnabled(false);
        }else{
            holder.editTxtAmountDevolution.setEnabled(true);
            holder.editTxtAmountChanges.setEnabled(true);
            holder.editTxtAmountSeparated.setEnabled(true);
        }
    }

    public void showCalendar(ArticlesViewHolder holder, int position){
        DatePickerDialog.OnDateSetListener date = (view, year, monthOfYear, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabelDate(holder, position);
        };

        new DatePickerDialog(context, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void updateLabelDate(ArticlesViewHolder holder, int position){
        BaseApp baseApp = new BaseApp(context);

        try {
            String myFormat = "yyyy-MM-dd"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            holder.editDateValue.setText(sdf.format(myCalendar.getTime()));

            RealmResults<VisitsMovements> movements = realm.where(VisitsMovements.class).equalTo("ruta", idRoute).equalTo("visita", nVisit).equalTo("clave_articulo", listArticles.get(position).getClave_articulo()).findAll();
            realm.beginTransaction();
            movements.get(0).setFecha_apartado(sdf.format(myCalendar.getTime()));
            realm.commitTransaction();

            baseApp.showToast("Fecha de apartado actualizada");

            refreshFlags(holder, position);
        }catch (Exception ex){
            baseApp.showAlert("Error", "Reporta este error: " + ex);
        }
    }

    public void saveInfo(ArticlesViewHolder holder, int position){

        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        try{
            double amountDevolution, amountChanges, amountSeparated;

            if(holder.editTxtAmountDevolution.getText().toString().length() == 0){
                amountDevolution = 0;
            }else{
                amountDevolution = Double.valueOf(holder.editTxtAmountDevolution.getText().toString());
            }

            if(holder.editTxtAmountChanges.getText().toString().length() == 0){
                amountChanges = 0;
            }else{
                amountChanges = Double.valueOf(holder.editTxtAmountChanges.getText().toString());
            }

            if(holder.editTxtAmountSeparated.getText().toString().length() == 0){
                amountSeparated = 0;
            }else{
                amountSeparated = Double.valueOf(holder.editTxtAmountSeparated.getText().toString());
            }

            /*if(functionsapp.getDataInventoryVisit(idRoute, nVisit, listArticles.get(position).getClave_articulo(), "apartado") != amountSeparated) {
                RealmResults<VisitsMovements> visitMovements = realm.where(VisitsMovements.class).equalTo("ruta", idRoute).equalTo("visita", nVisit).equalTo("clave_articulo", listArticles.get(position).getClave_articulo()).findAll();

                if(visitMovements.get(0).getFecha_apartado().equals("")){
                    realm.beginTransaction();
                    movements.get(0).setFecha_apartado("2000-01-01");
                    realm.commitTransaction();
                }

                /*if(functionsapp.getDataInventoryVisit(idRoute, nVisit, listArticles.get(position).getClave_articulo(), "apartado") == 0){
                        holder.layoutDate.setVisibility(View.GONE);
                }else{
                        holder.layoutDate.setVisibility(View.VISIBLE);
                }* /
            }*/

            functionsapp.changeMovementsArticle(idRoute, nVisit, listArticles.get(holder.getAdapterPosition()).getClave_articulo(), amountDevolution, amountChanges, amountSeparated, "");
            //refreshFlags(holder, position);
            //initialiteAmounts(position);
            //verifyChanges(holder, position);
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    public void initialiteAmounts(int position){
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        try{
            /*initialAmountSale = functionsapp.getDataInventoryVisit(idRoute, nVisit, listArticles.get(position).getClave_articulo(), "venta");
            initialAmountDevolution = functionsapp.getDataInventoryVisit(idRoute, nVisit, listArticles.get(position).getClave_articulo(), "devolucion");
            initialAmountChanges = functionsapp.getDataInventoryVisit(idRoute, nVisit, listArticles.get(position).getClave_articulo(), "cambio");
            initialAmountSeparated = functionsapp.getDataInventoryVisit(idRoute, nVisit, listArticles.get(position).getClave_articulo(), "apartado");*/
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    @SuppressLint("RestrictedApi")
    public void verifyChanges(ArticlesViewHolder holder, int position){
        /*
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);
        int amountSale, amountDevolution, amountChanges, amountSeparated;

        try {
            //amountSalef = Double.valueOf(holder.editTxtAmountSale.getText().toString());
            if(holder.editTxtAmountDevolution.getText().toString().length() == 0){
                amountDevolution = 0;
            }else{
                amountDevolution = Double.valueOf(holder.editTxtAmountDevolution.getText().toString());
            }

            if(holder.editTxtAmountChanges.getText().toString().length() == 0){
                amountChanges = 0;
            }else{
                amountChanges = Double.valueOf(holder.editTxtAmountChanges.getText().toString());
            }

            if(holder.editTxtAmountSeparated.getText().toString().length() == 0){
                amountSeparated = 0;
            }else{
                amountSeparated = Double.valueOf(holder.editTxtAmountSeparated.getText().toString());
            }

            if(initialAmountDevolution != amountDevolution ||
                initialAmountChanges != amountChanges ||
                initialAmountSeparated != amountSeparated){

                holder.fbtnSave.setVisibility(View.VISIBLE);

            }else{
                holder.fbtnSave.setVisibility(View.GONE);
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }*/
    }

    public void refreshFlags(ArticlesViewHolder holder, int position){
        final BaseApp baseApp = new BaseApp(context);
        final FunctionsApp functionsapp = new FunctionsApp(context);
        final SPClass spClass = new SPClass(context);

        try{
            /*if(functionsapp.getDataInventoryVisit(idRoute, nVisit, listArticles.get(position).getClave_articulo(), "devolucion") > 0){
                holder.txtDevolutions.setVisibility(View.VISIBLE);
            }else{
                holder.txtDevolutions.setVisibility(View.GONE);
            }

            if(functionsapp.getDataInventoryVisit(idRoute, nVisit, listArticles.get(position).getClave_articulo(), "cambio") > 0){
                holder.txtChanges.setVisibility(View.VISIBLE);
            }else{
                holder.txtChanges.setVisibility(View.GONE);
            }

            if(functionsapp.getDataInventoryVisit(idRoute, nVisit, listArticles.get(position).getClave_articulo(), "apartado") > 0){
                holder.txtSeparated.setVisibility(View.VISIBLE);
            }else{
                holder.txtSeparated.setVisibility(View.GONE);
            }*/

            /*RealmResults<VisitsMovements> movements = realm.where(VisitsMovements.class).equalTo("ruta", idRoute).equalTo("visita", nVisit).equalTo("clave_articulo", listArticles.get(position).getClave_articulo()).findAll();

            if(movements.size() > 0 && !movements.get(0).getFecha_apartado().equals("")){
                holder.editDateValue.setText(movements.get(0).getFecha_apartado());
            }*/

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }

    }

    @Override
    public int getItemCount() {
        return listArticles.size();
    }

    public class ArticlesViewHolder extends RecyclerView.ViewHolder {
        final BaseApp baseApp = new BaseApp(context);
        TextView txtName_Article, txtDialogUM, txtDialogDescription, txtDevolutions, txtChanges, txtSeparated;
        EditText editTxtAmountDevolution, editTxtAmountChanges, editTxtAmountSeparated, editDateValue;
        FloatingActionButton fbtnSave;
        LinearLayout layoutArticle, layoutDate;

        public ArticlesViewHolder(View itemView) {
            super(itemView);
            layoutArticle = itemView.findViewById(R.id.layoutArticle);
            layoutDate = itemView.findViewById(R.id.layoutDate);

            txtName_Article = itemView.findViewById(R.id.txtNameArticle);
            txtDialogUM = itemView.findViewById(R.id.txtDialogUM);
            txtDialogDescription = itemView.findViewById(R.id.txtDialogDescription);
            txtDevolutions = itemView.findViewById(R.id.txtDevolutions);
            txtChanges = itemView.findViewById(R.id.txtChanges);
            txtSeparated = itemView.findViewById(R.id.txtSeparated);
            editDateValue = itemView.findViewById(R.id.editDateValue);

            editTxtAmountDevolution = itemView.findViewById(R.id.editTxtAmountDevolution);
            editTxtAmountChanges = itemView.findViewById(R.id.editTxtAmountChanges);
            editTxtAmountSeparated = itemView.findViewById(R.id.editTxtAmountSeparated);

            fbtnSave = itemView.findViewById(R.id.fbtnSave);

            editTxtAmountDevolution.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                public void afterTextChanged(Editable editable) {}
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(editTxtAmountDevolution.getTag()!=null) {

                        if (charSequence.length() == 0) {
                            mEditTextValuesDevolutions.set((int) editTxtAmountDevolution.getTag(), 0.0);
                        } else if (charSequence.length() > 9) {
                            mEditTextValuesDevolutions.set((int) editTxtAmountDevolution.getTag(), Double.valueOf(charSequence.toString().substring(0, 9)));
                        } else {
                            mEditTextValuesDevolutions.set((int) editTxtAmountDevolution.getTag(), Double.valueOf(charSequence.toString()));
                        }
                    }
                }
            });

            editTxtAmountChanges.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
                public void afterTextChanged(Editable editable) {}
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(editTxtAmountChanges.getTag()!=null) {

                        if (charSequence.length() == 0) {
                            mEditTextValuesChanges.set((int) editTxtAmountChanges.getTag(), 0.0);
                        } else if (charSequence.length() > 9) {
                            mEditTextValuesChanges.set((int) editTxtAmountChanges.getTag(), Double.valueOf(charSequence.toString().substring(0, 9)));
                        } else {
                            mEditTextValuesChanges.set((int) editTxtAmountChanges.getTag(), Double.valueOf(charSequence.toString()));
                        }
                    }
                }
            });
        }
    }
}