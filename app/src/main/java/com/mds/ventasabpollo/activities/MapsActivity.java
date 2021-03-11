package com.mds.ventasabpollo.activities;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.models.Clients;

import io.realm.Realm;
import io.realm.RealmResults;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Realm realm;
    private int nClient;
    private Clients listClients;
    private RealmResults<Clients> clients;

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsapp = new FunctionsApp(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if (getIntent().getExtras() != null) {
            nClient = getIntent().getExtras().getInt("nClient");
        } else  {
            nClient = 0;
        }

        realm = Realm.getDefaultInstance();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        clients = realm.where(Clients.class).equalTo("cliente", nClient).findAll();
        if (clients.size() > 0) {
            listClients = clients.first();

            String lcNombre = listClients.getNombre_cliente().trim() + " " + listClients.getNombre_comercial().trim();

            double lnX = listClients.getLatitud();
            double lnY = listClients.getLongitud();

            if(lnX == 0.0 || lnY == 0.0){
                baseApp.showToast("El cliente tiene mal configuradas las coordenadas en el Sistema");
                finish();
            }else{

                // Add a marker in Sydney and move the camera
                LatLng oPosicion = new LatLng(lnX, lnY);

                mMap.addMarker(new MarkerOptions().position(oPosicion).title(lcNombre));
                //        mMap.moveCamera(CameraUpdateFactory.newLatLng(oPosicion));
                //        mMap.moveCamera(CameraUpdateFactory.zoomTo(13));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(oPosicion, 15f));


                UiSettings oConfiguracion = mMap.getUiSettings();

                oConfiguracion.setCompassEnabled(true);
                oConfiguracion.setMapToolbarEnabled(true);
                oConfiguracion.setMyLocationButtonEnabled(true);
                oConfiguracion.setZoomControlsEnabled(true);

//        CameraPosition oCamara = new CameraPosition.Builder()
//                .target(new LatLng(lnX, lnY))
//                .zoom(13f)
//                .build();

//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//        //mMap.moveCamera(CameraUpdateFactory.zoomTo(13));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13f));
            }
        }else{
            baseApp.showToast("Ocurrió un error al encontrar la información del Cliente");
            finish();
        }
    }
}
