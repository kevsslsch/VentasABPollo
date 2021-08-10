package com.mds.ventasabpollo.activities;

import android.app.ProgressDialog;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterChangesPrices;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.ConnectionClass;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.models.Articles;
import com.mds.ventasabpollo.models.ChangesPrices;
import com.mds.ventasabpollo.models.ChangesPricesPending;
import com.mds.ventasabpollo.models.Departures;
import com.mds.ventasabpollo.models.DetailsDepartures;
import com.mds.ventasabpollo.models.DetailsSales;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class ChangesPricesActivity extends AppCompatActivity {

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsApp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private ProgressDialog dialog;
    ArrayList<ChangesPricesPending> changesList = new ArrayList<>();

    RecyclerView recyclerChanges;

    int nUser, nChange;
    boolean mSwipable = true;
    String cStatus;

    ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changes_prices);
        setTitle("Cambios de Precios");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Realm.init(this);
        realm = Realm.getDefaultInstance();

        nUser = spClass.intGetSP("user");

        dialog = new ProgressDialog(this);

        backgroundProcess("searchChangesPending", "bar", "Buscando Cambios Pendientes...");
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int direction) {

            if(simpleCallback.isItemViewSwipeEnabled()){
                final int position = viewHolder.getAdapterPosition();

                nChange = changesList.get(position).getCambio();

                switch (direction) {
                    case ItemTouchHelper.LEFT:
                        cStatus = "Autorizado";
                        backgroundProcess("CENewPrice", "bar", "Autorizando la solicitud...");
                        break;

                    case ItemTouchHelper.RIGHT:
                        cStatus = "Cancelado";
                        backgroundProcess("CENewPrice", "bar", "Cancelando la solicitud...");
                        break;
                }
            }
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(ChangesPricesActivity.this, c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(ChangesPricesActivity.this, R.color.colorAccent))
                    .addSwipeLeftActionIcon(R.drawable.ico_check)
                    .addSwipeRightBackgroundColor(ContextCompat.getColor(ChangesPricesActivity.this, R.color.colorPrimary))
                    .addSwipeRightActionIcon(R.drawable.ico_archive_black_24dp)
                    .setActionIconTint(ContextCompat.getColor(recyclerView.getContext(), android.R.color.white))
                    .create()
                    .decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

        @Override
        public boolean isItemViewSwipeEnabled()
        {
            return mSwipable;
        }

    };

    public void searchChangesPending(){

        try {
            boolean isResultSet;
            int countResults = 0, resultCount;

            try {
                ConnectionClass connectionClass = new ConnectionClass(getApplicationContext());

                if (connectionClass.ConnectionMDS() != null) {
                    PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.Consulta_Cambios_Precios_Pendientes");

                    try {
                        isResultSet = loComando.execute();

                        if (changesList != null) {
                            changesList.clear();
                        }

                        while (true) {
                            if (isResultSet) {

                                if (countResults == 0) {

                                    ResultSet Datos = loComando.getResultSet();

                                    while (Datos.next()) {

                                        changesList.add(
                                                new ChangesPricesPending(
                                                        Datos.getInt("cambio"),
                                                        Datos.getString("nombre_cliente"),
                                                        Datos.getString("nombre_articulo"),
                                                        Datos.getDouble("cantidad"),
                                                        Datos.getDouble("precio_original"),
                                                        Datos.getDouble("precio_pactado"),
                                                        Datos.getString("fecha"),
                                                        Datos.getString("observaciones")
                                                )
                                        );
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

                        showChanges();

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

    public void CENewPrice(){

        final BaseApp baseApp = new BaseApp(this);
        final FunctionsApp functionsapp = new FunctionsApp(this);
        final SPClass spClass = new SPClass(this);

        try {
            PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.CE_Cambio_Precio_Android ?, ?, ?");
            if (loComando == null) {
                baseApp.showLog("Error al Crear SP CE_Cambio_Precio_Android");

            } else {
                try {

                    loComando.setInt(1, nChange);
                    loComando.setInt(2, nUser);
                    loComando.setString(3, cStatus);

                    ResultSet Datos = loComando.executeQuery();

                    while (Datos.next()) {

                        if (Datos.getInt("exito") == 1) {
                            baseApp.showToast("Proceso " + cStatus.toLowerCase() + " con éxito");

                        }else{
                            baseApp.showToast("Ocurrió un error en el procedo del cambio de precio, inténtalo de nuevo.");
                        }
                    }
                } catch (Exception ex) {
                    baseApp.showLog("Error en SP CE_Cambio_Precio_Android, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
                }
            }

            backgroundProcess("searchChangesPending", "bar", "Buscando Cambios Pendientes...");

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }



    public void showChanges(){
        AdapterChangesPrices adapterChangesPrices;

        realm = Realm.getDefaultInstance();

        recyclerChanges = findViewById(R.id.recyclerChangesPrices);

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerChanges.setLayoutManager(mGridLayoutManagerDetails);
        recyclerChanges.setItemAnimator(new DefaultItemAnimator());
        recyclerChanges.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerChanges);

        adapterChangesPrices = new AdapterChangesPrices(ChangesPricesActivity.this, changesList);

        recyclerChanges.setAdapter(adapterChangesPrices);
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

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {

            try {

                if(baseApp.verifyServerConnection()) {
                    if (baseApp.isOnline(ChangesPricesActivity.this)) {

                        switch (process){
                            case "searchChangesPending":
                                searchChangesPending();
                                break;
                            case "CENewPrice":
                                CENewPrice();
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

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
