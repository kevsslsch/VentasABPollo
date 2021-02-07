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

                /*if(updateGlobalList){
                    realm.delete(ListClients.class);
                    realm.delete(Lists.class);
                }else{
                    RealmResults<ListClients> listClients = realm.where(ListClients.class).notEqualTo("lista", 1).findAll();
                    listClients.deleteAllFromRealm();

                    RealmResults<Lists> lists = realm.where(Lists.class).notEqualTo("lista", 1).findAll();
                    lists.deleteAllFromRealm();
                }

                RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class)
                        .equalTo("ruta", 0)
                        .findAll();
                visitsPayments.deleteAllFromRealm();

                realm.delete(Articles.class);
                realm.delete(MapRoutes.class);
                realm.delete(VisitsClasifications.class);
                realm.delete(WayPay.class);
                realm.delete(UseCFDI.class);
                realm.delete(MethodPay.class);
                realm.delete(Cities.class);
                realm.delete(Alarms.class);

                baseApp.showLog("Datos borrados");
                realm.commitTransaction();

                publishProgress("Descargando datos... (56 / 100)");
                loadData();

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
                if (!messagesSync.trim().equals("")) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Resultado de la sincronización")
                            .setMessage(messagesSync)
                            .setCancelable(true)
                            .setPositiveButton("Ok", (dialog, id) -> dialog.cancel())
                            .show();
                }
            }*/

            //getLists(baseApp.getNumberDay());
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

        if(id == R.id.nav_authorize){
            //functionsapp.goSellersDeparturesActivity();
        }else if (id == R.id.nav_sync) {
            //showMenuBottomSyncData();
        } else if (id == R.id.nav_account) {
            functionsapp.goAccountActivity();
        } else if (id == R.id.nav_routes) {
            //functionsapp.goRoutesActivity();
        }else if(id == R.id.nav_change_connection){
            functionsapp.goChangeConnection();
        }else if(id == R.id.nav_alarms){
            //functionsapp.goAlarmsActivity();
        }else if(id == R.id.nav_about){
            functionsapp.goAboutActivity();
        }else if(id == R.id.nav_new_client) {
            //newClient();
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
