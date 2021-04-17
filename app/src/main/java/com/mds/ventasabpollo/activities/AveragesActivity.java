package com.mds.ventasabpollo.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterArticlesAverages;
import com.mds.ventasabpollo.adapters.AdapterListClients;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.models.Prices;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;

public class AveragesActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Prices>> {

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsapp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private RealmResults<Prices> listArticles;
    int idRoute, nUser, nList, nClient, totalArticles, nAuthorizer;
    String codigoQRResult = "";

    AdapterListClients adapterListClients;

    RecyclerView recyclerAverages;
    RelativeLayout layoutList, layoutNotData;

    FloatingActionButton fbtnBack, fbtnSave;

    private ProgressDialog dialog;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_averages);
        getSupportActionBar().hide();

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");
        idRoute = spClass.intGetSP("idRoute");

        if (getIntent().getExtras() != null) {
            nClient = getIntent().getExtras().getInt("nClient");
        }else{
            nClient = 0;
        }

        recyclerAverages = findViewById(R.id.recyclerAverages);
        layoutList = findViewById(R.id.layoutAverages);
        layoutNotData = findViewById(R.id.layoutNotData);
        fbtnBack = findViewById(R.id.fbtnBack);

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerAverages.setLayoutManager(mGridLayoutManagerDetails);
        recyclerAverages.setItemAnimator(new DefaultItemAnimator());
        recyclerAverages.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        getArticles();

        fbtnBack.setOnClickListener(v -> backFunction());
        baseApp.darkenStatusBar(this, Color.WHITE);

        dialog = new ProgressDialog(AveragesActivity.this);
    }

    public void getArticles() {
        final FunctionsApp functionsapp = new FunctionsApp(this);

        try {
            realm = Realm.getDefaultInstance();
            listArticles = realm.where(Prices.class)
                    .equalTo("cliente", nClient)
                    .sort("clave_articulo", Sort.ASCENDING)
                    .findAll();
            totalArticles = listArticles.size();
            listArticles.addChangeListener(this);

            if(totalArticles > 0){
                layoutList.setVisibility(View.VISIBLE);
                layoutNotData.setVisibility(View.GONE);

                AdapterArticlesAverages adapterArticlesAverages = new AdapterArticlesAverages(this, listArticles);

                recyclerAverages.setItemAnimator(new DefaultItemAnimator());
                recyclerAverages.setAdapter(adapterArticlesAverages);
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
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onChange(RealmResults<Prices> prices) {

    }
}
