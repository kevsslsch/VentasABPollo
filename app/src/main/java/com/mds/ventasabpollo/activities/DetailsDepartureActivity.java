package com.mds.ventasabpollo.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterDetailsDeparturesB;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.models.DetailsDepartures;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class DetailsDepartureActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<DetailsDepartures>> {

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsApp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private RealmResults<DetailsDepartures> listArticles;
    int idRoute, nUser, nList, nDeparture, totalArticles;
    String sNameAuthorized;

    RecyclerView recyclerArticles;
    RelativeLayout layoutList, layoutNotData;

    FloatingActionButton fbtnBack, fbtnSave;

    private ProgressDialog dialog;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_departure);
        getSupportActionBar().hide();

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");
        idRoute = spClass.intGetSP("idRoute");

        recyclerArticles = findViewById(R.id.recyclerArticles);
        layoutList = findViewById(R.id.layoutListClients);
        layoutNotData = findViewById(R.id.layoutNotData);
        fbtnBack = findViewById(R.id.fbtnBack);
        fbtnSave = findViewById(R.id.fbtnSave);

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerArticles.setLayoutManager(mGridLayoutManagerDetails);
        recyclerArticles.setItemAnimator(new DefaultItemAnimator());
        recyclerArticles.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        if (getIntent().getExtras() != null) {
            nDeparture = getIntent().getExtras().getInt("nDeparture");
            sNameAuthorized = getIntent().getExtras().getString("sNameAuthorized");
        }else{
            nDeparture = 0;
            baseApp.showToast("No se pudo seleccionar una Salida");
            finish();
        }

        fbtnBack.setOnClickListener(v -> backFunction());
        fbtnSave.setOnClickListener(v-> backgroundProcess("markDepartureLikeAccepted", "bar", ""));

        getArticles();

        dialog = new ProgressDialog(this);

        baseApp.darkenStatusBar(this, Color.WHITE);
    }

    public void getArticles() {
        final FunctionsApp functionsapp = new FunctionsApp(this);

        try {
            realm = Realm.getDefaultInstance();
            listArticles = realm.where(DetailsDepartures.class).equalTo("salida", nDeparture).findAll();
            totalArticles = listArticles.size();
            listArticles.addChangeListener(this);

            if(totalArticles > 0){
                layoutList.setVisibility(View.VISIBLE);
                layoutNotData.setVisibility(View.GONE);

                AdapterDetailsDeparturesB adapterDetailsDepartures = new AdapterDetailsDeparturesB(this, listArticles);

                recyclerArticles.setItemAnimator(new DefaultItemAnimator());
                recyclerArticles.setAdapter(adapterDetailsDepartures);
            }else{
                baseApp.showToast("No hay artículos para mostrar.");
            }

        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los artículos, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void markDepartureLikeAccepted(int nDeparture){

        try {
            PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.Acepta_Salida_Ventas ?, ?");
            if (loComando == null) {
                baseApp.showLog("Error al Crear SP Acepta_Salida_Ventas");

            } else {
                try {

                    loComando.setInt(1, nDeparture);
                    loComando.setString(2, "Aceptada");

                    ResultSet Datos = loComando.executeQuery();

                    while (Datos.next()) {

                        if (Datos.getInt("exito") == 1) {
                            baseApp.showToast("Salida marcada como Aceptada con éxito");

                            functionsApp.startRoute(nDeparture, 0, sNameAuthorized);
                        }else{
                            baseApp.showAlert("Error", "Ocurrió un error, lo más probable es que esta salida ya esté en uso por alguien más.");
                        }
                    }
                } catch (Exception ex) {
                    baseApp.showLog("Error en SP Acepta_Salida_Ventas, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
                }
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    public void backgroundProcess(String process, String typeLoad, String title){

        switch (typeLoad){
            case "bar":
                dialog.setTitle(title);
                dialog.setMessage("Espera unos momentos...");
                dialog.setCancelable(false);
                dialog.show();
                break;
            default:
                return;
        }

        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {

            try {

                if(baseApp.verifyServerConnection()) {
                    if (baseApp.isOnline(this)) {

                        switch (process){
                            case "markDepartureLikeAccepted":
                                markDepartureLikeAccepted(nDeparture);
                                break;
                            default:
                                return;
                        }

                    } else {

                        if(process.equals("checkConnnection")){
                            baseApp.showToast("Conéctate a Internet o revisa la conexión al Servidor");
                            finish();
                        }else{
                            baseApp.showAlertDialog("error", "Error", "Prende tu señal de datos o conéctate a una red WIFI para poder descargar los datos", true);
                        }
                    }
                }else{
                    if(process.equals("checkConnnection")){
                        baseApp.showToast("Conéctate a Internet o revisa la conexión al Servidor");
                        finish();
                    }else{
                        baseApp.showAlertDialog("error", "Error", "No hay conexión al Servidor, reconfigura los datos de conexión e inténtalo de nuevo.", true);
                    }
                }

            } catch (Exception ex) {
                baseApp.showAlert("Error", "Ocurrió un error, reporta el siguiente error al Dpto de Sistemas: " + ex);
            }

            dialog.dismiss();
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

    @Override
    public void onChange(RealmResults<DetailsDepartures> detailsDepartures) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
