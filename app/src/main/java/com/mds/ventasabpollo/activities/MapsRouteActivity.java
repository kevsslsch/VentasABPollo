package com.mds.ventasabpollo.activities;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.models.MapRoutes;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class MapsRouteActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Realm realm;
    private int nList;

    private MapRoutes listMapRoutes;
    private RealmResults<MapRoutes> mapRoutes;

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsapp = new FunctionsApp(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_route);

        if (getIntent().getExtras() != null) {
            nList = getIntent().getExtras().getInt("nList");
        } else  {
            nList = 0;
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
        PolylineOptions rectOptions = new PolylineOptions();

        try {
            mapRoutes = realm.where(MapRoutes.class).equalTo("lista", nList).sort("orden", Sort.ASCENDING).findAll();
            //functionsapp.showToast(""+nList);
            int totalListClients = mapRoutes.size();

            for (int i = 0; i < totalListClients; i++) {

                if (mapRoutes.size() > 0) {
                    listMapRoutes = mapRoutes.get(i);

                    String lcNombre = (i + 1) + " " + listMapRoutes.getNombre_cliente().trim() + ", " + listMapRoutes.getNombre_comercial().trim();

                    double lnX = listMapRoutes.getLatitud();
                    double lnY = listMapRoutes.getLongitud();

                    if (lnX == 0.0 || lnY == 0.0) {
                        baseApp.showToast("El cliente " + listMapRoutes.getNombre_cliente().trim() + " tiene mal configuradas las coordenadas en el Sistema");
                        finish();
                    } else {

                        // Add a marker in Sydney and move the camera
                        LatLng oPosicion = new LatLng(lnX, lnY);

                        if (i == 0) {
                            mMap.addMarker(new MarkerOptions().position(oPosicion).title(lcNombre)).showInfoWindow();
                        } else {
                            mMap.addMarker(new MarkerOptions().position(oPosicion).title(lcNombre));
                        }
                        //        mMap.moveCamera(CameraUpdateFactory.newLatLng(oPosicion));
                        //        mMap.moveCamera(CameraUpdateFactory.zoomTo(13));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(oPosicion, 15f));


                        UiSettings oConfiguracion = mMap.getUiSettings();

                        oConfiguracion.setCompassEnabled(true);
                        oConfiguracion.setMapToolbarEnabled(true);
                        oConfiguracion.setMyLocationButtonEnabled(true);
                        oConfiguracion.setZoomControlsEnabled(true);

                        rectOptions.add(new LatLng(lnX, lnY));

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
                } else {
                    baseApp.showToast("Ocurrió un error al encontrar la información de la Ruta de " + i);
                    //finish();
                }
            }

            LatLng firstClient = new LatLng(mapRoutes.get(0).getLatitud(), mapRoutes.get(0).getLongitud());
            mMap.moveCamera(CameraUpdateFactory.newLatLng(firstClient));
            mMap.moveCamera(CameraUpdateFactory.zoomTo(17));

            Polyline polyline = mMap.addPolyline(rectOptions);
            polyline.setColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }catch (Exception ex){
            baseApp.showToast2("No se pudo cargar el mapa con la ruta, vuelve a descargar los datos.");
            finish();
        }
    }
}
