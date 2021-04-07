package com.mds.ventasabpollo.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterArticlesInventory;
import com.mds.ventasabpollo.adapters.AdapterDetailsSales;
import com.mds.ventasabpollo.adapters.AdapterVisits;
import com.mds.ventasabpollo.adapters.AdapterVisitsPayments;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.models.Clients;
import com.mds.ventasabpollo.models.ClientsLists;
import com.mds.ventasabpollo.models.Departures;
import com.mds.ventasabpollo.models.DetailsSales;
import com.mds.ventasabpollo.models.Inventories;
import com.mds.ventasabpollo.models.Routes;
import com.mds.ventasabpollo.models.VisitsClients;
import com.mds.ventasabpollo.models.VisitsPayments;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class FinalReportActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Inventories>> {

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsApp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);
    Realm realm;

    TextView txtRoute, txtDeparture, txtScheduledClients, txtCustomersVisited, txtCustomersSales, txtUserAuthorizer, txtDateStart, txtDateEnd, txtDuration, txtTotalSales, txtTotalSalesCreditPayed, txtTotalCash,  txtTotalSalesCredit, txtTitleClients, txtTitleSpecialClients;
    RecyclerView recyclerVisits, recyclerArticles, recyclerCreditPayed, recyclerCreditGranted, recyclerSpecialClients;
    HorizontalScrollView layoutDetailsSales;
    ImageButton imgBtnPrint;

    int idRoute, totalArticles,totalVisits;
    RealmResults<Routes> route;
    RealmResults<Inventories> listArticles;
    RealmResults<VisitsClients> listVisits;
    RealmResults<VisitsPayments> listsPayments;

    FloatingActionButton fbtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_report);
        getSupportActionBar().hide();

        realm = Realm.getDefaultInstance();

        if (getIntent().getExtras() != null) {
            idRoute = getIntent().getExtras().getInt("idRoute");
            spClass.intSetSP("idRouteTemp", idRoute);
        }else{
            idRoute = 0;
        }

        txtRoute = findViewById(R.id.txtRoute);
        txtDeparture = findViewById(R.id.txtDeparture);
        txtScheduledClients = findViewById(R.id.txtScheduledClients);
        txtCustomersVisited = findViewById(R.id.txtCustomersVisited);
        txtCustomersSales = findViewById(R.id.txtCustomersSales);
        txtUserAuthorizer = findViewById(R.id.txtUserAuthorizer);
        txtDateStart = findViewById(R.id.txtDateStart);
        txtDateEnd = findViewById(R.id.txtDateEnd);
        txtDuration = findViewById(R.id.txtDuration);
        txtTotalSales = findViewById(R.id.txtTotalSales);
        txtTotalSalesCreditPayed = findViewById(R.id.txtTotalSalesCreditPayed);
        txtTotalSalesCredit = findViewById(R.id.txtTotalSalesCredit);
        txtTotalCash = findViewById(R.id.txtTotalCash);
        txtTitleClients = findViewById(R.id.txtTitleClients);
        txtTitleSpecialClients = findViewById(R.id.txtTitleSpecialClients);

        layoutDetailsSales = findViewById(R.id.layoutDetailsSales);

        recyclerVisits = findViewById(R.id.recyclerVisits);
        recyclerArticles = findViewById(R.id.recyclerArticles);
        recyclerCreditPayed = findViewById(R.id.recyclerCreditPayed);
        recyclerCreditGranted = findViewById(R.id.recyclerCreditGranted);
        recyclerSpecialClients = findViewById(R.id.recyclerSpecialClients);

        imgBtnPrint = findViewById(R.id.imgBtnPrint);

        fbtnBack = findViewById(R.id.fbtnBack);

        if(idRoute == 0){
            baseApp.showToast("No se pudo cargar la ruta, inténtalo de nuevo.");
            finish();
        }else{

            GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
            recyclerArticles.setLayoutManager(mGridLayoutManagerDetails);
            recyclerArticles.setItemAnimator(new DefaultItemAnimator());
            recyclerArticles.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

            GridLayoutManager mGridLayoutManager2 = new GridLayoutManager(this, 1);
            recyclerVisits.setLayoutManager(mGridLayoutManager2);
            recyclerVisits.setItemAnimator(new DefaultItemAnimator());
            recyclerVisits.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

            GridLayoutManager mGridLayoutManage3 = new GridLayoutManager(this, 1);
            recyclerCreditPayed.setLayoutManager(mGridLayoutManage3);
            recyclerCreditPayed.setItemAnimator(new DefaultItemAnimator());
            recyclerCreditPayed.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

            GridLayoutManager mGridLayoutManage4 = new GridLayoutManager(this, 1);
            recyclerCreditGranted.setLayoutManager(mGridLayoutManage4);
            recyclerCreditGranted.setItemAnimator(new DefaultItemAnimator());
            recyclerCreditGranted.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

            GridLayoutManager mGridLayoutManage5 = new GridLayoutManager(this, 1);
            recyclerSpecialClients.setLayoutManager(mGridLayoutManage5);
            recyclerSpecialClients.setItemAnimator(new DefaultItemAnimator());
            recyclerSpecialClients.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

            getInfoReport();
            getInventory();
            getClientsNotVisit();
            getCreditPayed();
            getCreditGranted();
            getSpecialClients();

            recyclerArticles.setVerticalScrollBarEnabled(false);
            recyclerArticles.setHorizontalScrollBarEnabled(false);
            recyclerArticles.setNestedScrollingEnabled(false);

            recyclerVisits.setVerticalScrollBarEnabled(false);
            recyclerVisits.setHorizontalScrollBarEnabled(false);
            recyclerVisits.setNestedScrollingEnabled(false);

            recyclerCreditPayed.setVerticalScrollBarEnabled(false);
            recyclerCreditPayed.setHorizontalScrollBarEnabled(false);
            recyclerCreditPayed.setNestedScrollingEnabled(false);

            recyclerCreditGranted.setVerticalScrollBarEnabled(false);
            recyclerCreditGranted.setHorizontalScrollBarEnabled(false);
            recyclerCreditGranted.setNestedScrollingEnabled(false);
        }

        imgBtnPrint.setOnClickListener(v->{
            //functionsApp.printRoute(idRoute);
        });

        fbtnBack.setOnClickListener(v -> backFunction());
        baseApp.darkenStatusBar(this, Color.WHITE);
    }

    public void getInfoReport(){
        try{
            Departures departure;
            RealmResults<ClientsLists> listsClients = null;
            RealmResults<VisitsClients> visitsClients = null, visitsClientsDistinct = null;
            int scheduledClients = 0, customersVisited = 0, visitsRealized = 0, customersSales = 0;
            
            route = realm.where(Routes.class).equalTo("ruta", idRoute).findAll();
            departure = realm.where(Departures.class).equalTo("salida", route.get(0).getSalida()).findFirst();
            
            if(departure != null){
                listsClients = realm.where(ClientsLists.class).equalTo("lista", departure.getLista()).findAll();
                scheduledClients = listsClients.size();
            }

            visitsClients = realm.where(VisitsClients.class).equalTo("ruta", idRoute).findAll();
            visitsClientsDistinct = realm.where(VisitsClients.class).equalTo("ruta", idRoute).distinct("cliente").findAll();

            if(visitsClients != null){
                customersVisited = visitsClientsDistinct.size();
            }

            if(visitsClientsDistinct != null){
                visitsRealized = visitsClients.size();
            }

            for(VisitsClients visit: visitsClients){
                if(realm.where(DetailsSales.class).equalTo("visita", visit.getId()).findAll().size() > 0){
                    customersSales++;
                }
            }

            if(route.size() > 0){
                txtRoute.setText("Ruta: " + route.get(0).getRuta());
                txtDeparture.setText("Salida: " + route.get(0).getSalida());
                
                if(scheduledClients > 0){
                    txtScheduledClients.setText("Clientes programados: " + scheduledClients);
                }else{
                    txtScheduledClients.setText("Clientes programados: error");
                }

                if(customersVisited > 0){
                    txtCustomersVisited.setText("Clientes visitados: " + customersVisited + " (" + visitsRealized + " visitas)");
                }else{
                    txtCustomersVisited.setText("Clientes visitados: error");
                }

                txtCustomersSales.setText("Clientes con ventas: " + customersSales);
                txtUserAuthorizer.setText("Usuario que autorizo: " + route.get(0).getNombre_autorizador_inicio());

                txtDateStart.setText("Fecha inicio: " + route.get(0).getFecha_inicio());
                txtDateEnd.setText("Fecha fin: " + route.get(0).getFecha_fin());
                txtDuration.setText("Duración: " + baseApp.dateFormatTwoDates(baseApp.convertDate(route.get(0).getFecha_inicio()), baseApp.convertDate(route.get(0).getFecha_fin())));
                txtTotalSales.setText("T. Ventas Contado: $" + baseApp.formattedNumber(functionsApp.getTotalSaleRoute(idRoute)));
                txtTotalSalesCreditPayed.setText("T. Ventas Crédito Saldado: $" + baseApp.formattedNumber(functionsApp.getTotalSaleRouteCreditPayed(idRoute)));
                txtTotalCash.setText("T. Efectivo: " + baseApp.formattedNumber(((functionsApp.getTotalSaleRoute(idRoute) + functionsApp.getTotalSaleRouteCreditPayed(idRoute)))));
                txtTotalSalesCredit.setText("T. Ventas Crédito: $" + baseApp.formattedNumber(functionsApp.getTotalSaleRouteCredit(idRoute)));
            }

        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error, repórtalo: " + ex);
        }
    }

    public void getClientsNotVisit(){
        try {
            realm = Realm.getDefaultInstance();

            ArrayList<VisitsClients> listVisitsArray = new ArrayList<>();

            listVisits = realm.where(VisitsClients.class)
                    .notEqualTo("clasificacion_visita", 1)
                    .equalTo("ruta", idRoute)
                    .findAll();
            totalVisits = listVisits.size();

            //listVisits.addChangeListener(this);

            if(totalVisits > 0){

                for(VisitsClients visit: listVisits){
                    if(realm.where(VisitsClients.class)
                            .equalTo("ruta", idRoute)
                            .equalTo("cliente", visit.getCliente())
                            .equalTo("clasificacion_visita", 1)
                            .count() == 0){
                        listVisitsArray.add(visit);
                    }
                }

                AdapterVisits adapterVisits = new AdapterVisits(this, listVisitsArray);

                recyclerVisits.setItemAnimator(new DefaultItemAnimator());
                recyclerVisits.setAdapter(adapterVisits);
            }else{
                txtTitleClients.setVisibility(View.GONE);
                recyclerVisits.setVisibility(View.GONE);
            }

        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los artículos, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void getInventory(){
        try {
            realm = Realm.getDefaultInstance();
            listArticles = realm.where(Inventories.class).equalTo("ruta", idRoute).findAll();
            totalArticles = listArticles.size();

            if(totalArticles > 0){
                AdapterArticlesInventory adapterArticlesInventory = new AdapterArticlesInventory(this, listArticles);

                recyclerArticles.setItemAnimator(new DefaultItemAnimator());
                recyclerArticles.setAdapter(adapterArticlesInventory);
            }else{
                baseApp.showToast("No hay artículos de Inventario para mostrar.");
            }

        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los artículos, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void getCreditPayed(){
        final FunctionsApp functionsapp = new FunctionsApp(this);

        try {
            realm = Realm.getDefaultInstance();

            listsPayments = realm.where(VisitsPayments.class)
                    .equalTo("ruta", idRoute)
                    .equalTo("metodo_pago", "Crédito")
                    .equalTo("cobrado", true)
                    .findAll();
            totalVisits = listsPayments.size();
            //listsPayments.addChangeListener(this);

            if(listsPayments.size() > 0){
                AdapterVisitsPayments adapterVisits = new AdapterVisitsPayments(this, listsPayments);

                recyclerCreditPayed.setItemAnimator(new DefaultItemAnimator());
                recyclerCreditPayed.setAdapter(adapterVisits);
            }else{
                recyclerCreditPayed.setVisibility(View.GONE);
            }


        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los pagos de visitas, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void getCreditGranted(){
        final FunctionsApp functionsapp = new FunctionsApp(this);

        try {
            realm = Realm.getDefaultInstance();

            ArrayList<VisitsPayments> visitsPayments = new ArrayList<>();

            listsPayments = realm.where(VisitsPayments.class)
                    .equalTo("ruta", idRoute)
                    .equalTo("metodo_pago", "Crédito")
                    //.equalTo("cobrado", false)
                    .findAll();
            totalVisits = listsPayments.size();
            //listsPayments.addChangeListener(this);

            if(totalVisits > 0){

                for(VisitsPayments visitsPayments1: listsPayments){
                    if(visitsPayments1.getImporte() > visitsPayments1.getImporte_saldado()){
                        visitsPayments.add(visitsPayments1);
                    }
                }

                AdapterVisitsPayments adapterVisits = new AdapterVisitsPayments(this, visitsPayments);

                recyclerCreditGranted.setItemAnimator(new DefaultItemAnimator());
                recyclerCreditGranted.setAdapter(adapterVisits);
            }else{
                recyclerCreditGranted.setVisibility(View.GONE);
            }

        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los pagos de visitas, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void getSpecialClients(){
        final FunctionsApp functionsapp = new FunctionsApp(this);

        try {
            realm = Realm.getDefaultInstance();

            ArrayList<DetailsSales> detailsSalesArrayList = new ArrayList<>();

            listVisits = realm.where(VisitsClients.class)
                    .equalTo("ruta", idRoute)
                    .findAll();

            if (listVisits.size() > 0) {
                for (VisitsClients visit : listVisits) {

                    Clients client = realm.where(Clients.class)
                            .equalTo("cliente", visit.getCliente())
                            .findFirst();

                    if (client != null) {
                        if (client.getNumero_precio() > 1) {
                            RealmResults<DetailsSales> detailsSales = realm.where(DetailsSales.class)
                                    .equalTo("visita", visit.getId())
                                    .findAll();

                            detailsSalesArrayList.addAll(detailsSales);
                        }
                    }
                }

                if(detailsSalesArrayList.size() > 0){
                    AdapterDetailsSales adapterDetails = new AdapterDetailsSales(this, detailsSalesArrayList);

                    recyclerSpecialClients.setItemAnimator(new DefaultItemAnimator());
                    recyclerSpecialClients.setAdapter(adapterDetails);
                }else{
                    txtTitleSpecialClients.setVisibility(View.GONE);
                    layoutDetailsSales.setVisibility(View.GONE);
                }
            }
        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los pagos de visitas, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }


    @Override
    public void onChange(RealmResults<Inventories> inventories) {

    }

    public void backFunction(){
        finish();
    }

}
