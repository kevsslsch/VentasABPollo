package com.mds.ventasabpollo.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterRoutes;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.models.Routes;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;

public class RoutesActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Routes>> {

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsapp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private RealmResults<Routes> listsRoutes;
    RecyclerView recyclerRoutes;
    RelativeLayout layoutRoutes, layoutNotData;
    FloatingActionButton fbtnBack;

    int nUser, nList, nClient, totalRoutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);
        getSupportActionBar().hide();

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");
        nList = spClass.intGetSP("nList");
        nClient = spClass.intGetSP("nClient");

        recyclerRoutes = findViewById(R.id.recyclerRoutes);
        layoutRoutes = findViewById(R.id.layoutRoutes);
        layoutNotData = findViewById(R.id.layoutNotData);
        fbtnBack = findViewById(R.id.fbtnBack);

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerRoutes.setLayoutManager(mGridLayoutManagerDetails);
        recyclerRoutes.setLayoutManager(mGridLayoutManagerDetails);
        recyclerRoutes.setItemAnimator(new DefaultItemAnimator());
        recyclerRoutes.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        getRoutes();

        fbtnBack.setOnClickListener(v -> backFunction());

        baseApp.darkenStatusBar(this, Color.WHITE);
    }

    public void getRoutes(){
        final FunctionsApp functionsapp = new FunctionsApp(this);

        try {
                realm = Realm.getDefaultInstance();
                listsRoutes = realm.where(Routes.class)
                        //.equalTo("user_id", nUser)
                        .sort("ruta", Sort.DESCENDING)
                        .findAll();
                totalRoutes = listsRoutes.size();
                listsRoutes.addChangeListener(this);

                if (totalRoutes > 0) {
                    layoutRoutes.setVisibility(View.VISIBLE);
                    layoutNotData.setVisibility(View.GONE);

                    AdapterRoutes adapterRoutes = new AdapterRoutes(this, listsRoutes);

                    recyclerRoutes.setItemAnimator(new DefaultItemAnimator());
                    recyclerRoutes.setAdapter(adapterRoutes);
                } else {
                    layoutRoutes.setVisibility(View.GONE);
                    layoutNotData.setVisibility(View.VISIBLE);
                }

        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los artículos, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onBackPressed() {
        backFunction();
    }

    public void backFunction(){
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onChange(RealmResults<Routes> routes) {

    }
}
