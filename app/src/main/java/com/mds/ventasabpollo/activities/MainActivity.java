package com.mds.ventasabpollo.activities;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterLists;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.ConnectionClass;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.classes.ShakeDetector;
import com.mds.ventasabpollo.models.Articles;
import com.mds.ventasabpollo.models.Cities;
import com.mds.ventasabpollo.models.Clients;
import com.mds.ventasabpollo.models.ClientsLists;
import com.mds.ventasabpollo.models.Departures;
import com.mds.ventasabpollo.models.DetailsDepartures;
import com.mds.ventasabpollo.models.Lists;
import com.mds.ventasabpollo.models.MapRoutes;
import com.mds.ventasabpollo.models.MethodPay;
import com.mds.ventasabpollo.models.NewClients;
import com.mds.ventasabpollo.models.Prices;
import com.mds.ventasabpollo.models.Routes;
import com.mds.ventasabpollo.models.UseCFDI;
import com.mds.ventasabpollo.models.Users;
import com.mds.ventasabpollo.models.VisitsClasifications;
import com.mds.ventasabpollo.models.WayPay;
import com.mds.ventasabpollo.services.ShakeService;
import com.skyfishjy.library.RippleBackground;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsapp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;

    int nUser, idRoute, totaLists;
    String messagesSync = "";
    String stringSplitVisits, stringSplitSales, stringSplitChanges, stringSplitDevolutions, stringSplitPayments, stringSplitSeparateds, stringSplitClients, stringSplitDomiciles, stringSplitReturns, stringSplitChangesInventories, stringSplitPendingPayments, stringSplitLogs;

    private ProgressDialog dialog;
    RecyclerView recyclerLists;
    RelativeLayout layoutList, layoutStartRoute, layoutNotData;
    Button btnStartRoute, btnFinishRoute;
    Spinner spinnerDays;

    int nDeparture;
    boolean updateGlobalList, goToFinalReport = false;;

    ProgressDialog barSyncData;

    private RealmResults<Lists> listLists;
    private RealmResults<Lists> listLists2;

    Handler handler;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    ArrayList<Departures> departuresList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);
        baseApp.setUpRealmConfig();
        realm = Realm.getDefaultInstance();

        nUser = spClass.intGetSP("user");
        idRoute = spClass.intGetSP("idRoute");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        recyclerLists = findViewById(R.id.recyclerLists);

        layoutList = findViewById(R.id.layoutList);
        layoutNotData = findViewById(R.id.layoutNotData);
        layoutStartRoute = findViewById(R.id.layoutStartRoute);

        btnStartRoute = findViewById(R.id.btnStartRoute);
        btnFinishRoute = findViewById(R.id.btnFinishRoute);

        spinnerDays = findViewById(R.id.spinnerDays);

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerLists.setLayoutManager(mGridLayoutManagerDetails);
        recyclerLists.setItemAnimator(new DefaultItemAnimator());
        recyclerLists.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        barSyncData = new ProgressDialog(this);
        dialog = new ProgressDialog(this);

        if (getIntent().getExtras() != null) {
            nDeparture = getIntent().getExtras().getInt("nDeparture");
            //backgroundProcess("markDepartureLikeAccepted", "bar", "");
        }

        btnStartRoute.setOnClickListener(v-> {

            Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vib.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                //deprecated in API 26
                vib.vibrate(50);
            }

            backgroundProcess("checkDeparture", "bar", "Consultando salidas...");
        });

        btnFinishRoute.setOnClickListener(v-> showMenuBottonFinishRoute());

        functionsapp.inVisitVerify();
        checkAlertConnection();
        populateSpinnerDays();
        getLists(baseApp.getNumberDay());

        /*hideItemAuthorize();
        verifyAlarms();*/

        spinnerDays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                getLists(position+1);

            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        Intent intent = new Intent(this, ShakeService.class);
        startService(intent);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(count -> {

            Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vib.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                //deprecated in API 26
                vib.vibrate(250);
            }

            functionsapp.goInventoryActivity();
        });

        /* Fingir estar en una Ruta para cuando hay errores */
        /*
        spClass.boolSetSP("inRoute", true);
        spClass.boolSetSP("inventoryLoaded", true);
        spClass.intSetSP("idRoute", 42);
        /**/

    }

    private class syncDataTask extends AsyncTask<Void, String, Void> {

        @Override
        protected void onPreExecute() {
            messagesSync = "";

            dialog.setTitle("Sincronizando los datos...");
            dialog.setMessage("Por favor, espera un momento...");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            try (Realm realm = Realm.getDefaultInstance()) {

                publishProgress("Subiendo datos... (14 / 100)");
                uploadData();

                publishProgress("Subiendo clientes... (28 / 100)");
                uploadNewClients();

                publishProgress("Borrando datos... (42 / 100)");
                realm.beginTransaction();

                if(updateGlobalList){
                    realm.delete(Clients.class);
                    realm.delete(ClientsLists.class);
                    realm.delete(Lists.class);
                }else{
                    RealmResults<ClientsLists> listClients = realm.where(ClientsLists.class)
                            .notEqualTo("lista", 0)
                            .findAll();
                    listClients.deleteAllFromRealm();

                    RealmResults<Lists> lists = realm.where(Lists.class)
                            .notEqualTo("lista", 0)
                            .findAll();
                    lists.deleteAllFromRealm();
                }

                /*RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class)
                        .equalTo("ruta", 0)
                        .findAll();
                visitsPayments.deleteAllFromRealm();*/

                realm.delete(Articles.class);
                realm.delete(MapRoutes.class);
                realm.delete(VisitsClasifications.class);

                //realm.delete(Alarms.class);

                baseApp.showLog("Datos borrados");
                realm.commitTransaction();

                publishProgress("Descargando datos... (56 / 100)");
                loadData();

                publishProgress("Descargando datos de Combos... (70 / 100)");
                loadSpinnersData();

                publishProgress("Creando Rutas de Mapas... (84 / 100)");
                loadMapRoutes();

                publishProgress("Finalizando... (100 / 100)");

                /*
                publishProgress("Descargando Personal... (95 / 100)");
                loadPersonal();
                */

            } catch (Exception e) {
                baseApp.showLog("Ocurrió el error: " + e);
                e.printStackTrace();
            }

            return null;
        }

        protected void onProgressUpdate(String... s) {
            dialog.setMessage(s[0]);
        }

        @Override
        protected void onPostExecute(Void result) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }

            spClass.strSetSP("date_last_sync", baseApp.getCurrentDateFormated());

            /*if(functionsapp.countAlarmsWithoutRead() > 0){
                //verifyAlarms();
            }else{
            */
            if (messagesSync.length() > 0) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Resultado de la sincronización")
                        .setMessage(messagesSync)
                        .setCancelable(true)
                        .setPositiveButton("Ok", (dialog, id) -> dialog.cancel())
                        .show();
            }

            getLists(baseApp.getNumberDay());
        }
    }

    public void populateSpinnerDays(){
        try {

            String[] listClasifications = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
            List<String> listClasificationsArray = new ArrayList<>();

            for (int i = 0; i < listClasifications.length; i++) {
                listClasificationsArray.add(listClasifications[i]);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_spinner_item, listClasificationsArray);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerDays.setAdapter(adapter);
            spinnerDays.setEnabled(true);

            spinnerDays.setSelection((baseApp.getNumberDay()-1));
        }catch (Exception ex){
            baseApp.showAlert("Error", "No se pudieron cargar las opciones de los días por este error: " + ex);
        }
    }

    public void getLists(int day){

        try {
            realm = Realm.getDefaultInstance();
            listLists2 = realm.where(Lists.class).equalTo("user_id", nUser).findAll();
            listLists = realm.where(Lists.class).equalTo("dia_semana", day).equalTo("dia_semana", day).or().equalTo("dia_semana", 0).equalTo("user_id", nUser).sort("dia_semana", Sort.DESCENDING).findAll();
            totaLists = listLists.size();

            /*if (listLists.size() > 0) {
                layoutList.setVisibility(View.VISIBLE);
                layoutNotData.setVisibility(View.GONE);
                layoutStartRoute.setVisibility(View.GONE);
                spinnerDays.setVisibility(View.VISIBLE);

                AdapterLists adapterLists = new AdapterLists(this, listLists);

                recyclerLists.setItemAnimator(new DefaultItemAnimator());
                recyclerLists.setAdapter(adapterLists);
            } else {
                layoutList.setVisibility(View.GONE);
                layoutStartRoute.setVisibility(View.GONE);
                layoutNotData.setVisibility(View.VISIBLE);

                spinnerDays.setVisibility(View.VISIBLE);
            }*/


            if(spClass.boolGetSP("inRoute")) {
                if (listLists.size() > 0) {
                    layoutList.setVisibility(View.VISIBLE);
                    layoutNotData.setVisibility(View.GONE);
                    layoutStartRoute.setVisibility(View.GONE);
                    spinnerDays.setVisibility(View.VISIBLE);

                    AdapterLists adapterLists = new AdapterLists(this, listLists);

                    recyclerLists.setItemAnimator(new DefaultItemAnimator());
                    recyclerLists.setAdapter(adapterLists);
                } else {
                    layoutList.setVisibility(View.GONE);
                    layoutStartRoute.setVisibility(View.GONE);
                    layoutNotData.setVisibility(View.VISIBLE);

                    spinnerDays.setVisibility(View.VISIBLE);
                }
            }else{
                if (listLists2.size() > 0) {
                    layoutStartRoute.setVisibility(View.VISIBLE);
                    layoutList.setVisibility(View.GONE);
                    layoutNotData.setVisibility(View.GONE);

                }else {
                    layoutList.setVisibility(View.GONE);
                    layoutStartRoute.setVisibility(View.GONE);
                    layoutNotData.setVisibility(View.VISIBLE);
                }

                spinnerDays.setVisibility(View.GONE);
            }

        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar las listas, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void showMenuBottomSyncData(){
        BottomSheetDialog menuBottomSheet;
        TextView btnYes, btnYes2, btnNo, txtViewTitle;

        menuBottomSheet = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);
        menuBottomSheet.setContentView(R.layout.bottom_sheet_sync_data);
        menuBottomSheet.setCancelable(true);
        menuBottomSheet.show();

        txtViewTitle = menuBottomSheet.findViewById(R.id.txtViewInfo);
        btnYes = menuBottomSheet.findViewById(R.id.btnYes);
        btnYes2 = menuBottomSheet.findViewById(R.id.btnYes2);
        btnNo = menuBottomSheet.findViewById(R.id.btnNo);

        txtViewTitle.setText("¿Deseas sincronizar los datos?");
        btnYes.setOnClickListener(v-> {
            updateGlobalList = false;
            syncData();
            menuBottomSheet.dismiss();
        });

        btnYes2.setOnClickListener(v-> {
            updateGlobalList = true;
            syncData();
            menuBottomSheet.dismiss();
        });

        btnNo.setOnClickListener(v-> menuBottomSheet.dismiss());
    }

    public void showMenuBottonFinishRoute(){
        BottomSheetDialog menuBottomSheet;
        TextView btnYes, btnNo, txtViewTitle;

        menuBottomSheet = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);
        menuBottomSheet.setContentView(R.layout.bottom_sheet_confirm);
        menuBottomSheet.setCancelable(true);
        menuBottomSheet.show();

        txtViewTitle = menuBottomSheet.findViewById(R.id.txtViewInfo);
        btnYes = menuBottomSheet.findViewById(R.id.btnYes);
        btnNo = menuBottomSheet.findViewById(R.id.btnNo);

        txtViewTitle.setText("¿Deseas terminar la ruta?");
        btnYes.setOnClickListener(v-> {
            //new IntentIntegrator(MainActivity.this).initiateScan();
            if(canFinishRoute()){
                backgroundProcess("markDepartureLikeFinished", "bar", "Terminando Ruta...");
            }else{
                baseApp.showAlert("Error", "Sincroniza todos los datos antes de terminar la ruta.");
            }

            menuBottomSheet.dismiss();
        });
        btnNo.setOnClickListener(v-> menuBottomSheet.dismiss());
    }

    public boolean canFinishRoute(){
        try{

            stringSplitVisits = functionsapp.generateSplitVisits();
            stringSplitSales = functionsapp.generateSplitSales();
            stringSplitChanges = functionsapp.generateSplitChanges();
            stringSplitDevolutions = functionsapp.generateSplitDevolutions();
            stringSplitPayments = functionsapp.generateSplitPayments();
            stringSplitSeparateds = functionsapp.generateSplitSeparateds();
            stringSplitReturns = functionsapp.generateSplitReturns();
            stringSplitChangesInventories = functionsapp.generateSplitChangesInventory();

            if(stringSplitVisits.isEmpty() &&
                    stringSplitSales.isEmpty() &&
                    stringSplitChanges.isEmpty() &&
                    stringSplitDevolutions.isEmpty() &&
                    stringSplitPayments.isEmpty() &&
                    stringSplitSeparateds.isEmpty() &&
                    stringSplitReturns.isEmpty() &&
                    stringSplitChangesInventories.isEmpty()){
                return true;
            }else{
                return false;
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error: " + ex);
            ex.printStackTrace();

            return false;
        }
    }

    public void syncData() {
        barSyncData.setTitle("Preparando descarga...");
        barSyncData.setMessage("Espera unos momentos...");
        barSyncData.setIndeterminate(true);
        barSyncData.setCancelable(false);
        barSyncData.show();

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            try {
                if(baseApp.isOnline(MainActivity.this)) {
                    if (baseApp.verifyServerConnection()) {
                        barSyncData.dismiss();
                        new syncDataTask().execute();
                    } else {
                        baseApp.showAlertDialog("error", "Error al cargar", "No hay conexión al Servidor, reconfigura los datos de conexión e inténtalo de nuevo.", true);
                        barSyncData.dismiss();
                    }
                }else{
                    baseApp.showAlertDialog("error", "Error al sincronizar", "Prende tu señal de datos o conéctate a una red WIFI para poder descargar los datos", true);
                    barSyncData.dismiss();
                }
            } catch (Exception ex) {
                baseApp.showLog("Ocurrió un error al sincronizar los Datos, reporta el siguiente error al Dpto de Sistemas: " + ex);
                barSyncData.dismiss();
            }

        }, 1000);
    }

    public void loadData() {

        VisitsClasifications visitsClasifications;
        Lists lists;
        ClientsLists clientsLists;
        Clients clients;
        Articles articles;
        Prices prices;
        //Alarms alarms;
        //VisitsPayments visitsPayments;

        boolean isResultSet;
        int countResults = 0, position = 0, nList, nClient, idAlarm = 0, lastId = 0;

        try (Realm realm = Realm.getDefaultInstance()) {

            PreparedStatement loComando = baseApp.execute_SP("EXECUTE AbPollo.dbo.Consulta_Datos_Android ?, ?");

            if (loComando == null) {
                //baseApp.showToast("Error al Crear SP Consulta_Datos_Android");
                baseApp.showLog("Error al Crear SP Consulta_Datos_Android");
                messagesSync += "\n\n Error al Crear SP Consulta_Datos_Android";

            } else {
                try {

                    loComando.setInt(1, nUser); //agente

                    if(updateGlobalList){
                        loComando.setInt(2, 1);
                    }else{
                        loComando.setInt(2, 0);
                    }

                    isResultSet = loComando.execute();

                    while (true) {
                        if (isResultSet) {

                            if (countResults == 0) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando Listas...");

                                while (Datos.next()) {
                                    nList = Datos.getInt("lista");

                                    if (realm.where(Lists.class).equalTo("lista", nList).findAll().size() == 0) {
                                        realm.beginTransaction();
                                        lists = new Lists(
                                                Datos.getInt("lista"),
                                                Datos.getString("nombre_lista"),
                                                Datos.getString("nombre_ruta"),
                                                Datos.getString("comentarios"),
                                                Datos.getInt("dia"),
                                                nUser);

                                        realm.copyToRealm(lists);
                                        realm.commitTransaction();
                                    }
                                }

                                Datos.close();
                            }

                            if (countResults == 1) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando Clientes de Listas...");

                                while (Datos.next()) {

                                    realm.beginTransaction();
                                    clientsLists = new ClientsLists(
                                            Datos.getInt("cliente"),
                                            Datos.getInt("lista"),
                                            Datos.getInt("orden"));

                                    realm.copyToRealm(clientsLists);
                                    realm.commitTransaction();

                                    position++;
                                }

                                Datos.close();
                            }

                            if (countResults == 2) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando Clientes...");

                                while (Datos.next()) {
                                    nClient = Datos.getInt("cliente");

                                    realm.beginTransaction();
                                    clients = new Clients(
                                            Datos.getInt("cliente"),
                                            Datos.getInt("sucursal"),
                                            Datos.getString("nombre_cliente"),
                                            Datos.getString("nombre_comercial"),
                                            Datos.getString("calle"),
                                            Datos.getString("numero_exterior"),
                                            Datos.getString("codigo_postal"),
                                            Datos.getString("direccion"),
                                            Datos.getString("colonia"),
                                            Datos.getString("nombre_ciudad"),
                                            Datos.getInt("ciudad"),
                                            Datos.getInt("domicilio"),
                                            Datos.getString("telefono"),
                                            Datos.getString("ultima_compra"),
                                            Datos.getString("listas"),
                                            Datos.getDouble("latitud"),
                                            Datos.getDouble("longitud"),
                                            Datos.getDouble("limite_credito"),
                                            Datos.getDouble("saldo_actual"),
                                            Datos.getInt("numero_precio"));

                                    realm.copyToRealm(clients);
                                    realm.commitTransaction();
                                }

                                Datos.close();
                            }

                            if (countResults == 3) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando artículos...");

                                while (Datos.next()) {
                                    realm.beginTransaction();
                                    articles = new Articles(
                                            Datos.getInt("clave_articulo"),
                                            Datos.getInt("familia"),
                                            Datos.getInt("sublinea"),
                                            Datos.getString("articulo").trim(),
                                            Datos.getString("nombre_articulo").trim(),
                                            Datos.getString("nombre_unidad"),
                                            Datos.getString("descripcion_extendida"));

                                    realm.copyToRealm(articles);
                                    realm.commitTransaction();
                                }

                                Datos.close();
                            }

                            if (countResults == 4) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando Clasificaciones de Visitas...");
                                while (Datos.next()) {

                                    realm.beginTransaction();
                                    visitsClasifications = new VisitsClasifications(
                                            Datos.getInt("clasificacion"),
                                            Datos.getString("nombre_clasificacion"));

                                    realm.copyToRealm(visitsClasifications);
                                    realm.commitTransaction();
                                }

                                Datos.close();
                            }

                            if (countResults == 5) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando precios de artículos...");

                                while (Datos.next()) {

                                    realm.beginTransaction();
                                    deletePrice(Datos.getInt("cliente"), Datos.getInt("clave_articulo"));

                                    prices = new Prices(
                                            Datos.getInt("cliente"),
                                            Datos.getInt("clave_articulo"),
                                            Datos.getDouble("precio"),
                                            Datos.getInt("tiene_iva"),
                                            Datos.getDouble("tasa_iva"),
                                            Datos.getDouble("tasa_IEPS"),
                                            Datos.getString("tipo_IEPS"),
                                            Datos.getString("fecha_actualizacion"),
                                            Datos.getInt("promedio_piezas"),
                                            nUser);

                                    baseApp.showLog("Precios cargados del cliente " + Datos.getInt("cliente") + ", del artículo " + Datos.getInt("clave_articulo"));

                                    realm.copyToRealm(prices);
                                    realm.commitTransaction();
                                }

                                Datos.close();
                            }

                            /*

                            if (countResults == 5) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando alarmas...");

                                while (Datos.next()) {
                                    idAlarm++;

                                    if(lastId != Datos.getInt("apartado")){
                                        realm.beginTransaction();

                                        alarms = new Alarms(
                                                idAlarm,
                                                Datos.getString("nombre_cliente"),
                                                Datos.getString("fecha"),
                                                Datos.getString("informacion_alarma"),
                                                Datos.getInt("cliente"),
                                                Datos.getInt("apartado"),
                                                false,
                                                nUser);
                                        lastId = Datos.getInt("apartado");

                                        realm.copyToRealm(alarms);
                                        realm.commitTransaction();
                                    }else{

                                        RealmResults<Alarms> alarmsList = realm.where(Alarms.class).equalTo("apartado", Datos.getInt("apartado")).findAll();

                                        if(alarmsList.size() > 0){
                                            realm.beginTransaction();
                                            alarmsList.get(0).setInformacion_alarma(alarmsList.get(0).getInformacion_alarma() + Datos.getString("informacion_alarma"));
                                            realm.insertOrUpdate(alarmsList.get(0));
                                            realm.commitTransaction();
                                        }

                                        lastId = Datos.getInt("apartado");
                                    }
                                }

                                Datos.close();
                            }

                            if (countResults == 6) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando pagos pendientes...");

                                while (Datos.next()) {

                                    realm.beginTransaction();
                                    visitsPayments = new VisitsPayments(
                                            Datos.getInt("pago"),
                                            Datos.getInt("visita"),
                                            Datos.getInt("cliente"),
                                            Datos.getDouble("importe"),
                                            Datos.getString("forma_pago").trim(),
                                            Datos.getString("fecha"),
                                            true,
                                            nUser);

                                    realm.copyToRealm(visitsPayments);
                                    realm.commitTransaction();
                                }

                                Datos.close();
                            }*/

                        } else {
                            if (loComando.getUpdateCount() == -1) {
                                break;
                            }

                            baseApp.showLog("Result {} is just a count: {}" + countResults + ", " + loComando.getUpdateCount());
                        }

                        countResults++;
                        isResultSet = loComando.getMoreResults();
                    }

                    if (realm.where(Lists.class).findAll().size() == 0) {
                        baseApp.showLog("No se encontraron Listas para cargar");
                        messagesSync += "\n\n No se encontraron Listas para cargar";
                    } else {
                        baseApp.showLog("Listas cargadas");
                        messagesSync += "\n\n Listas cargadas";
                    }

                    if (realm.where(ClientsLists.class).findAll().size() == 0) {
                        baseApp.showLog("No se encontraron Listas de Clientes para cargar");
                        messagesSync += "\n\n No se encontraron Listas de Clientes para cargar";
                    } else {
                        baseApp.showLog("Listas de Clientes cargadas");
                        messagesSync += "\n\n Listas de Clientes cargadas";
                    }

                    if (realm.where(Clients.class).findAll().size() == 0) {
                        baseApp.showLog("No se encontraron Clientes para cargar");
                        messagesSync += "\n\n No se encontraron Clientes para cargar";
                    } else {
                        baseApp.showLog("Clientes cargadas");
                        messagesSync += "\n\n Clientes cargadas";
                    }

                    if (realm.where(Articles.class).findAll().size() == 0) {
                        baseApp.showLog("No se encontraron Artículos para cargar");
                        messagesSync += "\n\n No se encontraron Artículos para cargar";
                    } else {
                        baseApp.showLog("Artículos cargados");
                        messagesSync += "\n\n Artículos cargados";
                    }

                    if (realm.where(VisitsClasifications.class).findAll().size() == 0) {
                        baseApp.showLog("No se encontraron Clasificaciones de Visitas para cargar");
                        messagesSync += "\n\n No se encontraron Clasificaciones de Visitas para cargar";
                    } else {
                        baseApp.showLog("Clasificaciones de Visitas cargados");
                        messagesSync += "\n\n Clasificaciones de Visitas cargados";
                    }


                    if (realm.where(Prices.class).findAll().size() == 0) {
                        baseApp.showLog("No se encontraron Precios de Artículos para cargar");
                        messagesSync += "\n\n No se encontraron Precios de Artículos para cargar";
                    } else {
                        baseApp.showLog("Precios de Artículos cargados");
                        messagesSync += "\n\n Precios de Artículos cargados";
                    }

                    /*
                    if (realm.where(Alarms.class).findAll().size() == 0) {
                        baseApp.showLog("No se encontraron Alarmas para cargar");
                        messagesSync += "\n\n No se encontraron Alarmas para cargar";

                    } else {
                        baseApp.showLog("Alarmas cargados");
                        messagesSync += "\n\n Alarmas cargados";
                    }*/

                } catch (Exception ex) {
                    baseApp.showLog("Error en SP Consulta_Datos_Android, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
                    messagesSync += "\n\n Error en SP Consulta_Datos_Andro id, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso";
                }
            }
        }
    }

    public void uploadNewClients(){

        baseApp.showLog("Comenzando a sincronizar los nuevos clientes...");

        try (Realm realm = Realm.getDefaultInstance()) {

            RealmResults<NewClients> newClients = realm.where(NewClients.class).equalTo("sincronizado", false).findAll();

            int countClients = newClients.size();

            if(countClients > 0) {

                for (NewClients client : newClients) {
                    PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.Guarda_Cliente_Android ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
                    if (loComando == null) {
                        baseApp.showLog("Error al Crear SP Guarda_Cliente_Android");
                        messagesSync += "\n\n Error al Crear SP Guarda_Cliente_Android";

                    } else {
                        try {

                            loComando.setString(1, "      1");
                            loComando.setInt(2, nUser);
                            loComando.setInt(3, nUser);
                            loComando.setInt(4, nUser);
                            loComando.setString(5, "      1");
                            loComando.setInt(6, 1);
                            loComando.setInt(7, 1);
                            loComando.setInt(8, 1);
                            loComando.setInt(9, client.getCiudad());
                            loComando.setInt(10, 0); // colonia
                            loComando.setString(11, client.getNombre_cliente());
                            loComando.setString(12, client.getNombre_comercial());
                            loComando.setString(13, client.getRfc());
                            loComando.setString(14, client.getCurp());
                            loComando.setString(15, "");
                            loComando.setString(16, client.getCorreo_electronico());
                            loComando.setString(17, ""); //forma pago
                            loComando.setString(18, ""); // cuenta
                            loComando.setString(19, ""); // uso
                            loComando.setString(20, ""); // método
                            loComando.setString(21, client.getNombre_contacto());
                            loComando.setString(22, client.getApellido_contacto());
                            loComando.setString(23, client.getNombre_calle());
                            loComando.setString(24, client.getNo_exterior());
                            loComando.setString(25, client.getNo_interior());
                            loComando.setString(26, client.getCodigo_postal());
                            loComando.setString(27, client.getColonia());
                            loComando.setString(28, client.getLocalidad());
                            loComando.setString(29, client.getMunicipio());
                            loComando.setString(30, client.getDescripcion());
                            loComando.setString(31, client.getNombre_calle() + " No. " + client.getNo_exterior() + " Int. " + client.getNo_exterior());
                            loComando.setString(32, ""); // area
                            loComando.setString(33, client.getTelefono());
                            loComando.setBoolean(34, false);
                            loComando.setBoolean(35, false);

                            ResultSet Datos = loComando.executeQuery();

                            while (Datos.next()) {

                                if (Datos.getInt("exito") == 1) {
                                    baseApp.showLog("Datos del cliente : " + client.getNombre_cliente() + " guardados en el Sistema");
                                    messagesSync += "\n\n Datos del cliente : " + client.getNombre_cliente() + " guardados en el Sistema";

                                    markClientLikeSent(client.getId());
                                } else {
                                    baseApp.showLog("Ocurrió un error al guardar los datos del cliente: " + client.getNombre_cliente());
                                    messagesSync += "\n\n Ocurrió un error al guardar los datos del cliente: " + client.getNombre_cliente();
                                }
                            }
                        } catch (Exception ex) {
                            baseApp.showLog("Error en SP Guarda_Cliente_Android, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
                            messagesSync += "\n\n Error en SP Guarda_Cliente_Android, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso";
                        }
                    }
                }
            }
        }catch (Exception ex){
            baseApp.showLog("ERRROR: " + ex);
        }

        baseApp.showLog("Fin de la sincronización de datos");
    }

    public void markClientLikeSent(int idClient){
        try (Realm realm = Realm.getDefaultInstance()) {

            RealmResults<NewClients> client = realm.where(NewClients.class).equalTo("id", idClient).findAll();
            int countClients = client.size();

            if (countClients > 0) {
                realm.beginTransaction();
                client.get(0).setSincronizado(true);
                client.get(0).setFecha_sincronizado(baseApp.getCurrentDateFormated());
                realm.commitTransaction();

                baseApp.showLog("Cliente " + client.get(0).getNombre_cliente() + " sincronizado al Servidor marcado como enviado");
            }

        }catch (Exception ex){
            baseApp.showLog("Ocurrió el error: " + ex + " y se detuvo el proceso");
            messagesSync += "\n\nOcurrió el error: " + ex + " y se detuvo el proceso" + ", al intentar marcas los clientes como enviadas";
        }
    }

    public void deletePrice(int client, int article){
        try{

            try (Realm realm = Realm.getDefaultInstance()) {
                RealmResults<Prices> results = realm.where(Prices.class).equalTo("cliente", client).equalTo("clave_articulo", article).findAll();
                results.deleteAllFromRealm();
            }

        }catch (Exception ex){
            baseApp.showLog("Ocurrió un error al intentar eliminar un precio: " + ex);
        }
    }

    public void checkAlertConnection(){
        if(spClass.strGetSP("IPConnection").equals("ND")){
            //showMenuBottomNoServer();
        }
    }

    public void newClient(){
        try{
            int idNewClient = spClass.intGetSP("idNewClient");

            if (idNewClient == 0) {
                baseApp.showToast("Espera un momento, cargando componentes...");
                functionsapp.addNewClient();
            } else {
                new AlertDialog.Builder(this)
                        .setMessage("Tienes un cliente nuevo en borrador, deseas continuar o empezar uno nuevo.")
                        .setCancelable(true)
                        .setPositiveButton("Continuar registrándolo", (dialog, id2) -> {
                            baseApp.showToast("Recuperando información, espera un momento...");
                            functionsapp.goAddClientActivity();
                        })
                        .setNegativeButton("Empezar uno nuevo", (dialog, id2) -> {
                            baseApp.showToast("Espera un momento, cargando componentes...");
                            functionsapp.cancelAddClient();
                            functionsapp.addNewClient();
                        })
                        .show();
            }
        }catch (Exception ex) {
            baseApp.showToast("Ocurrió un error.");
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        int id = item.getItemId();

        /*if(id == R.id.nav_authorize){
            //functionsapp.goSellersDeparturesActivity();
        }else */
        if (id == R.id.nav_sync) {
            showMenuBottomSyncData();
        } else if (id == R.id.nav_account) {
            functionsapp.goAccountActivity();
        } else if (id == R.id.nav_routes) {
            functionsapp.goRoutesActivity();
        }else if(id == R.id.nav_change_connection){
            functionsapp.goChangeConnection();
        }/*else if(id == R.id.nav_alarms){
            //functionsapp.goAlarmsActivity();
        }*/else if(id == R.id.nav_about){
            functionsapp.goAboutActivity();
        }else if(id == R.id.nav_new_client) {
            newClient();
        }else if(id == R.id.nav_configuration){
            functionsapp.goConfigurationActivity();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(spClass.boolGetSP("inRoute") && spClass.boolGetSP("inventoryLoaded")){
            //getMenuInflater().inflate(R.menu.menu_main, menu);
        }

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.menu_option_finish){
            //showMenuBottonFinishRoute();
        }

        return super.onOptionsItemSelected(item);
    }

    public void checkDeparture(){

        try{

            RealmResults<Users> personal = realm.where(Users.class).findAll();
            boolean isResultSet;
            int countResults = 0, resultCount = 0, nDeparture = 0;
            String nameAuthorized = null;
            Departures departures;
            DetailsDepartures detailsDepartures;

            try {
                ConnectionClass connectionClass = new ConnectionClass(getApplicationContext());

                if (connectionClass.ConnectionMDS() != null) {
                    PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.Consulta_Salidas_Vendedor ?, ?");

                    try {
                        loComando.setInt(1, nUser);
                        loComando.setInt(2, 1);

                        isResultSet = loComando.execute();

                        if (departuresList != null) {
                            departuresList.clear();
                        }

                        realm.beginTransaction();
                        realm.delete(DetailsDepartures.class);
                        realm.commitTransaction();

                        while (true) {
                            if (isResultSet) {

                                if (countResults == 0) {
                                    ResultSet Datos = loComando.getResultSet();

                                    while (Datos.next()) {
                                        resultCount = Datos.getInt("total");

                                        if (resultCount == 0) {
                                            baseApp.showToast("No se encontraron Salidas Autorizadas asignadas para tu usuario.");
                                        }
                                    }

                                    Datos.close();
                                }

                                if (countResults == 1) {

                                    ResultSet Datos1 = loComando.getResultSet();

                                    while (Datos1.next()) {

                                        departures = new Departures();
                                        departures.setSalida(Datos1.getInt("salida"));
                                        departures.setVendedor(Datos1.getString("vendedor"));
                                        departures.setRegistrado_por(Datos1.getString("registrado_por"));
                                        departures.setAutorizado_por(Datos1.getString("autorizado_por"));
                                        departures.setFecha_registro(Datos1.getString("fecha_registro"));
                                        departures.setEstado_actual(Datos1.getString("estado_actual"));
                                        departures.setLista(Datos1.getInt("lista"));
                                        departures.setNombre_lista(Datos1.getString("nombre_lista"));

                                        departuresList.add(departures);

                                        nDeparture     = Datos1.getInt("salida");
                                        nameAuthorized = Datos1.getString("autorizado_por");
                                    }

                                    Datos1.close();
                                }

                                if (countResults == 2) {

                                    ResultSet Datos2 = loComando.getResultSet();
                                    while (Datos2.next()) {

                                        realm.beginTransaction();
                                        detailsDepartures = new DetailsDepartures(
                                                Datos2.getInt("salida"),
                                                Datos2.getInt("clave_articulo"),
                                                Datos2.getString("nombre_articulo"),
                                                Datos2.getDouble("cantidad"));

                                        realm.copyToRealm(detailsDepartures);
                                        realm.commitTransaction();
                                    }

                                    Datos2.close();
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

                        if(resultCount > 0){
                            for (Departures departure : departuresList) {

                                RealmResults<Articles> articles = realm.where(Articles.class).findAll();
                                for (Articles article : articles) {

                                    RealmResults<DetailsDepartures> details = realm.where(DetailsDepartures.class)
                                            .equalTo("salida", departure.getSalida())
                                            .equalTo("clave_articulo", article.getClave_articulo())
                                            .findAll();
                                    if (details.size() == 0) {
                                        /*realm.beginTransaction();
                                        detailsDepartures = new DetailsDepartures(
                                                departure.getSalida(),
                                                article.getClave_articulo(),
                                                article.getNombre_articulo(),
                                                0);

                                        realm.copyToRealm(detailsDepartures);
                                        realm.commitTransaction();

                                        baseApp.showLog("Detalle agregado");*/
                                    }
                                }
                            }

                            functionsapp.goDetailsDepartureActivity(nDeparture, nameAuthorized);
                        }

                    } catch (Exception ex) {
                        baseApp.showToast("Error al buscar las Salidas de un Vendedor");
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

    public void loadSpinnersData() {

        WayPay wayPay;
        UseCFDI useCFDI;
        MethodPay methodPay;
        Cities cities;

        boolean isResultSet;
        int countResults = 0, i = 0;

        try (Realm realm = Realm.getDefaultInstance()) {

            PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.Combos_Añadir_Cliente_Android");

            if (loComando == null) {
                //baseApp.showToast("Error al Crear SP Consulta_Datos_Android");
                baseApp.showLog("Error al Crear SP Combos_Añadir_Cliente_Android");
                messagesSync += "\n\n Error al Crear SP Combos_Añadir_Cliente_Android";

            } else {
                try {

                    isResultSet = loComando.execute();

                    while (true) {
                        if (isResultSet) {

                            if (countResults == 0) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando Formas de Pago...");
                                while (Datos.next()) {

                                    realm.beginTransaction();
                                    wayPay = new WayPay(
                                            Datos.getString("descripcion"),
                                            Datos.getString("forma_SAT"));

                                    realm.copyToRealm(wayPay);
                                    realm.commitTransaction();
                                }

                                Datos.close();
                            }

                            if (countResults == 1) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando Uso de CFDI...");

                                while (Datos.next()) {

                                    realm.beginTransaction();
                                    useCFDI = new UseCFDI(
                                            Datos.getString("descripcion"),
                                            Datos.getString("uso_SAT"));

                                    realm.copyToRealm(useCFDI);
                                    realm.commitTransaction();
                                }

                                Datos.close();
                            }

                            if (countResults == 2) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando Método de Pago...");

                                while (Datos.next()) {

                                    realm.beginTransaction();
                                    methodPay = new MethodPay(
                                            Datos.getString("descripcion"),
                                            Datos.getString("metodo_SAT"));

                                    realm.copyToRealm(methodPay);
                                    realm.commitTransaction();
                                }

                                Datos.close();
                            }

                            if (countResults == 3) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando Ciudades...");
                                i = 0;

                                while (Datos.next()) {

                                    i++;
                                    realm.beginTransaction();
                                    cities = new Cities(
                                            i,
                                            Datos.getInt("ciudad"),
                                            Datos.getString("nombre"));

                                    realm.copyToRealm(cities);
                                    realm.commitTransaction();
                                }

                                Datos.close();
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

                    if (realm.where(WayPay.class).findAll().size() == 0) {
                        baseApp.showLog("No se encontraron Métodos de pago para cargar");
                        messagesSync += "\n\n No se encontraron Métodos de pago  de Visitas para cargar";

                    } else {
                        baseApp.showLog("Métodos de pago  de Visitas cargados");
                        messagesSync += "\n\n Métodos de pago  de Visitas cargados";
                    }

                    if (realm.where(UseCFDI.class).findAll().size() == 0) {
                        baseApp.showLog("No se encontraron lista de Uso de CFDI");
                        messagesSync += "\n\n No se encontraron lista de Uso de CFDI";

                    } else {
                        baseApp.showLog("Lista de Uso de CFDI cargadas");
                        messagesSync += "\n\n Lista de Uso de CFDI cargadas";
                    }

                    if (realm.where(MethodPay.class).findAll().size() == 0) {
                        baseApp.showLog("No se encontraron métodos de pago de Clientes para cargar");
                        messagesSync += "\n\n No se encontraron métodos de pago de Clientes para cargar";

                    } else {
                        baseApp.showLog("Métodos de pago cargadas");
                        messagesSync += "\n\n Métodos de pago cargadas";
                    }

                    if (realm.where(Cities.class).findAll().size() == 0) {
                        baseApp.showLog("No se encontraron Ciudades para cargar");
                        messagesSync += "\n\n No se encontraron Ciudades para cargar";

                    } else {
                        baseApp.showLog("Ciudades cargadas");
                        messagesSync += "\n\n Ciudades cargadas";
                    }

                } catch (Exception ex) {
                    //baseApp.showAlert("Error", "Error en SP Consulta_Datos_Android, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
                    baseApp.showLog("Error en SP Combos_Añadir_Cliente_Android, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
                    messagesSync += "\n\n Error en SP Combos_Añadir_Cliente_Android, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso";
                }
            }
        }
    }

    public void loadMapRoutes() {

        final FunctionsApp functionsapp = new FunctionsApp(this);
        MapRoutes mapRoutes;
        List<MapRoutes> listMapRoutes;

        try (Realm realm = Realm.getDefaultInstance()) {

            try {

                RealmResults<ClientsLists> listClients = realm.where(ClientsLists.class)
                        .findAll();
                int totaListClients = listClients.size();

                for (int i = 0; i < totaListClients; i++) {
                    realm.beginTransaction();

                    Clients client = realm.where(Clients.class).equalTo("cliente", listClients.get(i).getCliente()).findFirst();

                    mapRoutes = new MapRoutes(
                            listClients.get(i).getLista(),
                            listClients.get(i).getCliente(),
                            client.getNombre_cliente(),
                            client.getNombre_comercial(),
                            client.getLatitud(),
                            client.getLongitud(),
                            listClients.get(i).getOrden(),
                            client.getUser_id());

                    realm.copyToRealm(mapRoutes);
                    realm.commitTransaction();
                }

                RealmResults<MapRoutes> mapRoutesB = realm.where(MapRoutes.class).equalTo("user_id", nUser).findAll();
                int totalMapRoutes = mapRoutesB.size();

                if (totalMapRoutes == 0) {
                    //functionsapp.showToast("No se cargaron las Rutas de Clientes");
                    baseApp.showLog("No se cargaron las Rutas de Clientes");
                }else{
                    baseApp.showLog("Rutas de Clientes cargadas");
                }

            } catch (Exception ex) {
                //functionsespp.showAlert("Error", "Ocurrió un error al cargar las Rutas de Clientes: " + ex);
                messagesSync = messagesSync + "\nERROR un error al cargas las Rutas de Clientes: " + ex;
            }
        }
    }

    public void markDepartureLikeAccepted(int nDeparture){

        try {
            PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.CE_Salida_Ventas ?, ?");
            if (loComando == null) {
                baseApp.showLog("Error al Crear SP CE_Salida_Ventas");

            } else {
                try {

                    loComando.setInt(1, nDeparture);
                    loComando.setString(2, "Aceptada");

                    ResultSet Datos = loComando.executeQuery();

                    while (Datos.next()) {

                        if (Datos.getInt("exito") == 1) {
                            baseApp.showToast("Salida marcada como Aceptada con éxito");
                        }
                    }
                } catch (Exception ex) {
                    baseApp.showLog("Error en SP CE_Salida_Ventas, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
                }
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    public void markDepartureLikeFinished(){

        try {
            int nDeparture;

            RealmResults<Routes> routes = realm.where(Routes.class).equalTo("ruta", idRoute).findAll();
            nDeparture = routes.get(0).getSalida();

            PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.CE_Salida_Ventas ?, ?");
            if (loComando == null) {
                baseApp.showLog("Error al Crear SP CE_Salida_Ventas");

            } else {
                try {

                    loComando.setInt(1, nDeparture);
                    loComando.setString(2, "Terminada");

                    ResultSet Datos = loComando.executeQuery();

                    while (Datos.next()) {

                        if (Datos.getInt("exito") == 1) {
                            goToFinalReport = true;

                            functionsapp.finishRoute(idRoute, 0, "");
                            uploadData();
                        }
                    }
                } catch (Exception ex) {
                    baseApp.showLog("Error en SP CE_Salida_Ventas, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
                }
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    public void uploadData(){
        functionsapp.uploadData();

        if(goToFinalReport){
            goToFinalReport = false;

            functionsapp.goFinalReportRouteActivity(spClass.intGetSP("idRouteTemp"));
        }
    }

    public void buttonsRoute(){
        try{
            if(spClass.boolGetSP("inRoute")){
                btnFinishRoute.setVisibility(View.VISIBLE);
                btnStartRoute.setVisibility(View.GONE);
            }else{
                btnFinishRoute.setVisibility(View.GONE);
                btnStartRoute.setVisibility(View.VISIBLE);
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error");
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
                    if (baseApp.isOnline(MainActivity.this)) {

                        switch (process){
                            case "checkDeparture":
                                checkDeparture();
                                break;
                            case "markDepartureLikeAccepted":
                                markDepartureLikeAccepted(nDeparture);
                                break;
                            case "markDepartureLikeFinished":
                                markDepartureLikeFinished();
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
                baseApp.showLog("Ocurrió un error, reporta el siguiente error al Dpto de Sistemas: " + ex);
            }

            dialog.dismiss();
        }, 1000);
    }

    public void onResume() {
        super.onResume();
        getLists(baseApp.getNumberDay());
        //verifyAlarms();
        checkAlertConnection();
        invalidateOptionsMenu();
        buttonsRoute();

        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    public void onPause() {
        super.onPause();

        mSensorManager.unregisterListener(mShakeDetector);
    }
}
