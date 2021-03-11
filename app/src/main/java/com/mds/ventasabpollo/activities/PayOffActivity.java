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
import com.mds.ventasabpollo.adapters.AdapterVisitsPayments;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.models.VisitsPayments;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class PayOffActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<VisitsPayments>> {

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsapp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private RealmResults<VisitsPayments> listsVisits;
    ArrayList<VisitsPayments> listVisitsToShow;

    RecyclerView recyclerVisits;
    RelativeLayout layoutVisits, layoutNotData;
    FloatingActionButton fbtnBack;
    TextView txtTitleVisits;

    int nUser, nVisit, nClient, totalVisits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payoff);
        getSupportActionBar().hide();

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");
        nVisit = spClass.intGetSP("nVisit");

        txtTitleVisits = findViewById(R.id.txtTitleVisits);
        recyclerVisits = findViewById(R.id.recyclerVisits);
        layoutVisits = findViewById(R.id.layoutVisits);
        layoutNotData = findViewById(R.id.layoutNotData);
        fbtnBack = findViewById(R.id.fbtnBack);

        if (getIntent().getExtras() != null) {
            nClient = getIntent().getExtras().getInt("nClient");
        }else{
            nClient = 0;
        }

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerVisits.setLayoutManager(mGridLayoutManagerDetails);
        recyclerVisits.setLayoutManager(mGridLayoutManagerDetails);
        recyclerVisits.setItemAnimator(new DefaultItemAnimator());
        recyclerVisits.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        if(spClass.boolGetSP("onlineConnection")){
            backgroundProcess("backgroundProcess");
        }else{
            getVisits();
        }

        fbtnBack.setOnClickListener(v -> backFunction());

        baseApp.darkenStatusBar(this, Color.WHITE);
    }

    public void getVisits(){
        final FunctionsApp functionsapp = new FunctionsApp(this);

        try {
            realm = Realm.getDefaultInstance();

            listVisitsToShow = new ArrayList<>();

            listsVisits = realm.where(VisitsPayments.class)
                    .equalTo("cliente", nClient)
                    .equalTo("metodo_pago", "Crédito")
                    //.equalTo("cobrado", false)
                    .equalTo("enviado", false)
                    .findAll();
            totalVisits = listsVisits.size();

            if(totalVisits > 0){
                for(VisitsPayments visit: listsVisits){
                    if(visit.getImporte() != visit.getImporte_saldado()){
                        listVisitsToShow.add(visit);
                    }
                }
            }

            //listsVisits.addChangeListener(this);

            if (totalVisits > 0) {
                layoutVisits.setVisibility(View.VISIBLE);
                layoutNotData.setVisibility(View.GONE);

                AdapterVisitsPayments adapterVisits = new AdapterVisitsPayments(this, listVisitsToShow);

                recyclerVisits.setItemAnimator(new DefaultItemAnimator());
                recyclerVisits.setAdapter(adapterVisits);
            } else {
                layoutVisits.setVisibility(View.GONE);
                layoutNotData.setVisibility(View.VISIBLE);
            }

        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los pagos de visitas, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
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
                            case "backgroundProcess":
                                functionsApp.uploadData();
                                functionsApp.refreshDataClient(nClient);
                                getVisits();
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
    public void onChange(RealmResults<VisitsPayments> visitsPayments) {

    }
}
