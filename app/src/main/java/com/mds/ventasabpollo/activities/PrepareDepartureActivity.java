package com.mds.ventasabpollo.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterArticlesChangeInventory;
import com.mds.ventasabpollo.adapters.AdapterArticlesPrepareDeparture;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.models.Articles;
import com.mds.ventasabpollo.models.ChangesInventories;
import com.mds.ventasabpollo.models.Inventories;
import com.mds.ventasabpollo.models.PrepareDeparture;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;

public class PrepareDepartureActivity extends AppCompatActivity {

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsApp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private RealmResults<Articles> listArticles;
    int idRoute, nUser, totalArticles;

    RecyclerView recyclerArticles;
    RelativeLayout layoutList, layoutNotData;
    SearchView searchArticles;

    FloatingActionButton fbtnBack, fbtnSave;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare_departure);

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");
        idRoute = spClass.intGetSP("idRoute");

        recyclerArticles = findViewById(R.id.recyclerArticles);
        layoutList = findViewById(R.id.layoutListArticles);
        layoutNotData = findViewById(R.id.layoutNotData);
        searchArticles = findViewById(R.id.searchArticles);

        fbtnSave = findViewById(R.id.fbtnSave);
        fbtnBack = findViewById(R.id.fbtnBack);
        btnSend = findViewById(R.id.btnSend);

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerArticles.setLayoutManager(mGridLayoutManagerDetails);
        recyclerArticles.setItemAnimator(new DefaultItemAnimator());
        recyclerArticles.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        searchArticles.setOnClickListener(v -> searchArticles.onActionViewExpanded());
        searchArticles.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchArticles.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                try {
                    getArticles(newText);
                }catch (Exception ex){
                    baseApp.showToast("Ocurrió un error");
                    baseApp.showLog("Ocurrió el error" + ex);
                }
                return false;
            }
        });

        getArticles("");

        fbtnBack.setOnClickListener(v-> backFunction());
        fbtnSave.setOnClickListener(v-> save());
        btnSend.setOnClickListener(v-> askSend());

        baseApp.darkenStatusBar(this, Color.WHITE);
    }

    public void getArticles(String text) {
        final FunctionsApp functionsapp = new FunctionsApp(this);

        try {
            realm = Realm.getDefaultInstance();

            if(text.isEmpty()){
                listArticles = realm.where(Articles.class).limit(30).findAll();
            }else {
                listArticles = realm.where(Articles.class)
                        .contains("articulo", text, Case.INSENSITIVE)
                        .or()
                        .contains("nombre_articulo", text, Case.INSENSITIVE)
                        .limit(30).findAll();
            }

            totalArticles = listArticles.size();

            if(totalArticles > 0){
                layoutList.setVisibility(View.VISIBLE);
                layoutNotData.setVisibility(View.GONE);

                AdapterArticlesPrepareDeparture adapterArticlesPrepareDeparture = new AdapterArticlesPrepareDeparture(this, listArticles);

                recyclerArticles.setItemAnimator(new DefaultItemAnimator());
                recyclerArticles.setAdapter(adapterArticlesPrepareDeparture);
            }else{
                recyclerArticles.setAdapter(null);
            }

        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los artículos, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void save(){
        try{
            baseApp.showToast("Preparar Ruta modificada con éxito.");
            finish();
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error interno.");
        }
    }

    /*public void save(){

        try{
            int count = 0;

            if (recyclerArticles.getAdapter() != null) {
                count = recyclerArticles.getAdapter().getItemCount();

                for (int i = 0; i < count; i++) {
                    AdapterArticlesPrepareDeparture.ArticlesViewHolder holder = ((AdapterArticlesPrepareDeparture) recyclerArticles.getAdapter()).getViewByPosition(i);

                    if (holder != null) {
                        View view = holder.itemView;

                        int key;
                        double value;

                        TextView txtKey = view.findViewById(R.id.txtKey);
                        EditText editTxtViewAmount = view.findViewById(R.id.editTxtViewAmount);

                        if (txtKey.getText().toString().length() > 0) {
                            key = Integer.valueOf(txtKey.getText().toString());
                        } else {
                            key = 0;
                        }

                        if (editTxtViewAmount.getText().toString().length() > 0) {
                            value = Double.valueOf(editTxtViewAmount.getText().toString());
                        } else {
                            value = 0;
                        }

                        baseApp.showLog("PREPARAR RUTA\n" +
                                "Clave:" + key + "\n" +
                                "Cantidad: " + value);

                        RealmResults<PrepareDeparture> prepareDepartures = realm.where(PrepareDeparture.class)
                                .equalTo("clave_articulo", key)
                                .findAll();

                        realm.beginTransaction();

                        if (prepareDepartures.size() > 0) {
                            if(value == 0){
                                prepareDepartures.get(0).deleteFromRealm();
                            }else{
                                prepareDepartures.get(0).setCantidad(value);
                            }
                        } else {

                            if(value != 0){
                                PrepareDeparture prepareDeparture = new PrepareDeparture(
                                        key,
                                        value);

                                realm.insertOrUpdate(prepareDeparture);
                            }
                        }

                        realm.commitTransaction();
                    }
                }

                baseApp.showToast("Preparar Ruta modificada con éxito.");
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }

        finish();
    }*/

    public void askSend(){
        try{

            realm = Realm.getDefaultInstance();
            String articles = "";

            RealmResults<PrepareDeparture> detailsPrepareDeparture = realm.where(PrepareDeparture.class).findAll();

            for(PrepareDeparture detail: detailsPrepareDeparture){
                articles += detail.getCantidad() + " - " + functionsApp.getArticle(detail.getClave_articulo()).getNombre_articulo().trim() + "\n\n";
            }

            new AlertDialog.Builder(this)
                    .setTitle("Confirme las cantidades de la próxima Ruta")
                    .setMessage(articles)
                    .setCancelable(true)
                    .setPositiveButton("Enviar", (dialog, id) -> backgroundProcess("send"))
                    .setNegativeButton("Cancelar", null)
                    .show();
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error interno.");
            ex.printStackTrace();
        }
    }

    public void send(){

        try {
            PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.Guarda_Salida_Android ?, ?");
            if (loComando == null) {
                baseApp.showLog("Error al Crear SP Guarda_Salida_Android");

            } else {
                try {

                    loComando.setInt(1, nUser);
                    loComando.setString(2, functionsApp.generateSplitPrepareDeparture());

                    ResultSet Datos = loComando.executeQuery();

                    while (Datos.next()) {

                        if (Datos.getInt("exito") == 1) {
                            baseApp.showToast("Salida enviada éxito");

                            realm.beginTransaction();
                            realm.delete(PrepareDeparture.class);
                            realm.commitTransaction();

                            finish();
                        }
                    }
                } catch (Exception ex) {
                    baseApp.showLog("Error en SP Guarda_Salida_Android, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
                }
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    public void backgroundProcess(String process){
        Handler handler;
        ProgressDialog dialog;

        dialog = new ProgressDialog(this);

        dialog.setMessage("Espera unos momentos...");
        dialog.setCancelable(false);
        dialog.show();

        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {

            try {
                if(baseApp.verifyServerConnection()) {
                    if(baseApp.isOnline(this)) {

                        switch (process){
                            case "send":
                               send();
                               break;
                            default:
                                return;
                        }

                    } else {
                        baseApp.showAlertDialog("error", "Error", "Prende tu señal de datos o conéctate a una red WIFI para poder descargar los datos", true);
                    }
                }else{
                    baseApp.showAlertDialog("error", "Error", "No hay conexión al Servidor, reconfigura los datos de conexión e inténtalo de nuevo.", true);
                }

            } catch (Exception ex) {
                baseApp.showAlert("Error", "Ocurrió un error, reporta el siguiente error al Dpto de Sistemas: " + ex);
            }

            try{
                if(dialog.isShowing()) {
                    dialog.dismiss();
                }
            }catch (Exception ex){
                baseApp.showLog("Ocurrió un error.");
            }


        }, 1000);
    }

    public void backFunction(){
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        backFunction();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
