package com.mds.ventasabpollo.activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.Cities;
import com.mds.ventasabpollo.models.Clients;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ChangeUbicationClientActivity extends AppCompatActivity implements
        OnMapReadyCallback, LocationListener {

    BaseApp baseApp = new BaseApp(this);

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private Realm realm;

    private GoogleMap mMap;
    private LocationManager locationManager;
    private static final long MIN_TIME = 400;
    private static final float MIN_DISTANCE = 1000;

    float MIN_ZOOM_PREFERENCE = 19.0f;
    double latitudeUser, longitudeUser;
    boolean currenUbicationLoaded = false;
    int nClient;
    String address, colony, street, no_exterior, postal_code;
    int city, position_spinner;

    private View popupInputDialogView;
    AlertDialog alert;

    Spinner spinnerCities;
    RealmResults<Cities> listCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_ubication_client);
        setTitle("Cambiar ubicación de cliente");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.current_location);
        mapFragment.getMapAsync(this);

        if(baseApp.statusPermissionUbication()){
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }else{
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this); //You can also use LocationManager.GPS_PROVIDER and LocationManager.PASSIVE_PROVIDER
            }
        }

        if (getIntent().getExtras() != null) {
            nClient = getIntent().getExtras().getInt("nClient");
        }else{
            nClient = 0;
        }

        if(nClient == 0){
            finish();
            baseApp.showToast("No se pudo detectar el cliente, inténtalo de nuevo.");
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMyLocationButtonClickListener(onMyLocationButtonClickListener);
        mMap.setOnMyLocationClickListener(onMyLocationClickListener);
        enableMyLocationIfPermitted();

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMinZoomPreference(MIN_ZOOM_PREFERENCE);

        LatLng redmond = new LatLng(latitudeUser, longitudeUser);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(redmond));
    }

    private void enableMyLocationIfPermitted() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else if (mMap != null) {
            mMap.setMyLocationEnabled(true);
        }
    }

    private void showDefaultLocation() {
        Toast.makeText(this, "Location permission not granted, " +
                        "showing default location",
                Toast.LENGTH_SHORT).show();

        LatLng redmond = new LatLng(47.6739881, -122.121512);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(redmond));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    enableMyLocationIfPermitted();
                } else {
                    showDefaultLocation();
                }
                return;
            }

        }
    }

    private GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener =
            new GoogleMap.OnMyLocationButtonClickListener() {
                @Override
                public boolean onMyLocationButtonClick() {
                    mMap.setMinZoomPreference(MIN_ZOOM_PREFERENCE);
                    return false;
                }
            };

    private GoogleMap.OnMyLocationClickListener onMyLocationClickListener =
            new GoogleMap.OnMyLocationClickListener() {
                @Override
                public void onMyLocationClick(@NonNull Location location) {

                    mMap.setMinZoomPreference(MIN_ZOOM_PREFERENCE);

                    CircleOptions circleOptions = new CircleOptions();
                    circleOptions.center(new LatLng(location.getLatitude(),
                            location.getLongitude()));

                    circleOptions.radius(200);
                    circleOptions.fillColor(Color.RED);
                    circleOptions.strokeWidth(6);

                    mMap.addCircle(circleOptions);
                }
            };

    @Override
    public void onLocationChanged(Location location) {

        latitudeUser = location.getLatitude();
        longitudeUser = location.getLongitude();

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, MIN_ZOOM_PREFERENCE);
        mMap.animateCamera(cameraUpdate);
        locationManager.removeUpdates(this);

        currenUbicationLoaded = true;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) { }

    @Override
    public void onProviderEnabled(String provider) {
        baseApp.showToast("Ubicación activada.");
    }
    @Override
    public void onProviderDisabled(String provider) {
        baseApp.showToast("Se desactivó la ubicación, activalo para seguir usando esta función.");
    }

    public void askUpdateUbicationClient(){
        try{
            new AlertDialog.Builder(this)
                    .setMessage("¿Estás seguro que quieres actualizar las coordenadas de este cliente con tu ubicación actual?")
                    .setCancelable(true)
                    .setPositiveButton("Sí", (dialog, id) -> {
                        showDialogAddress();
                    })
                    .setNegativeButton("No", (dialog, id) -> finish())
                    .show();
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    public void showDialogAddress(){
        final BaseApp baseApp = new BaseApp(this);
        final FunctionsApp functionsapp = new FunctionsApp(this);
        final SPClass spClass = new SPClass(this);

        TextView txtDialogClient;
        EditText editTxtDialogStreet, editTxtDialogNoExterior, editTxtDialogColony, editTxtDialogPostalCode;
        Button btnDialogSave, btnDialogCancel;

        try {
            alert = new AlertDialog.Builder(this).create();
            LayoutInflater layoutInflater = LayoutInflater.from(this);
            popupInputDialogView = layoutInflater.inflate(R.layout.dialog_address, null);
            Geocoder geocoder;
            List<Address> addresses;

            Clients client = realm.where(Clients.class)
                    .equalTo("cliente", nClient)
                    .findFirst();

            btnDialogSave = popupInputDialogView.findViewById(R.id.btnDialogSave);
            btnDialogCancel = popupInputDialogView.findViewById(R.id.btnDialogCancel);
            txtDialogClient = popupInputDialogView.findViewById(R.id.txtDialogClient);
            editTxtDialogStreet = popupInputDialogView.findViewById(R.id.editTxtDialogStreet);
            editTxtDialogNoExterior = popupInputDialogView.findViewById(R.id.editTxtDialogNoExterior);
            editTxtDialogColony = popupInputDialogView.findViewById(R.id.editTxtDialogColony);
            editTxtDialogPostalCode = popupInputDialogView.findViewById(R.id.editTxtDialogPostalCode);
            spinnerCities = popupInputDialogView.findViewById(R.id.spinnerCities);

            populateListCities();

            txtDialogClient.setText("Cliente: " + client.getNombre_cliente().trim());

            try{

                RealmResults<Cities> cities = realm.where(Cities.class).equalTo("ciudad", Integer.parseInt(client.getCiudad())).findAll();

                editTxtDialogStreet.setText(client.getCalle().trim());
                editTxtDialogNoExterior.setText(client.getNumero_exterior().trim());
                editTxtDialogColony.setText(client.getColonia().trim());
                editTxtDialogPostalCode.setText(client.getCodigo_postal().trim());

                if(cities.size() > 0){
                    spinnerCities.setSelection(cities.get(0).getPosition()-1);
                }

                /*if(baseApp.checkConnection()){
                    geocoder = new Geocoder(this, Locale.getDefault());
                    addresses = geocoder.getFromLocation(latitudeUser, longitudeUser, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5

                    String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                    String city = addresses.get(0).getLocality();
                    String state = addresses.get(0).getAdminArea();
                    String country = addresses.get(0).getCountryName();
                    String postalCode = addresses.get(0).getPostalCode();
                    String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

                    txtViewDialogAdressValue.setText(address);
                    //editTxtDialogCity.setText(city);
                }else{
                    txtViewDialogAdressValue.setText(queriesRealm.getDataListClients("cliente", nClient, "calle").trim());
                    editTxtDialogColony.setText(queriesRealm.getDataListClients("cliente", nClient, "colonia").trim());
                    //editTxtDialogCity.setText(queriesRealm.getDataListClients("cliente", nClient, "ciudad").trim());
                    baseApp.showToast("No se pudo actualizar la dirección automáticamente, conéctate a Internet.");
                }*/

            }catch (Exception ex){
                baseApp.showToast("No se pudo traer la dirección automáticamente.");
                baseApp.showLog("ERROR: " + ex);
            }

            alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alert.setView(popupInputDialogView);

            alert.show();

            spinnerCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                {
                    position_spinner = position;

                } // to close the onItemSelected
                public void onNothingSelected(AdapterView<?> parent)
                {

                }
            });

            btnDialogSave.setOnClickListener(v -> {
                RealmResults<Cities> cities = realm.where(Cities.class).equalTo("position", position_spinner+1).findAll();

                //address = editTxtDialogAddress.getText().toString();
                street = editTxtDialogStreet.getText().toString();
                no_exterior = editTxtDialogNoExterior.getText().toString();
                colony = editTxtDialogColony.getText().toString();
                postal_code = editTxtDialogPostalCode.getText().toString();

                if(cities.size() > 0){
                    city = cities.get(0).getCiudad();
                }

                baseApp.showLog("City: " + city);
                updateUbicationClient();
            });

            btnDialogCancel.setOnClickListener(view -> {
                alert.cancel();
                //closeKeyboard();
            });
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error, repórtalo al departamento de Sistemas: " + ex);
        }
    }

    public void populateListCities(){
        BaseApp baseApp = new BaseApp(this);

        try {
            realm = Realm.getDefaultInstance();

            List<String> listArray = new ArrayList<>();
            listCities = realm.where(Cities.class).findAll();

            if (listCities.size() == 0) {
                baseApp.showToast("No se encontraron Ciudades para cargar.");
                //finish();
                spinnerCities.setEnabled(false);
            } else {

                for (int i = 0; i < listCities.size(); i++) {
                    listArray.add(listCities.get(i).getNombre_ciudad().trim());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        this, android.R.layout.simple_spinner_item, listArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerCities.setAdapter(adapter);
                spinnerCities.setEnabled(true);

                //RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class).equalTo("id", nVisit).findAll();
                //spinnerClasifications.setSelection(visitsClients.get(0).getPosition_clasificacion_visita());
            }

        }catch (Exception ex){
            baseApp.showAlert("Error", "No se pudieron cargar las Ciudades por este error: " + ex);
        }
    }

    public void updateUbicationClient(){
        try{
            realm = Realm.getDefaultInstance();

            RealmResults<Clients> clients = realm.where(Clients.class).equalTo("cliente", nClient).findAll();
            RealmResults<Cities> cities = realm.where(Cities.class).equalTo("ciudad", city).findAll();

            if(currenUbicationLoaded){
                if(clients.get(0) != null){
                    realm.beginTransaction();
                    clients.get(0).setLatitud_anterior(clients.get(0).getLatitud());
                    clients.get(0).setLongitud_anterior(clients.get(0).getLongitud());

                    clients.get(0).setLatitud(latitudeUser);
                    clients.get(0).setLongitud(longitudeUser);

                    clients.get(0).setLatitud_nueva(latitudeUser);
                    clients.get(0).setLongitud_nueva(longitudeUser);

                    clients.get(0).setCalle_nueva(street);
                    clients.get(0).setNumero_exterior_nuevo(no_exterior);
                    clients.get(0).setColonia(colony);
                    clients.get(0).setCodigo_postal_nuevo(postal_code);
                    clients.get(0).setColonia_nueva(colony);
                    clients.get(0).setCiudad_nueva(city);

                    clients.get(0).setDomicilio(street + "  " + no_exterior + " " + postal_code);
                    clients.get(0).setId_ciudad(city);

                    if(cities.size() > 0){
                        clients.get(0).setCiudad(cities.get(0).getNombre_ciudad());
                    }

                    //clients.get(0).setCiudad(city);

                    realm.commitTransaction();

                    baseApp.showToast("Datos registrados, se guardará en el Servidor al sincronizar los datos.");

                    //baseApp.showToast("Datos registrados, se guardará en el Servidor al sincronizar los datos." +
                            //"Latitud y Longitud nuevas: "  + latitudeUser + " " + longitudeUser);

                    finish();
                }else{
                    baseApp.showToast("Ocurrió un error");
                    finish();
                }
            }else{
                baseApp.showToast("Espera a que termine de posicionar tu ubicación e inténtalo de nuevo.");
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_change_ubication_client, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home) {
            finish();
        }else if(id == R.id.menu_option_send){
           askUpdateUbicationClient();
        }
        return super.onOptionsItemSelected(item);
    }
}