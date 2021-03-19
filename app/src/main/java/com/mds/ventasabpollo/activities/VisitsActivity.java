package com.mds.ventasabpollo.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterVisits;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.models.Articles;
import com.mds.ventasabpollo.models.DetailsOrders;
import com.mds.ventasabpollo.models.DetailsSales;
import com.mds.ventasabpollo.models.VisitsClients;
import com.mds.ventasabpollo.models.VisitsMovements;
import com.mds.ventasabpollo.models.VisitsPayments;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class VisitsActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<VisitsClients>> {

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsapp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private RealmResults<VisitsClients> listsVisits;
    RecyclerView recyclerVisits;
    RelativeLayout layoutVisits, layoutNotData;
    FloatingActionButton fbtnBack;
    TextView txtTitleVisits;

    int nUser, nVisit, nList, nClient, idRoute, totalVisits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visits);
        getSupportActionBar().hide();

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");
        nVisit = spClass.intGetSP("nVisit");
        nList = spClass.intGetSP("nList");
        nClient = spClass.intGetSP("nClient");

        txtTitleVisits = findViewById(R.id.txtTitleVisits);
        recyclerVisits = findViewById(R.id.recyclerVisits);
        layoutVisits = findViewById(R.id.layoutVisits);
        layoutNotData = findViewById(R.id.layoutNotData);
        fbtnBack = findViewById(R.id.fbtnBack);

        if (getIntent().getExtras() != null) {
            idRoute = getIntent().getExtras().getInt("idRoute");
            txtTitleVisits.setText("Visitas Realizadas de la Ruta " + idRoute);
        }else{
            idRoute = 0;
            txtTitleVisits.setText("Visitas Realizadas");
        }

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerVisits.setLayoutManager(mGridLayoutManagerDetails);
        recyclerVisits.setLayoutManager(mGridLayoutManagerDetails);
        recyclerVisits.setItemAnimator(new DefaultItemAnimator());
        recyclerVisits.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        getVisits();

        fbtnBack.setOnClickListener(v -> backFunction());

        baseApp.darkenStatusBar(this, Color.WHITE);
    }

    public void getVisits(){
        final FunctionsApp functionsapp = new FunctionsApp(this);

        try {
                realm = Realm.getDefaultInstance();
                if(idRoute == 0){
                    listsVisits = realm.where(VisitsClients.class).equalTo("user_id", nUser).findAll();
                }else{
                    listsVisits = realm.where(VisitsClients.class).equalTo("ruta", idRoute).equalTo("user_id", nUser).findAll();
                }

                totalVisits = listsVisits.size();
                listsVisits.addChangeListener(this);

                if (totalVisits > 0) {
                    layoutVisits.setVisibility(View.VISIBLE);
                    layoutNotData.setVisibility(View.GONE);

                    AdapterVisits adapterVisits = new AdapterVisits(this, listsVisits);

                    recyclerVisits.setItemAnimator(new DefaultItemAnimator());
                    recyclerVisits.setAdapter(adapterVisits);
                } else {
                    layoutVisits.setVisibility(View.GONE);
                    layoutNotData.setVisibility(View.VISIBLE);
                }

        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los artículos, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void cancelVisit(){

        BaseApp baseApp = new BaseApp(this);
        SPClass spClass = new SPClass(this);

        int nUser = spClass.intGetSP("user");
        int idVisit = 0;

        try {
            PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.Cancela_Visita ?, ?");
            if (loComando == null) {
                baseApp.showLog("Error al Crear SP Cancela_Visita");

            } else {
                try {

                    VisitsClients visit = realm.where(VisitsClients.class).equalTo("id", nVisit).findFirst();
                    if(visit != null){
                        idVisit = visit.getId_db();
                    }

                    loComando.setInt(1, idVisit);
                    loComando.setInt(2, nUser);

                    ResultSet Datos = loComando.executeQuery();

                    while (Datos.next()) {

                        if (Datos.getInt("exito") == 1) {
                            baseApp.showToast("Visitada cancelada en el sistema con éxito.");
                            deleteVisit(nVisit);
                        }
                    }
                } catch (Exception ex) {
                    baseApp.showLog("Error en SP Cancela_Visita, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
                }
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    public void deleteVisit(int nVisit){
        BaseApp baseApp = new BaseApp(this);
        FunctionsApp functionsapp = new FunctionsApp(this);

        try {
            realm = Realm.getDefaultInstance();

            RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class).equalTo("id", nVisit).findAll();
            RealmResults<DetailsOrders> detailsOrders = realm.where(DetailsOrders.class).equalTo("visita", nVisit).findAll();
            RealmResults<DetailsSales> detailsSales = realm.where(DetailsSales.class).equalTo("visita", nVisit).findAll();
            RealmResults<VisitsMovements> visitMovements = realm.where(VisitsMovements.class).equalTo("visita", nVisit).findAll();
            RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class).equalTo("visita", nVisit).findAll();

            if(visitsClients.size() > 0){
                idRoute = visitsClients.get(0).getRuta();

                functionsapp.resetAmountsVisit(idRoute, nVisit);
            }

            if(idRoute != 0){
                RealmResults<Articles> listArticles = realm.where(Articles.class).findAll();
                for(Articles articles: listArticles){
                    functionsapp.changeMovementsArticle(idRoute, nVisit, articles.getClave_articulo(), 0, 0, 0, "");
                }
            }

            realm.beginTransaction();
            visitsClients.deleteAllFromRealm();
            detailsOrders.deleteAllFromRealm();
            detailsSales.deleteAllFromRealm();
            visitMovements.deleteAllFromRealm();
            visitsPayments.deleteAllFromRealm();
            realm.commitTransaction();
            baseApp.showToast("Visita eliminada");

           getVisits();

        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al eliminar la Visita, repórtalo al dpto de Sistemas: " + ex);
            realm.commitTransaction();
            realm.close();
        }
    }

    public void processCancelVisit(int visit){
        nVisit = visit;
        backgroundProcess("cancelVisit");
    }

    public void backgroundProcess(String process){
        Handler handler;
        ProgressDialog dialog;
        FunctionsApp functionsApp = new FunctionsApp(this);

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
                            case "cancelVisit":
                                cancelVisit();
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

    public void onResume() {
        super.onResume();
    }

    public void onBackPressed() {
        backFunction();
    }

    public void backFunction(){
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onChange(RealmResults<VisitsClients> visitsClients) {

    }
}
