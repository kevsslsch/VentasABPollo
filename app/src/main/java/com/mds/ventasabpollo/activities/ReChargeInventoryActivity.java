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
import com.mds.ventasabpollo.adapters.AdapterDetailsRechargeInventories;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.ConnectionClass;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.models.DetailsDepartures;
import com.mds.ventasabpollo.models.RechargeInventories;
import com.mds.ventasabpollo.models.Routes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class ReChargeInventoryActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<DetailsDepartures>> {

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsApp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private RealmResults<DetailsDepartures> listArticles;
    int idRoute, nUser, nRecharge, nDeparture, totalArticles;
    String sNameAuthorized;

    RecyclerView recyclerArticles;
    RelativeLayout layoutList, layoutNotData;

    FloatingActionButton fbtnBack, fbtnSave;

    private ProgressDialog dialog;
    Handler handler;

    ArrayList<RechargeInventories> rechargeInventoriesArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_inventory);
        getSupportActionBar().hide();

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");
        idRoute = spClass.intGetSP("idRoute");
        dialog = new ProgressDialog(this);

        recyclerArticles = findViewById(R.id.recyclerArticles);
        layoutList = findViewById(R.id.layoutListClients);
        layoutNotData = findViewById(R.id.layoutNotData);
        fbtnBack = findViewById(R.id.fbtnBack);
        fbtnSave = findViewById(R.id.fbtnSave);

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerArticles.setLayoutManager(mGridLayoutManagerDetails);
        recyclerArticles.setItemAnimator(new DefaultItemAnimator());
        recyclerArticles.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        RealmResults<Routes> routes = realm.where(Routes.class).equalTo("ruta", idRoute).findAll();
        nDeparture = routes.get(0).getSalida();

        fbtnBack.setOnClickListener(v -> backFunction());
        fbtnSave.setOnClickListener(v-> backgroundProcess("markRechargeLikeAccepted", "bar", "Confirmando Recarga de Mercancia..."));

        backgroundProcess("searchReCharge", "bar", "Buscando Recargas de Inventario...");

        baseApp.darkenStatusBar(this, Color.WHITE);
    }

    public void searchReCharge(){

        try {

            boolean isResultSet;
            int countResults = 0, resultCount;
            RechargeInventories rechargeInventories;

            try {
                ConnectionClass connectionClass = new ConnectionClass(getApplicationContext());

                if (connectionClass.ConnectionMDS() != null) {
                    PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.Consulta_Recarga_Vendedor ?");

                    try {

                        loComando.setInt(1, nDeparture);

                        isResultSet = loComando.execute();

                        if (rechargeInventoriesArrayList != null) {
                            rechargeInventoriesArrayList.clear();
                        }

                        while (true) {
                            if (isResultSet) {

                                if (countResults == 0) {
                                    ResultSet Datos = loComando.getResultSet();

                                    while (Datos.next()) {
                                        nRecharge = Datos.getInt("recarga");

                                        if (nRecharge == 0) {
                                            baseApp.showToast("No hay Recargas de Inventora autorizadas para esta Ruta.");
                                            finish();
                                        }
                                    }

                                    Datos.close();
                                }

                                if (countResults == 1) {

                                    ResultSet Datos1 = loComando.getResultSet();

                                    while (Datos1.next()) {

                                        rechargeInventoriesArrayList.add(
                                                new RechargeInventories(
                                                        idRoute,
                                                        nDeparture,
                                                        nRecharge,
                                                        Datos1.getInt("clave_articulo"),
                                                        Datos1.getDouble("cantidad"),
                                                        baseApp.getCurrentDateFormated()));
                                    }

                                    Datos1.close();
                                }

                            } else {
                                if (loComando.getUpdateCount() == -1) {
                                    break;
                                }

                                baseApp.showLog("Result {} is just a count: {}" + countResults + ", " + loComando.getUpdateCount());
                            }

                            countResults++;
                            isResultSet = loComando.getMoreResults();
                        }

                        getArticles();
                    } catch (Exception ex) {
                        baseApp.showToast("Error al buscar las Recargas de Inventario disponibles");
                        baseApp.showAlert("Error", "Reporta el error: " + ex);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                baseApp.showToast("Ocurrió el error inesperado" + e);
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error: " + ex);
        }
    }

    public void getArticles() {

        try {

            if(rechargeInventoriesArrayList.size() > 0){
                layoutList.setVisibility(View.VISIBLE);
                layoutNotData.setVisibility(View.GONE);

                AdapterDetailsRechargeInventories adapterDetails = new AdapterDetailsRechargeInventories(this, rechargeInventoriesArrayList);

                recyclerArticles.setItemAnimator(new DefaultItemAnimator());
                recyclerArticles.setAdapter(adapterDetails);
            }else{
                baseApp.showToast("No hay artículos para mostrar.");
            }

        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los artículos, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void markRechargeLikeAccepted(){

        try {
            realm = Realm.getDefaultInstance();

            PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.Acepta_Recarga_Mercancia ?, ?, ?");
            if (loComando == null) {
                baseApp.showLog("Error al Crear SP Acepta_Recarga_Mercancia");

            } else {
                try {

                    loComando.setInt(1, nRecharge);
                    loComando.setInt(2, nUser);
                    loComando.setString(3, "Aceptada");

                    ResultSet Datos = loComando.executeQuery();

                    while (Datos.next()) {

                        if (Datos.getInt("exito") == 1) {
                            baseApp.showToast("Recarga de Mercancia aceptada con éxito");

                            realm.beginTransaction();
                            realm.copyToRealm(rechargeInventoriesArrayList);
                            realm.commitTransaction();

                            finish();

                        }else{
                            baseApp.showAlert("Error", "Ocurrió un error, lo más probable es que la recarga de mercancia dejó de estar dispoible.");
                        }
                    }
                } catch (Exception ex) {
                    baseApp.showLog("Error en SP Acepta_Recarga_Mercancia, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
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
                            case "markRechargeLikeAccepted":
                                markRechargeLikeAccepted();
                                break;
                            case "searchReCharge":
                                searchReCharge();
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
