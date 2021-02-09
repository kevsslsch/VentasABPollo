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
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.ConnectionClass;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.classes.ShakeDetector;
import com.mds.ventasabpollo.models.Articles;
import com.mds.ventasabpollo.models.Clients;
import com.mds.ventasabpollo.models.ClientsLists;
import com.mds.ventasabpollo.models.Lists;
import com.mds.ventasabpollo.models.MapRoutes;
import com.mds.ventasabpollo.models.VisitsClasifications;
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
    /*private RealmResults<Lists> listLists;
    private RealmResults<Lists> listLists2;

    ArrayList<Departures> departuresList = new ArrayList<>();
*/

    int nUser, idRoute, totaLists;
    String messagesSync = "";

    private ProgressDialog dialog;
    RecyclerView recyclerLists;
    RelativeLayout layoutList, layoutStartRoute, layoutNotData;
    TextView btnGoConfigurationServer;
    ImageView btnStartDay;
    Spinner spinnerDays;

    Handler handler;

    String stringSplitVisits, stringSplitSales, stringSplitChanges, stringSplitDevolutions, stringSplitPayments, stringSplitSeparateds, stringSplitClients, stringSplitDomiciles, stringSplitReturns, stringSplitChangesInventories, stringSplitPendingPayments, stringSplitLogs;
    int nDeparture;
    boolean updateGlobalList, goToFinalReport = false;

    ProgressDialog barSyncData;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

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
        btnStartDay = findViewById(R.id.btnStartDay);
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

        btnStartDay.setOnClickListener(v-> {
            //showMenuBottomStartRoute();

            //backgroundProcess("checkDeparture", "bar", "Consultando salidas...");

            Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vib.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                //deprecated in API 26
                vib.vibrate(50);
            }
        });

        checkAlertConnection();

        //functionsapp.inVisitVerify();
        /*getLists(baseApp.getNumberDay());
        hideItemAuthorize();
        populateSpinnerDays();
        verifyAlarms();*/

        final RippleBackground rippleBackground = findViewById(R.id.content);
        rippleBackground.startRippleAnimation();

        spinnerDays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                //getLists(position+1);

            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
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

            //functionsapp.goInventoryActivity();
        });

        /* Fingir estar en una Ruta para cuando hay errores */
        /*
        spClass.boolSetSP("inRoute", true);
        spClass.boolSetSP("inventoryLoaded", true);
        spClass.intSetSP("idRoute", 42);
        /**/

        //baseApp.showLog(functionsapp.generateSplitChangesInventory());
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
                //uploadData();

                publishProgress("Subiendo clientes... (28 / 100)");
                //uploadNewClients();

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

                /*

                publishProgress("Descargando datos de Combos... (70 / 100)");
                loadSpinnersData();

                publishProgress("Creando Rutas de Mapas... (84 / 100)");
                loadMapRoutes();

                publishProgress("Descargando Personal... (95 / 100)");
                loadPersonal();

                publishProgress("Finalizando... (100 / 100)");*/
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
        }

        //getLists(baseApp.getNumberDay());
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
        //Prices prices;
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

                            /*if (countResults == 4) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando precios de artículos...");

                                while (Datos.next()) {

                                    realm.beginTransaction();
                                    deletePrice(Datos.getInt("cliente"), Datos.getInt("clave_articulo"));

                                    //TODO: Campos correctos
                                    prices = new Prices(
                                            Datos.getInt("cliente"),
                                            Datos.getInt("clave_articulo"),
                                            Datos.getDouble("precio"), //Datos.getDouble("precio_contado"),
                                            0, //Datos.getDouble("precio_credito"),
                                            0, //Datos.getInt("tiene_iva"),
                                            0, //Datos.getDouble("tasa_iva"),
                                            0, //Datos.getDouble("tasa_IEPS"),
                                            "", //Datos.getString("tipo_IEPS"),
                                            "", //Datos.getString("fecha_actualizacion"),
                                            Datos.getInt("promedio_piezas"),
                                            nUser);

                                    baseApp.showLog("Precios cargados del cliente " + Datos.getInt("cliente") + ", del artículo " + Datos.getInt("clave_articulo"));

                                    realm.copyToRealm(prices);
                                    realm.commitTransaction();
                                }

                                Datos.close();
                            }

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

                    /*
                    if (realm.where(Prices.class).findAll().size() == 0) {
                        baseApp.showLog("No se encontraron Precios de Artículos para cargar");
                        messagesSync += "\n\n No se encontraron Precios de Artículos para cargar";

                    } else {
                        baseApp.showLog("Precios de Artículos cargados");
                        messagesSync += "\n\n Precios de Artículos cargados";
                    }

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


    public void checkAlertConnection(){
        if(spClass.strGetSP("IPConnection").equals("ND")){
            //showMenuBottomNoServer();
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
            //functionsapp.goRoutesActivity();
        }else if(id == R.id.nav_change_connection){
            functionsapp.goChangeConnection();
        }/*else if(id == R.id.nav_alarms){
            //functionsapp.goAlarmsActivity();
        }*/else if(id == R.id.nav_about){
            functionsapp.goAboutActivity();
        }else if(id == R.id.nav_new_client) {
            //newClient();
        }/*else if(id == R.id.nav_configuration){
            functionsapp.goConfigurationActivity();
        }*/

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(spClass.boolGetSP("inRoute") && spClass.boolGetSP("inventoryLoaded")){
            getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onResume() {
        super.onResume();
        //getLists(baseApp.getNumberDay());
        //verifyAlarms();
        checkAlertConnection();
        invalidateOptionsMenu();

        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    public void onPause() {
        super.onPause();

        mSensorManager.unregisterListener(mShakeDetector);
    }
}
