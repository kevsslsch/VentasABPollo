package com.mds.ventasabpollo.activities;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterArticlesSales;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.ShakeDetector;
import com.mds.ventasabpollo.classes.SpacesItemDecoration;
import com.mds.ventasabpollo.models.Articles;
import com.mds.ventasabpollo.models.Clients;
import com.mds.ventasabpollo.models.DetailsOrders;
import com.mds.ventasabpollo.models.DetailsSales;
import com.mds.ventasabpollo.models.TopArticles;
import com.mds.ventasabpollo.models.VisitsClients;
import com.mds.ventasabpollo.models.VisitsMovements;
import com.mds.ventasabpollo.models.VisitsPayments;
import com.mds.ventasabpollo.services.ShakeService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;

public class SalesActivity extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsapp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private RealmResults<Articles> listArticles;

    RecyclerView recyclerArticles;
    RelativeLayout layoutArticles, layoutNotData;
    FloatingActionButton fbtnBack, fbtnPayOff, fbtnDetails;
    TextView txtTitleHeader, txtTotalDetails, txtTitleLimitCredit, txtTitleDebt, txtTitleRemainingCredit;
    LinearLayout layoutTypeSale;
    SearchView searchClients;
    Switch switchTypeSale;
    LinearLayout layoutSwitchTypeSale;

    int nUser, nVisit, nList, nClient, idRoute;
    int limitArticlesTop = 20;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
        getSupportActionBar().hide();

        Realm.init(this);

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");
        nVisit = spClass.intGetSP("nVisit");
        nClient = spClass.intGetSP("nClient");
        idRoute = spClass.intGetSP("idRoute");

        if(spClass.intGetSP("nList") != 0) {
            nList = spClass.intGetSP("nList");
        }else{
            nList = 0;
        }

        recyclerArticles = findViewById(R.id.recyclerArticles);
        layoutArticles = findViewById(R.id.layoutArticles);
        layoutNotData = findViewById(R.id.layoutNotData);

        fbtnBack = findViewById(R.id.fbtnBack);
        fbtnPayOff = findViewById(R.id.fbtnPayOff);
        fbtnDetails = findViewById(R.id.fbtnDetails);

        txtTitleHeader = findViewById(R.id.txtTitleHeader);
        txtTotalDetails = findViewById(R.id.txtTotalDetails);
        searchClients = findViewById(R.id.searchClients);
        layoutTypeSale = findViewById(R.id.layoutTypeSale);
        txtTitleLimitCredit = findViewById(R.id.txtTitleLimitCredit);
        txtTitleDebt = findViewById(R.id.txtTitleDebt);
        txtTitleRemainingCredit = findViewById(R.id.txtTitleRemainingCredit);
        switchTypeSale = findViewById(R.id.switchTypeSale);
        layoutSwitchTypeSale = findViewById(R.id.layoutSwitchTypeSale);

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        //GridAutofitLayoutManager mGridLayoutManagerDetails = new GridAutofitLayoutManager(this, 300);
        recyclerArticles.setLayoutManager(mGridLayoutManagerDetails);
        recyclerArticles.setItemAnimator(new DefaultItemAnimator());
        recyclerArticles.addItemDecoration(new SpacesItemDecoration(1));

        searchClients.setOnClickListener(v -> searchClients.onActionViewExpanded());

        searchClients.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchClients.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                try {
                    resetAllTemporalFlags();
                    getArticles(newText);
                }catch (Exception ex){
                    baseApp.showToast("Ocurrió un error");
                    baseApp.showLog("Ocurrió el error" + ex);
                }
                return false;
            }
        });

        fbtnBack.setOnClickListener(v -> backFunction());
        fbtnPayOff.setOnClickListener(v-> functionsapp.goPayOffActivity(nClient));
        fbtnDetails.setOnClickListener(v -> {

            if(functionsapp.getIsVisitFinished(nVisit)){
                finish();
            }
            functionsapp.goDetailsSaleActivity(nVisit);

        });

        Intent intent = new Intent(this, ShakeService.class);
        startService(intent);

        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(count -> {
            /*
             * The following method, "handleShakeEvent(count):" is a stub //
             * method you would use to setup whatever you want done once the
             * device has been shook.
             */

            Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vib.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                //deprecated in API 26
                vib.vibrate(250);
            }

            functionsapp.goInventoryActivity();
        });

        /*if(!functionsapp.getStatusSalesVisit(nVisit)){
            functionsapp.goMainActivity();
            baseApp.showToast("No puedes hacer movimientos de Venta, la cuenta ha sido dada por pagada.");
        }*/

        switchTypeSale.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                spClass.strSetSP("sTypeSale", "credit");
            } else {
                spClass.strSetSP("sTypeSale", "counted");
            }
        });

        if(functionsapp.getIsVisitFinished(nVisit)){
            switchTypeSale.setEnabled(false);
        }else{
            switchTypeSale.setEnabled(true);
        }

        baseApp.darkenStatusBar(this, Color.WHITE);
    }

    public void controllCredit(){
        try{
            RealmResults<Clients> client = realm.where(Clients.class).equalTo("cliente", nClient).findAll();
            if(client.size() > 0) {

                switchTypeSale.setChecked(functionsapp.getIsCredit(nVisit));

                if(spClass.boolGetSP("onlineConnection")){
                    backgroundProcess("uploadData");
                    backgroundProcess("refreshDataClient");
                }else{
                    dataControllCredit();
                }

            }else{
                baseApp.showToast("Ocurrió un error.");
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error");
        }
    }

    public void dataControllCredit(){
        try{
            RealmResults<Clients> client = realm.where(Clients.class)
                    .equalTo("cliente", nClient)
                    .findAll();
            double currentCustomerBalance, currentCustomerDebt;

            if(client.size() > 0){

                if(client.get(0).getNombre_cliente() != null){
                    txtTitleHeader.setText("Venta de " + client.get(0).getNombre_cliente().trim());
                }else{
                    txtTitleHeader.setText("Venta");
                }

                currentCustomerBalance = functionsapp.getCurrentCustomerBalance(nClient);
                currentCustomerDebt = functionsapp.getCurrentCustomerDebt(nClient);

                if(client.get(0).getLimite_credito() > 0.0){

                    //layoutTypeSale.setVisibility(View.VISIBLE);

                    txtTitleLimitCredit.setVisibility(View.VISIBLE);
                    txtTitleRemainingCredit.setVisibility(View.VISIBLE);
                    layoutSwitchTypeSale.setVisibility(View.VISIBLE);

                    txtTitleLimitCredit.setText("Limite Crédito: $" + baseApp.formattedNumber(client.get(0).getLimite_credito()));
                    txtTitleRemainingCredit.setText("Crédito Restante: $" + baseApp.formattedNumber(functionsapp.getCurrentCustomerBalance(nClient)));
                }else{
                    //layoutTypeSale.setVisibility(View.GONE);

                    txtTitleLimitCredit.setVisibility(View.GONE);
                    txtTitleRemainingCredit.setVisibility(View.GONE);
                    layoutSwitchTypeSale.setVisibility(View.GONE);
                }

                /*if(functionsapp.getCurrentCustomerDebt(nClient) > 0.0){
                    txtTitleDebt.setVisibility(View.VISIBLE);
                    txtTitleDebt.setText("Adeudo: $" + currentCustomerDebt);

                    baseApp.showAlert("Adeudo", "El cliente tiene un adeudo de: $" + currentCustomerDebt);
                    fbtnPayOff.setVisibility(View.VISIBLE);
                }else{
                    txtTitleDebt.setVisibility(View.GONE);
                    fbtnPayOff.setVisibility(View.GONE);
                }*/
                /* TODO */
                txtTitleDebt.setVisibility(View.GONE);
                fbtnPayOff.setVisibility(View.GONE);

            }else{
                //layoutTypeSale.setVisibility(View.GONE);
                baseApp.showToast("Ocurrió un error al cargar el cliente.");
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }


    public void getArticlesTop(){
        final FunctionsApp functionsapp = new FunctionsApp(this);
        List<Articles> listArticlesShow;

        try {
            //if(nList != 0 || nClient != 0 || nSubLine != 0) {
            //if(nList != 0 || nClient != 0) {
                realm = Realm.getDefaultInstance();
                int listArticlesToShow = 0, nArticle;

                RealmResults<TopArticles> TopArticlesFavs = realm.where(TopArticles.class)
                        .equalTo("es_top", true)
                        .sort("fecha_registro", Sort.DESCENDING).findAll();
                RealmResults<TopArticles> TopArticlesClicks = realm.where(TopArticles.class)
                        .equalTo("es_top", false)
                        .sort("fecha_registro", Sort.DESCENDING)
                        .findAll();

                listArticlesShow = new ArrayList<>();

                // traerse los limitArticlesTop o menos artículos colocados como favoritos
                if(TopArticlesFavs.size() <= limitArticlesTop){
                    if(TopArticlesFavs.size() > 0) {
                        for (int i = 0; i < limitArticlesTop; i++) {

                            nArticle = TopArticlesFavs.get(i).getClave_articulo();
                            RealmResults<Articles> Articles = realm.where(Articles.class)
                                    .equalTo("clave_articulo", nArticle)
                                    .equalTo("temporal_flag", false)
                                    .sort("clave_articulo", Sort.ASCENDING)
                                    .findAll();

                            if(Articles.size() > 0) {

                                if(functionsapp.getAmountArticleRoute(idRoute, Articles.get(i).getClave_articulo(), false, false) > 0) {
                                    listArticlesShow.add(new Articles(
                                            Articles.get(i).getClave_articulo(),
                                            Articles.get(i).getFamilia(),
                                            Articles.get(i).getSublinea(),
                                            Articles.get(i).getArticulo(),
                                            Articles.get(i).getNombre_articulo(),
                                            Articles.get(i).getNombre_unidad(),
                                            Articles.get(i).getDescripcion_extendida(),
                                            false,
                                            Articles.get(i).getUser_id()));
                                    temporalFlag(Articles.get(i).getClave_articulo());
                                }
                            }
                        }

                    }
                    listArticlesToShow = listArticlesShow.size();
                }

                // Si aún falta artículos de poner con limitArticlesTop, trae los que tengan más clics
                if(listArticlesToShow < limitArticlesTop) {
                    if(TopArticlesClicks.size() > 0) {
                        for (int i = 0; i < TopArticlesClicks.size(); i++) {

                            nArticle = TopArticlesClicks.get(i).getClave_articulo();
                            RealmResults<Articles> Articles = realm.where(Articles.class).equalTo("clave_articulo", nArticle).equalTo("temporal_flag", false).sort("clave_articulo", Sort.ASCENDING).findAll();

                            if (Articles.size() > i) {
                                if(functionsapp.getAmountArticleRoute(idRoute, Articles.get(i).getClave_articulo(), false, false) > 0) {
                                    listArticlesShow.add(new Articles(
                                            Articles.get(i).getClave_articulo(),
                                            Articles.get(i).getFamilia(),
                                            Articles.get(i).getSublinea(),
                                            Articles.get(i).getArticulo(),
                                            Articles.get(i).getNombre_articulo(),
                                            Articles.get(i).getNombre_unidad(),
                                            Articles.get(i).getDescripcion_extendida(),
                                            false,
                                            Articles.get(i).getUser_id()));
                                    temporalFlag(Articles.get(i).getClave_articulo());
                                }
                            }
                        }
                    }
                    listArticlesToShow = listArticlesShow.size();
                }

                // Si aún falta artículos de poner con limitArticlesTop, trae los últimos artículos agregados
                if(listArticlesToShow < limitArticlesTop) {
                    RealmResults<Articles> articles = realm.where(Articles.class).sort("clave_articulo", Sort.ASCENDING).equalTo("temporal_flag", false).limit(limitArticlesTop - listArticlesToShow).findAll();

                    if(articles.size() > 0) {
                        for (Articles article: articles) {

                            if(functionsapp.getAmountArticleRoute(idRoute, article.getClave_articulo(), false, false) > 0) {
                                listArticlesShow.add(new Articles(
                                        article.getClave_articulo(),
                                        article.getFamilia(),
                                        article.getSublinea(),
                                        article.getArticulo(),
                                        article.getNombre_articulo(),
                                        article.getNombre_unidad(),
                                        article.getDescripcion_extendida(),
                                        false,
                                        article.getUser_id()));
                                temporalFlag(article.getClave_articulo());
                            }
                        }
                    }

                    listArticlesToShow = listArticlesShow.size();
                }

                if (listArticlesToShow > 0) {
                    layoutArticles.setVisibility(View.VISIBLE);
                    layoutNotData.setVisibility(View.GONE);

                    AdapterArticlesSales adapterArticlesSales = new AdapterArticlesSales(this, listArticlesShow);

                    recyclerArticles.setItemAnimator(new DefaultItemAnimator());
                    recyclerArticles.setAdapter(adapterArticlesSales);
                } else {
                    layoutArticles.setVisibility(View.GONE);
                    layoutNotData.setVisibility(View.VISIBLE);
                }
            /*}else{
                baseApp.showAlert("Error", "Ocurrió un error al cargar el valor de Lista, Cliente o Sublinea. Valor de Lista : " + nList + " , valor de Cliente: " + nClient);
            }*/
        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los artículos, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
            ex.printStackTrace();
        }
    }


    public void getArticles(String text){
        try{
            realm = Realm.getDefaultInstance();

            resetAllTemporalFlags();

            if(text.isEmpty()){
                getArticlesTop();
            }else {

                listArticles = realm.where(Articles.class)
                        .contains("articulo", text, Case.INSENSITIVE)
                        .or()
                        .contains("nombre_articulo", text, Case.INSENSITIVE)
                        .equalTo("user_id", nUser).limit(30).findAll();

                AdapterArticlesSales adapterArticlesSales = new AdapterArticlesSales(this, listArticles);
                recyclerArticles.setItemAnimator(new DefaultItemAnimator());
                recyclerArticles.setAdapter(adapterArticlesSales);
            }
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al intentar mostrar los artículos, repórtalo: " + ex);
        }
    }

    public void refreshTotal(){
        txtTotalDetails.setText("Total: $ " + baseApp.formattedNumber(functionsapp.getTotalSale(nVisit, "totalImport")));
    }

    public void temporalFlag(int article){
        try{
            RealmResults<Articles> articles = realm.where(Articles.class).equalTo("clave_articulo", article).findAll();

            if(articles.size() > 0){
                realm.beginTransaction();
                articles.get(0).setTemporal_flag(true);
                realm.insertOrUpdate(articles.get(0));
                realm.commitTransaction();
            }
        }catch (Exception ex){
            baseApp.showToast("Error: " + ex);
        }
    }

    public void resetAllTemporalFlags(){
        try{
            RealmResults<Articles> articles = realm.where(Articles.class).findAll();

            for(Articles article: articles){
                realm.beginTransaction();
                article.setTemporal_flag(false);
                realm.insertOrUpdate(article);
                realm.commitTransaction();
            }
        }catch (Exception ex){
            baseApp.showToast("Error: " + ex);
        }
    }

    public void showMenuBottomCancelVisit() {

        BottomSheetDialog menuBottomSheet;
        TextView btnYes, btnNo, txtViewTitle;

        menuBottomSheet = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);
        menuBottomSheet.setContentView(R.layout.bottom_sheet_confirm);
        menuBottomSheet.setCancelable(true);
        menuBottomSheet.show();

        txtViewTitle = menuBottomSheet.findViewById(R.id.txtViewInfo);
        btnYes = menuBottomSheet.findViewById(R.id.btnYes);
        btnNo = menuBottomSheet.findViewById(R.id.btnNo);

        txtViewTitle.setText("No puedes regresarte a menos que canceles la Visita. Al cancelarla se borrarán todos los detalles y la información capturada. ¿Desea continuar?");
        btnYes.setOnClickListener(v-> {
            cancelVisit();

            menuBottomSheet.dismiss();
        });
        btnNo.setOnClickListener(v-> menuBottomSheet.dismiss());
    }

    public void cancelVisit() {
        try {

            RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class).equalTo("id", nVisit).findAll();
            RealmResults<DetailsOrders> detailsOrders = realm.where(DetailsOrders.class).equalTo("visita", nVisit).findAll();
            RealmResults<DetailsSales> detailsSales = realm.where(DetailsSales.class).equalTo("visita", nVisit).findAll();
            RealmResults<VisitsMovements> visitMovements = realm.where(VisitsMovements.class).equalTo("visita", nVisit).findAll();
            RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class).equalTo("visita", nVisit).findAll();

            RealmResults<Articles> listArticles = realm.where(Articles.class).findAll();
            for(Articles articles: listArticles){
                functionsapp.changeMovementsArticle(idRoute, nVisit, articles.getClave_articulo(), 0, 0, 0, "");
                //functionsapp.changeMovementsSalesArticle(idRoute, nVisit, articles.getClave_articulo(), 0);
            }

            functionsapp.resetAmountsVisit(idRoute, nVisit);

            realm.beginTransaction();
            visitsClients.deleteAllFromRealm();
            detailsOrders.deleteAllFromRealm();
            detailsSales.deleteAllFromRealm();
            visitMovements.deleteAllFromRealm();
            visitsPayments.deleteAllFromRealm();
            realm.commitTransaction();

            spClass.deleteSP("inVisit");
            spClass.deleteSP("nClient");
            spClass.deleteSP("nList");
            spClass.deleteSP("nVisit");
            spClass.deleteSP("sPaymentMethod");
            spClass.deleteSP("sTypeSale");

            functionsapp.goListClientsActivity(nList, true);
            baseApp.showToast("Visita cancelada");

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (notificationManager != null) {
                    notificationManager.cancel(1);
                }
            }

        }catch(Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al intentar finalizar la visita, reporta el siguiente error al Dpto de Sistemas: " + ex);
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
                            case "uploadData":
                                functionsApp.uploadData();
                                break;

                            case "refreshDataClient":
                                functionsApp.refreshDataClient(nClient);
                                dataControllCredit();
                                break;
                            default:
                                return;
                        }

                    } else {
                        //baseApp.showAlertDialog("error", "Error", "Prende tu señal de datos o conéctate a una red WIFI para poder descargar los datos", true);
                        baseApp.showToast("Ocurrió un error al obtener la información del cliente, inténtalo de nuevo.");
                        cancelVisit();
                    }
                }else{
                    //baseApp.showAlertDialog("error", "Error", "No hay conexión al Servidor, reconfigura los datos de conexión e inténtalo de nuevo.", true);
                    baseApp.showToast("Ocurrió un error al obtener la información del cliente, inténtalo de nuevo.");
                    cancelVisit();
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

    public void onBackPressed() {
        backFunction();
    }

    public void backFunction(){

        if(!searchClients.isIconified()){
            searchClients.onActionViewCollapsed();
        }else {
            /*finish();
            functionsapp.goMainActivity();
            overridePendingTransition(0, 0);*/

            if(functionsapp.getIsVisitFinished(nVisit)){
                finish();
            }else{
                showMenuBottomCancelVisit();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);

        resetAllTemporalFlags();
        getArticlesTop();
        refreshTotal();
        controllCredit();
    }

    @Override
    public void onPause() {
        super.onPause();

        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
    }
}
