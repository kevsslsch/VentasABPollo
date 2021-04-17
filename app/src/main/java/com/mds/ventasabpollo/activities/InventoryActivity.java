package com.mds.ventasabpollo.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterArticlesInventory;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.models.Inventories;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;

public class InventoryActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Inventories>> {

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsApp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private RealmResults<Inventories> listArticles;
    int idRoute, nUser, nList, totalArticles, nAuthorizer;

    RecyclerView recyclerArticles;
    RelativeLayout layoutList, layoutNotData;
    TextView txtTotalSales;
    Button btnPrepareDeparture;

    FloatingActionButton fbtnBack, fbtnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        getSupportActionBar().hide();

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");
        idRoute = spClass.intGetSP("idRoute");

        txtTotalSales = findViewById(R.id.txtTotalSales);
        recyclerArticles = findViewById(R.id.recyclerArticles);
        layoutList = findViewById(R.id.layoutListArticles);
        layoutNotData = findViewById(R.id.layoutNotData);

        fbtnUpdate = findViewById(R.id.fbtnUpdate);
        fbtnBack = findViewById(R.id.fbtnBack);
        btnPrepareDeparture = findViewById(R.id.btnPrepareDeparture);

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerArticles.setLayoutManager(mGridLayoutManagerDetails);
        recyclerArticles.setItemAnimator(new DefaultItemAnimator());
        recyclerArticles.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        if(idRoute != 0){
            try{
                txtTotalSales.setText("Total Ventas: $" + baseApp.formattedNumber(functionsApp.getTotalSaleRoute(idRoute)));
            }catch (Exception ex){
                baseApp.showToast("Ocurrió un error: " + ex);
            }

            getArticles();
        }else{
            finish();
            baseApp.showToast("No hay una Ruta en proceso.");
        }

        fbtnUpdate.setOnClickListener(v-> functionsApp.goChangeInventoryActivity());
        fbtnBack.setOnClickListener(v -> backFunction());
        btnPrepareDeparture.setOnClickListener(v->functionsApp.goPrepareDepartureActivity());

        baseApp.darkenStatusBar(this, Color.WHITE);
    }

    public void getArticles() {
        final FunctionsApp functionsapp = new FunctionsApp(this);

        try {
            realm = Realm.getDefaultInstance();
            listArticles = realm.where(Inventories.class)
                    .equalTo("ruta", idRoute)
                    .sort("clave_articulo", Sort.ASCENDING)
                    .findAll();
            totalArticles = listArticles.size();
            listArticles.addChangeListener(this);

            if(totalArticles > 0){
                layoutList.setVisibility(View.VISIBLE);
                layoutNotData.setVisibility(View.GONE);

                AdapterArticlesInventory adapterArticlesInventory = new AdapterArticlesInventory(this, listArticles);

                recyclerArticles.setItemAnimator(new DefaultItemAnimator());
                recyclerArticles.setAdapter(adapterArticlesInventory);
            }else{
                baseApp.showToast("No hay artículos para mostrar.");
            }

        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los artículos, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void backFunction(){
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        backFunction();
    }

    @Override
    public void onChange(RealmResults<Inventories> listArticles) {

    }

    @Override
    public void onResume() {
        super.onResume();
        getArticles();
    }

}
