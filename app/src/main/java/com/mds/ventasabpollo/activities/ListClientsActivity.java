package com.mds.ventasabpollo.activities;

import android.app.Notification;
import android.app.NotificationChannel;
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
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterArticlesAverages;
import com.mds.ventasabpollo.adapters.AdapterListClients;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.classes.ShakeDetector;
import com.mds.ventasabpollo.models.Clients;
import com.mds.ventasabpollo.models.ClientsLists;
import com.mds.ventasabpollo.models.Prices;
import com.mds.ventasabpollo.models.VisitsClients;
import com.mds.ventasabpollo.services.ShakeService;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;

public class ListClientsActivity extends AppCompatActivity implements LocationListener {

    private NotificationManagerCompat notificationManager;
    final String NOTIFICATION_CHANNEL_ID = "com.mds.ventasabpollo";
    final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

    private static final long MIN_TIME = 400;
    private static final float MIN_DISTANCE = 1000;
    int REQUEST_PLACE_PICKER = 1;

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsapp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private RealmResults<ClientsLists> listListClients;
    int nUser, nList, nRoute, totaListClients, clientValue;

    AdapterListClients adapterListClients;

    RecyclerView recyclerListClients;
    RelativeLayout layoutList, layoutNotData;
    SearchView searchClients;

    FloatingActionButton fbtnBack, fbtnChangeOrder, fbtnChangeOrderSave, fbtnPrintLastVisit;

    boolean locationDisabled = false, locationOk = false, changingOrdenClients = false;
    double latitudeUser = 0.0, longitudeUser = 0.0, latitudeUser2 = 0.0, longitudeUser2 = 0.0;
    LocationManager locationManager;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    ArrayList<ClientsLists> listClientsChanging = new ArrayList<>();

    private ProgressDialog dialog;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_clients);
        getSupportActionBar().hide();

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");
        nRoute = spClass.intGetSP("idRoute");

        spClass.boolSetSP("changingOrdenClients", false);
        changingOrdenClients = false;

        if (getIntent().getExtras() != null) {
            nList = getIntent().getExtras().getInt("nList");
        } else if (spClass.intGetSP("nList") != 0) {
            nList = spClass.intGetSP("nList");
        } else {
            nList = 0;
        }

        recyclerListClients = findViewById(R.id.recyclerListClients);
        layoutList = findViewById(R.id.layoutListClients);
        layoutNotData = findViewById(R.id.layoutNotData);
        searchClients = findViewById(R.id.searchClients);
        fbtnBack = findViewById(R.id.fbtnBack);
        fbtnChangeOrder = findViewById(R.id.fbtnChangeOrder);
        fbtnChangeOrderSave = findViewById(R.id.fbtnChangeOrderSave);
        fbtnPrintLastVisit = findViewById(R.id.fbtnPrintLastVisit);

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerListClients.setLayoutManager(mGridLayoutManagerDetails);
        recyclerListClients.setItemAnimator(new DefaultItemAnimator());
        recyclerListClients.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        getListClients("");

        searchClients.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchClients.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                try {
                    getListClients(newText);
                }catch (Exception ex){
                    baseApp.showToast("Ocurrió un error");
                    baseApp.showLog("Ocurrió el error" + ex);
                }
                return false;
            }
        });

        fbtnBack.setOnClickListener(v -> backFunction());
        fbtnPrintLastVisit.setOnClickListener(v->{
            int nLastVisit;

            nLastVisit = realm.where(VisitsClients.class).sort("id", Sort.DESCENDING).findFirst().getId();

            if(nLastVisit != 0){
                functionsapp.printTicket(nLastVisit);
            }
        });

        fbtnChangeOrder.setOnClickListener(v-> changeOrderClients());
        fbtnChangeOrderSave.setOnClickListener(v-> backgroundProcess("saveChangesOrden", "bar", "Actualizando orden..."));
        baseApp.darkenStatusBar(this, Color.WHITE);

        getLocation();
        checkUbication();
        threadUbication();

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
                vib.vibrate(250);
            }

            functionsapp.goInventoryActivity();
        });

        dialog = new ProgressDialog(this);
    }

    public void threadUbication(){
        try{
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkUbication();
                    handler.postDelayed(this, 1000);
                }
            }, 1000);  //the time is in miliseconds
        }catch (Exception ex){
            baseApp.showLog("ERROR: " + ex);
        }
    }

    public void getListClients(String text) {
        final FunctionsApp functionsapp = new FunctionsApp(this);
        ArrayList<ClientsLists> listClients = new ArrayList<>();
        ArrayList<ClientsLists> listClientsShow = new ArrayList<>();

        try {
            realm = Realm.getDefaultInstance();

            RealmResults<ClientsLists> listsClientsRealm = realm.where(ClientsLists.class)
                    .equalTo("lista", nList)
                    .sort("orden", Sort.ASCENDING)
                    .findAll();

            if(text.isEmpty()){
                listClients.addAll(listsClientsRealm);
            }else{

                for(ClientsLists client: listsClientsRealm){
                    if(realm.where(Clients.class)
                            .equalTo("cliente", client.getCliente())
                            .contains("nombre_cliente", text, Case.INSENSITIVE).findAll().size() > 0){
                        listClients.add(client);
                    }
                }
            }

            if (listClients.size() > 0 && nList != 0) {

                for (ClientsLists client: listClients) {

                    if(!functionsapp.clientVisitedinRoute(client.getCliente(), nRoute)){
                        listClientsShow.add(client);
                    }
                }

                for (ClientsLists client: listClients) {

                    if(functionsapp.clientVisitedinRoute(client.getCliente(), nRoute)){
                        listClientsShow.add(client);
                    }
                }

                layoutList.setVisibility(View.VISIBLE);
                layoutNotData.setVisibility(View.GONE);

                adapterListClients = new AdapterListClients(this, listClientsShow);

                recyclerListClients.setItemAnimator(new DefaultItemAnimator());
                recyclerListClients.setAdapter(adapterListClients);
            } else {
                layoutList.setVisibility(View.GONE);
                layoutNotData.setVisibility(View.VISIBLE);
            }
        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar las listas, reporta el siguiente error al departamento de Sistemas" + ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void changeOrderClients(){
        final FunctionsApp functionsapp = new FunctionsApp(this);

        try {
            realm = Realm.getDefaultInstance();

            //baseApp.showToast("Mantén presionado al cliente y arrástralo a la posición deseada, al terminar, presiona el botón de guardar.");

            if(listClientsChanging != null){
                listClientsChanging.clear();
            }

            RealmResults<ClientsLists> listClientsRealm = realm.where(ClientsLists.class)
                                .equalTo("lista", nList)
                                .sort("orden", Sort.ASCENDING).findAll();

            listClientsChanging.addAll(listClientsRealm);

            int totaListClients = listClientsChanging.size();

            if (totaListClients > 0 || nList == 0) {
                layoutList.setVisibility(View.VISIBLE);
                layoutNotData.setVisibility(View.GONE);

                adapterListClients = new AdapterListClients(this, listClientsChanging);

                recyclerListClients.setItemAnimator(new DefaultItemAnimator());

                /*ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) {

                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder dragged, @NonNull RecyclerView.ViewHolder target) {

                        int position_dragged = dragged.getAdapterPosition();
                        int position_target = target.getAdapterPosition();

                        Collections.swap(listClientsChanging, position_dragged, position_target);
                        adapterListClients.notifyItemMoved(position_dragged, position_target);
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                    }
                });
                helper.attachToRecyclerView(recyclerListClients);*/

                recyclerListClients.setAdapter(adapterListClients);

                fbtnChangeOrder.setVisibility(View.GONE);
                fbtnChangeOrderSave.setVisibility(View.VISIBLE);

                changingOrdenClients = true;
                spClass.boolSetSP("changingOrdenClients", true);
            } else {
                layoutList.setVisibility(View.GONE);
                layoutNotData.setVisibility(View.VISIBLE);
            }
        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar las listas, reporta el siguiente error al departamento de Sistemas" + ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void saveChangesOrden() {
        SPClass spClass = new SPClass(this);

        String stringSplit = "";
        int position = 1;

        for (int i = 0; i < listClientsChanging.size(); i++) {
            stringSplit += listClientsChanging.get(i).getCliente() + "|";
            stringSplit += functionsapp.getClient(listClientsChanging.get(i).getCliente()).getId_domicilio() + "|";
            stringSplit += position + "Ç"; // 1 familia

            position++;
        }

        PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.Cambia_Orden_Clientes_Android ?, ?, ?");
        if (loComando == null) {
            baseApp.showToast("Error al Crear SP Cambia_Orden_Clientes_Android");
        } else {
            try {
                loComando.setInt(1, nUser);
                loComando.setInt(2, nList);
                loComando.setString(3, stringSplit);

                ResultSet Datos = loComando.executeQuery();
                while (Datos.next()) {
                    if(Datos.getInt("exito") == 1){
                        baseApp.showAlert("Éxito", "Orden actualizado con éxito.");

                        updateLocalOrden();
                        resetOptionChangeClients();
                    }else{
                        baseApp.showToast("Ocurrió un error al guardar el orden de los clientes.");
                    }
                }

            } catch (Exception ex) {
                baseApp.showToast("#3 Error en SP Cambia_Orden_Clientes_Android, reporta el siguiente error al departamento de Sistemas: " + ex);
            }
        }
    }

    public void updateLocalOrden(){
        try {
            realm = Realm.getDefaultInstance();

            int position = 1;

            for (int i = 0; i < listClientsChanging.size(); i++) {

                ClientsLists client = realm.where(ClientsLists.class)
                        .equalTo("cliente", listClientsChanging.get(i).getCliente())
                        .equalTo("lista", nList)
                        .findFirst();

                realm.beginTransaction();
                client.setOrden(position);
                realm.insertOrUpdate(client);
                realm.commitTransaction();

                position++;
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    public void resetOptionChangeClients(){
        try{
            fbtnChangeOrder.setVisibility(View.VISIBLE);
            fbtnChangeOrderSave.setVisibility(View.GONE);

            getListClients("");

            changingOrdenClients = false;
            spClass.boolSetSP("changingOrdenClients", false);

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }
    public void showMenuBottomAskVisitClient(int client, String name_client) {

        BottomSheetDialog menuBottomSheet;
        TextView btnYes, btnNo, txtViewTitle;

        menuBottomSheet = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);
        menuBottomSheet.setContentView(R.layout.bottom_sheet_confirm);
        menuBottomSheet.setCancelable(true);
        menuBottomSheet.show();

        txtViewTitle = menuBottomSheet.findViewById(R.id.txtViewInfo);
        btnYes = menuBottomSheet.findViewById(R.id.btnYes);
        btnNo = menuBottomSheet.findViewById(R.id.btnNo);

        txtViewTitle.setText("¿Deseas comenzar la visita con el cliente " + name_client + "?");
        btnYes.setOnClickListener(v-> {
            clientValue = client;
            startVisit(clientValue);

            menuBottomSheet.dismiss();
        });
        btnNo.setOnClickListener(v-> menuBottomSheet.dismiss());
    }


    public void startVisit(int nClient) {

        RealmResults<Clients> clients;
        VisitsClients visitsClients;
        double latitudeClient, longitudeClient;

        clientValue = nClient;

        try {

            getLocation();

            if (nClient != 0) {

                try{
                    clients = realm.where(Clients.class).equalTo("cliente", nClient).findAll();
                    latitudeClient = clients.get(0).getLatitud();
                    longitudeClient = clients.get(0).getLongitud();
                }catch (Exception ex){
                    latitudeClient = 0.0;
                    longitudeClient = 0.0;
                    baseApp.showToast("Ocurrió un error");
                }

                if (spClass.boolGetSP("inVisit")) {
                    baseApp.showToast("Ya te encuentras en una Visita, para iniciar otra, por favor, termina la actual.");
                    finish();
                    functionsapp.goMainActivity();
                } else {
                    if (realm.where(VisitsClients.class).equalTo("fecha_visita_fin", "").findAll().size() == 0) {
                        if (baseApp.statusPermissionUbication()) {
                            if (!locationDisabled) {
                                if (1==1 /*locationOk*/) {
                                    if (1==1/*baseApp.distanceBetweenCoordinates(latitudeUser2, longitudeUser2, latitudeClient, longitudeClient) < Integer.parseInt(baseApp.getStringText(R.string.margin_map))*/) {
                                        int idVisit = functionsapp.getNextIdVist();

                                        spClass.intSetSP("nClient", clientValue);
                                        spClass.intSetSP("nList", nList);
                                        spClass.boolSetSP("inVisit", true);
                                        spClass.intSetSP("nVisit", idVisit);
                                        spClass.strSetSP("sTypeSale", "counted");

                                        realm.beginTransaction();
                                        visitsClients = new VisitsClients(
                                                idVisit,
                                                nRoute,
                                                nClient,
                                                nList,
                                                1,
                                                0,
                                                baseApp.getCurrentDateFormated(),
                                                latitudeUser2,
                                                longitudeUser2,
                                                0,
                                                0,
                                                false,
                                                true,
                                                nUser);

                                        realm.copyToRealm(visitsClients);
                                        realm.commitTransaction();

                                        functionsapp.initiateMovementsArticlesVisit(nRoute, idVisit);

                                        //finish();
                                        functionsapp.goSalesActivity();
                                        //showNotification("Ventas Nudito", "Estás actualmente en una visita.");

                                        baseApp.showLog("COORDENADAS: " +
                                                "Lat User : " + latitudeUser2 + ", Long User : " + longitudeUser2 + ", Lat Cliente : " + latitudeClient + ", Long Client : " + longitudeClient);
                                    } else {
                                        baseApp.showAlertDialog("error", "No estás cerca", "Debes estar mínimo a " + baseApp.getStringText(R.string.margin_map) + " metros de la ubicación del cliente para poder registrar la visita.", true);
                                        baseApp.showLog("COORDENADAS: " +
                                                "Lat User : " + latitudeUser2 + ", Long User : " + longitudeUser2 + ", Lat Cliente : " + latitudeClient + ", Long Client : " + longitudeClient);
                                    }
                                } else {
                                    baseApp.showToast("Tu ubicación está siendo refrescada, inténtalo de nuevo en unos momentos.");
                                }
                            }else{
                                baseApp.showAlertDialog("warning", "Ubicación desactivada", "Por favor, activa el GPS y el Internet y vuelve a intentarlo.", true);
                            }
                        }else{
                            baseApp.showToast("No está activado el permiso de Ubicación");
                        }

                    } else {
                        baseApp.showToast("Ya te encuentras en una Visita, para iniciar otra, por favor, termina la actual.");
                        functionsapp.goMainActivity();
                    }
                }

            } else {
                baseApp.showToast("Ocurrió un error al intentar iniciar la Visita");
            }
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al iniciar una Visita, reporta el siguiente error al Dpto de Sistemas: " + ex);
        }
    }

    public void deleteBackgroundParts(){

        int count;

        try {
            if (recyclerListClients.getAdapter() != null) {
                count = recyclerListClients.getAdapter().getItemCount();

                for (int i = 0; i < count; i++) {
                    AdapterListClients.ListsViewHolder holder = ((AdapterListClients) recyclerListClients.getAdapter()).getViewByPosition(i);

                    if (holder != null) {
                        View view = holder.itemView;
                        Button btn = view.findViewById(R.id.btnVisit);
                        btn.setBackgroundResource(R.drawable.custom_btn_info);
                    }
                }
            }
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió el error: " + ex);
        }
    }

    private void showNotification(final String title, final String body) {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Notification",
                        NotificationManager.IMPORTANCE_HIGH);

                //TODO No fijo
                notificationChannel.setDescription("Ventas Nudito");
                //nnotificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.BLUE);
                //notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
                //nnotificationChannel.enableLights(true);
                notificationManager.createNotificationChannel(notificationChannel);

            }

            notificationBuilder.setAutoCancel(false)
                    //TODO: Change icon
                    .setSmallIcon(R.drawable.ico_visit)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setOnlyAlertOnce(false)
                    //.setProgress(100, 0, true)
                    .setProgress(0, 0, false)
                    .setOngoing(true)
                    .setCategory(Notification.CATEGORY_CALL)
                    .setChannelId(NOTIFICATION_CHANNEL_ID);

            notificationManager.notify(1, notificationBuilder.build());
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

    public void checkUbication(){
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(this);

        if(latitudeUser2 == 0.0 || longitudeUser2 == 0.0){
            locationOk = false;
        }else{
            locationOk = true;
        }

        getLocation();

        /*if(!locationOk) {

            if(!progressDialog.isShowing()){
                progressDialog.setMessage("Obteniendo tu ubicación... Espera unos momentos");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setCancelable(false);
                progressDialog.show();
            }

            getLocation();
        }else{
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }*/

        //baseApp.showLog("locationOk: " + locationOk + "lat user: " + latitudeUser2 + ", long user: " + longitudeUser2);
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
                    if (baseApp.isOnline(ListClientsActivity.this)) {

                        switch (process){
                            case "saveChangesOrden":
                                saveChangesOrden();
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

    @Override
    public void onLocationChanged(Location location) {
        latitudeUser = location.getLatitude();
        longitudeUser = location.getLongitude();

        if(latitudeUser != 0.0){
            latitudeUser2 = latitudeUser;
        }

        if(longitudeUser != 0.0){
            longitudeUser2 = longitudeUser;
        }
    }

    @Override
    public void onProviderDisabled(String provider) {
        //Toast.makeText(ListClientsActivity.this, "Por favor, activa el GPS y el Internet", Toast.LENGTH_SHORT).show();
        baseApp.showToast("GPS desactivado. Por favor, actívalo");
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

    public void backFunction(){
        if(changingOrdenClients){
            new AlertDialog.Builder(this)
                    .setMessage("¿Estás seguro que quieres cancelar el orden de los clientes? Se perderán todos los datos no enviados.")
                    .setCancelable(true)
                    .setPositiveButton("Sí", (dialog, id) -> {
                        resetOptionChangeClients();
                    })
                    .setNegativeButton("No", null)
                    .show();
        }else if(baseApp.returnInSession()){
            functionsapp.inVisitVerify();
        }else {
            functionsapp.goMainActivity();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            functionsapp.goMainActivity();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        backFunction();
    }

    @Override
    public void onResume() {
        super.onResume();
        getLocation();
        getListClients("");

        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    public void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);

        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
    }
}
