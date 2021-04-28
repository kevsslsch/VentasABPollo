package com.mds.ventasabpollo.activities;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterArticlesOthers;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.classes.ShakeDetector;
import com.mds.ventasabpollo.models.Articles;
import com.mds.ventasabpollo.models.DetailsOrders;
import com.mds.ventasabpollo.models.DetailsSales;
import com.mds.ventasabpollo.models.TopArticles;
import com.mds.ventasabpollo.models.VisitsClasifications;
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

public class OthersActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Articles>>,
        LocationListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    private static final long MIN_TIME = 400;
    private static final float MIN_DISTANCE = 1000;

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsapp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private RealmResults<Articles> listArticles;
    private RealmResults<TopArticles> listTopArticles;
    RealmResults<VisitsClasifications> listClasifications;

    RecyclerView recyclerArticles;
    RelativeLayout layoutArticles, layoutNotData;
    FloatingActionButton fbtnBack, fbtnFinishVisit;
    SearchView searchArticles;
    Spinner spinnerClasifications;

    String sPaymentMethodSaved;
    int nUser, idRoute, nVisit, nList, nClient, totalArticles;
    int limitArticlesTop = 20;
    int position = 0;

    Boolean locationDisabled = false;
    double latitudeUser = 0.0, longitudeUser = 0.0;
    LocationManager locationManager;

    private static final long TIEMPO_MINIMO = 4000; // Minimo de espera para click
    private long ultimoClick= 0; // Fecha del Ultimo click capturado

    ArrayList<Integer> articlesWithouSave = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        getSupportActionBar().hide();

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");
        nVisit = spClass.intGetSP("nVisit");
        nClient = spClass.intGetSP("nClient");
        nList = spClass.intGetSP("nList");
        idRoute = spClass.intGetSP("idRoute");
        
        recyclerArticles = findViewById(R.id.recyclerArticles);
        layoutArticles = findViewById(R.id.layoutArticles);
        layoutNotData = findViewById(R.id.layoutNotData);
        fbtnBack = findViewById(R.id.fbtnBack);
        fbtnFinishVisit = findViewById(R.id.fbtnFinishVisit);
        searchArticles = findViewById(R.id.searchClients);

        articlesWithouSave.clear();

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerArticles.setLayoutManager(mGridLayoutManagerDetails);
        recyclerArticles.setItemAnimator(new DefaultItemAnimator());
        recyclerArticles.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        sPaymentMethodSaved = spClass.strGetSP("sPaymentMethod");

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

        fbtnBack.setOnClickListener(v -> backFunction());
        fbtnFinishVisit.setOnClickListener(v -> {

            if(functionsapp.getIsVisitFinished(nVisit)){
                finish();
            }else{
                if(functionsapp.visitHaveSale(nVisit)){
                    finishVisit(0);
                }else{
                    showBottomClasificationVisit();
                }
            }
        });

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(count -> {
        
            Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vib.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vib.vibrate(250);
            }

            functionsapp.goInventoryActivity();
        });

        Intent intent = new Intent(this, ShakeService.class);
        startService(intent);

        resetAllTemporalFlags();
        getArticlesTop();
        getLocation();

        baseApp.darkenStatusBar(this, Color.WHITE);
    }

    /* public void getArticlesTop(){
        final FunctionsApp functionsapp = new FunctionsApp(this);
        List<Articles> listArticlesShow;

        try {
            //if(nList != 0 || nClient != 0 || nSubLine != 0) {
            if(nList != 0 || nClient != 0) {
                realm = Realm.getDefaultInstance();
                int listArticlesToShow = 0, nArticle;

                RealmResults<TopArticles> TopArticlesFavs = realm.where(TopArticles.class).equalTo("es_top", true).sort("fecha_registro", Sort.DESCENDING).findAll();
                RealmResults<TopArticles> TopArticlesClicks = realm.where(TopArticles.class).equalTo("es_top", false).sort("fecha_registro", Sort.DESCENDING).findAll();

                listArticlesShow = new ArrayList<>();

                // Si aún falta artículos de poner con limitArticlesTop, trae los últimos artículos agregados
                if(listArticlesToShow < limitArticlesTop) {
                    RealmResults<Articles> articles = realm.where(Articles.class).sort("clave_articulo", Sort.DESCENDING).equalTo("temporal_flag", false).limit(limitArticlesTop - listArticlesToShow).findAll();

                    if(articles.size() > 0) {
                        for (Articles article: articles) {

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

                    listArticlesToShow = listArticlesShow.size();
                }

                if (listArticlesToShow > 0) {
                    layoutArticles.setVisibility(View.VISIBLE);
                    layoutNotData.setVisibility(View.GONE);

                    AdapterArticlesSales adapterArticlesSales = new AdapterArticlesSales(this, listArticlesShow);

                    baseApp.showLog("size 2: " + listArticlesShow.size());
                    recyclerArticles.setItemAnimator(new DefaultItemAnimator());
                    recyclerArticles.setAdapter(adapterArticlesSales);
                } else {
                    layoutArticles.setVisibility(View.GONE);
                    layoutNotData.setVisibility(View.VISIBLE);
                }
            }else{
                baseApp.showAlert("Error", "Ocurrió un error al cargar el valor de Lista, Cliente o Sublinea. Valor de Lista : " + nList + " , valor de Cliente: " + nClient);
            }
        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los artículos, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
            ex.printStackTrace();
        }
    }
*/
    public void getArticlesTop(){
        final FunctionsApp functionsapp = new FunctionsApp(this);
        List<Articles> listArticlesShow;

        try {
            //if(nList != 0 || nClient != 0 || nSubLine != 0) {
            if(nList != 0 || nClient != 0) {
                realm = Realm.getDefaultInstance();
                int listArticlesToShow = 0, nArticle;

                RealmResults<TopArticles> TopArticlesFavs = realm.where(TopArticles.class).equalTo("es_top", true).sort("fecha_registro", Sort.DESCENDING).findAll();
                RealmResults<TopArticles> TopArticlesClicks = realm.where(TopArticles.class).equalTo("es_top", false).sort("fecha_registro", Sort.DESCENDING).findAll();

                listArticlesShow = new ArrayList<>();

                // traerse los limitArticlesTop o menos artículos colocados como favoritos
                if(TopArticlesFavs.size() <= limitArticlesTop){
                    if(TopArticlesFavs.size() > 0) {
                        for (int i = 0; i < limitArticlesTop; i++) {

                            nArticle = TopArticlesFavs.get(i).getClave_articulo();
                            RealmResults<Articles> Articles = realm.where(Articles.class).equalTo("clave_articulo", nArticle).equalTo("temporal_flag", false).sort("clave_articulo", Sort.ASCENDING).findAll();

                            if(Articles.size() > 0) {
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
                    listArticlesToShow = listArticlesShow.size();
                }

                // Si aún falta artículos de poner con limitArticlesTop, trae los que tengan más clics
                if(listArticlesToShow < limitArticlesTop) {
                    if(TopArticlesClicks.size() > 0) {
                        for (int i = 0; i < TopArticlesClicks.size(); i++) {

                            nArticle = TopArticlesClicks.get(i).getClave_articulo();
                            RealmResults<Articles> Articles = realm.where(Articles.class).equalTo("clave_articulo", nArticle).equalTo("temporal_flag", false).sort("clave_articulo", Sort.ASCENDING).findAll();

                            if (Articles.size() > i) {
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
                    listArticlesToShow = listArticlesShow.size();
                }

                // Si aún falta artículos de poner con limitArticlesTop, trae los últimos artículos agregados
                if(listArticlesToShow < limitArticlesTop) {
                    RealmResults<Articles> articles = realm.where(Articles.class).sort("clave_articulo", Sort.ASCENDING).equalTo("temporal_flag", false).limit(limitArticlesTop - listArticlesToShow).findAll();

                    if(articles.size() > 0) {
                        for (Articles article: articles) {

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

                    listArticlesToShow = listArticlesShow.size();
                }

                if (listArticlesToShow > 0) {
                    layoutArticles.setVisibility(View.VISIBLE);
                    layoutNotData.setVisibility(View.GONE);

                    AdapterArticlesOthers adapterArticlesOthers = new AdapterArticlesOthers(this, listArticlesShow);

                    recyclerArticles.setItemAnimator(new DefaultItemAnimator());
                    recyclerArticles.setAdapter(adapterArticlesOthers);
                } else {
                    layoutArticles.setVisibility(View.GONE);
                    layoutNotData.setVisibility(View.VISIBLE);
                }
            }else{
                baseApp.showAlert("Error", "Ocurrió un error al cargar el valor de Lista, Cliente o Sublinea. Valor de Lista : " + nList + " , valor de Cliente: " + nClient);
            }
        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los artículos, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
            ex.printStackTrace();
        }
    }


    public void getArticles(String text){
        try{
            realm = Realm.getDefaultInstance();

            if(text.isEmpty()){
                resetAllTemporalFlags();
                getArticlesTop();
            }else {

                listArticles = realm.where(Articles.class)
                        .contains("articulo", text, Case.INSENSITIVE)
                        .or()
                        .contains("nombre_articulo", text, Case.INSENSITIVE)
                        .equalTo("user_id", nUser).limit(30).findAll();

                AdapterArticlesOthers adapterArticlesOthers = new AdapterArticlesOthers(this, listArticles);
                recyclerArticles.setItemAnimator(new DefaultItemAnimator());
                recyclerArticles.setAdapter(adapterArticlesOthers);
            }
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al intentar mostrar los artículos, repórtalo: " + ex);
        }
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

    public void showBottomClasificationVisit(){
        BottomSheetDialog menuBottomSheet;
        TextView btnCancel, btnEndVisit;

        try {

            menuBottomSheet = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);
            menuBottomSheet.setContentView(R.layout.bottom_sheet_clasification_visit);
            menuBottomSheet.setCancelable(true);
            menuBottomSheet.show();

            btnCancel = menuBottomSheet.findViewById(R.id.btnCancel);
            btnEndVisit = menuBottomSheet.findViewById(R.id.btnEndVisit);
            spinnerClasifications = menuBottomSheet.findViewById(R.id.spinnerClasification);

            populateVisitsClasifications();

            btnEndVisit.setOnClickListener(v -> {
                // Evitar doble click boton
                if (SystemClock.elapsedRealtime() - ultimoClick < TIEMPO_MINIMO){
                    baseApp.showToast("Espera 4 segundos antes de volver a darle clic a este botón");
                }else {
                    if(spinnerClasifications.getSelectedItemPosition() == 0){
                        position = 0;
                    }else{
                        position = spinnerClasifications.getSelectedItemPosition();
                    }

                    finishVisit(position);

                    ultimoClick = SystemClock.elapsedRealtime();
                }
            });
            btnCancel.setOnClickListener(v -> menuBottomSheet.dismiss());

        }catch (Exception ex){
            baseApp.showToast("No se puede mostrar la alerta de clasificaciones. " + ex);
        }
    }

    public void finishVisit(int clasification) {
        BaseApp baseApp = new BaseApp(this);
        SPClass spClass = new SPClass(this);

        int clasificationValue;
        VisitsClients visits;

        try {
            realm = Realm.getDefaultInstance();

            RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class).equalTo("id", nVisit).findAll();

            if (baseApp.statusPermissionUbication()) {
                if (!locationDisabled) {

                    if (realm.where(VisitsClasifications.class).findAll().size() > 0) {
                        try {
                            //RealmResults<VisitsClasifications> visitsClasifications = realm.where(VisitsClasifications.class).equalTo("position", spinnerClasifications.getSelectedItemPosition()).findAll();
                            RealmResults<VisitsClasifications> visitsClasifications = realm.where(VisitsClasifications.class).findAll();
                            clasificationValue = visitsClasifications.get(clasification).getClasificacion();
                        } catch (Exception ex) {
                            clasificationValue = 1;
                            baseApp.showLog("Ocurrió el error:: " + ex);
                        }
                    } else {
                        clasificationValue = 0;
                    }

                    RealmResults<VisitsMovements> movements = realm.where(VisitsMovements.class).equalTo("ruta", idRoute).equalTo("visita", nVisit).findAll();

                    /*for (VisitsMovements movement : movements) {
                        functionsapp.changeMovementsSalesArticle(idRoute, nVisit, movement.getClave_articulo(), movement.getPiezas_devolucion());
                    }*/

                    visits = visitsClients.get(0);
                    realm.beginTransaction();
                    visits.setEs_credito(functionsapp.getIsCredit(nVisit));
                    visits.setVisitada(true);
                    visits.setFecha_visita_fin(baseApp.getCurrentDateFormated());
                    visits.setClasificacion_visita(clasificationValue);
                    visits.setLat_visita_fin(latitudeUser);
                    visits.setLong_visita_fin(longitudeUser);
                    realm.insertOrUpdate(visits);
                    realm.commitTransaction();

                    spClass.deleteSP("inVisit");
                    spClass.deleteSP("nClient");
                    spClass.deleteSP("nList");
                    spClass.deleteSP("nVisit");
                    spClass.deleteSP("sPaymentMethod");

                    if(spClass.boolGetSP("onlineConnection")){
                        backgroundProcess("uploadData");
                    }else{
                        functionsapp.printTicket(nVisit);
                    }

                    functionsapp.goListClientsActivity(nList, true);
                    baseApp.showToast("Visita dada por terminada");

                    if(functionsapp.getIsCredit(nVisit)) {
                        new androidx.appcompat.app.AlertDialog.Builder(this)
                                .setTitle("Venta a crédito")
                                .setMessage("¿Desea imprimir una copia del ticket?")
                                .setCancelable(false)
                                .setPositiveButton("Sí", (dialog, id) -> {
                                    functionsapp.printTicket(nVisit);
                                    functionsapp.goListClientsActivity(nList, true);
                                })
                                .setNegativeButton("No", (dialog, id) -> {
                                    functionsapp.goListClientsActivity(nList, true);
                                })
                                .show();
                    }else{
                        functionsapp.goListClientsActivity(nList, true);
                    }

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        if (notificationManager != null) {
                            notificationManager.cancel(1);
                        }
                    }
                }else{
                    baseApp.showAlertDialog("warning", "Ubicación desactivada", "Por favor, activa el GPS y el Internet y vuelve a intentarlo.", true);
                }
            }else{
                baseApp.showToast("No está activado el permiso de Ubicación");
            }

        }catch(Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al intentar finalizar la visita, reporta el siguiente error al Dpto de Sistemas: " + ex);
            ex.printStackTrace();

            spClass.deleteSP("inVisit");
            spClass.deleteSP("nClient");
            spClass.deleteSP("nList");
            spClass.deleteSP("nVisit");
            spClass.deleteSP("sPaymentMethod");

            finish();
        }
    }

    public void populateVisitsClasifications(){
        try {
            List<String> listClasificationsArray = new ArrayList<>();
            listClasifications = realm.where(VisitsClasifications.class).findAll();

            if (listClasifications.size() == 0) {
                baseApp.showToast("No se encontraron Clasificaciones de Visitas para cargar.");
                //finish();
                spinnerClasifications.setEnabled(false);
            } else {

                for (int i = 0; i < listClasifications.size(); i++) {
                    listClasificationsArray.add(listClasifications.get(i).getNombre_clasificacion().trim());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        this, android.R.layout.simple_spinner_item, listClasificationsArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerClasifications.setAdapter(adapter);
                spinnerClasifications.setEnabled(true);

                RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class).equalTo("id", nVisit).findAll();

                spinnerClasifications.setSelection(visitsClients.get(0).getPosition_clasificacion_visita());
            }
        }catch (Exception ex){
            baseApp.showAlert("Error", "No se pudieron cargar las Clasificaciones de Visitas por este error: " + ex);
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

            if (SystemClock.elapsedRealtime() - ultimoClick < TIEMPO_MINIMO){
                baseApp.showToast("Espera 4 segundos antes de volver a darle clic a este botón");
            }else {
                ultimoClick = SystemClock.elapsedRealtime();
                cancelVisit();
            }

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
                                functionsApp.printTicket(nVisit);
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

    public void onBackPressed() {
        backFunction();
    }

    public void backFunction(){

        if(!searchArticles.isIconified()){
            searchArticles.onActionViewCollapsed();
        }else {
            if(functionsapp.getIsVisitFinished(nVisit)){
                functionsapp.goDetailsSaleActivity(nVisit);
                finish();
            }else{
                showMenuBottomCancelVisit();
            }
        }
    }

    public void getLocation() {
        try {
            if(baseApp.statusPermissionUbication()) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
            }else{
                baseApp.showToast("Por favor, activa el permiso de ubicación.");
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        latitudeUser = location.getLatitude();
        longitudeUser = location.getLongitude();
    }

    @Override
    public void onProviderDisabled(String provider) {
        //Toast.makeText(ListClientsActivity.this, "Por favor, activa el GPS y el Internet", Toast.LENGTH_SHORT).show();
        baseApp.showToast("GPS desactivado. Por favor, actívalo.");
        locationDisabled = true;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        //Toast.makeText(this, "Se ha activado un proveedor de Ubicación " + provider, Toast.LENGTH_SHORT).show();
        locationDisabled = false;
    }

    @Override
    public void onChange(RealmResults<Articles> articles) {

    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }
}
