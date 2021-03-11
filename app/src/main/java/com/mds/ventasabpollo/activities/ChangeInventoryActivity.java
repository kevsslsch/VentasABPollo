package com.mds.ventasabpollo.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterArticlesChangeInventory;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.models.ChangesInventories;
import com.mds.ventasabpollo.models.Inventories;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class ChangeInventoryActivity extends AppCompatActivity {

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsApp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private RealmResults<Inventories> listArticles;
    int idRoute, nUser, nList, totalArticles;

    RecyclerView recyclerArticles;
    RelativeLayout layoutList, layoutNotData;

    FloatingActionButton fbtnBack, fbtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_inventory);
        getSupportActionBar().hide();

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");
        idRoute = spClass.intGetSP("idRoute");

        recyclerArticles = findViewById(R.id.recyclerArticles);
        layoutList = findViewById(R.id.layoutListClients);
        layoutNotData = findViewById(R.id.layoutNotData);
        fbtnSave = findViewById(R.id.fbtnSave);
        fbtnBack = findViewById(R.id.fbtnBack);

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerArticles.setLayoutManager(mGridLayoutManagerDetails);
        recyclerArticles.setItemAnimator(new DefaultItemAnimator());
        recyclerArticles.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        if(idRoute != 0){
            getArticles();
        }else{
            finish();
            baseApp.showToast("No hay una Ruta en proceso.");
        }

        fbtnSave.setOnClickListener(v->save());
        fbtnBack.setOnClickListener(v -> backFunction());
        baseApp.darkenStatusBar(this, Color.WHITE);
    }

    public void getArticles() {
        final FunctionsApp functionsapp = new FunctionsApp(this);

        try {
            realm = Realm.getDefaultInstance();
            listArticles = realm.where(Inventories.class).equalTo("ruta", idRoute).findAll();
            totalArticles = listArticles.size();

            if(totalArticles > 0){
                layoutList.setVisibility(View.VISIBLE);
                layoutNotData.setVisibility(View.GONE);

                AdapterArticlesChangeInventory adapterArticlesChangeInventory = new AdapterArticlesChangeInventory(this, listArticles);

                recyclerArticles.setItemAnimator(new DefaultItemAnimator());
                recyclerArticles.setAdapter(adapterArticlesChangeInventory);
            }else{
                baseApp.showToast("No hay artículos para mostrar.");
            }

        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar los artículos, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void save(){

        try{
            int count = 0;

            if (recyclerArticles.getAdapter() != null) {
                count = recyclerArticles.getAdapter().getItemCount();

                for (int i = 0; i < count; i++) {
                    AdapterArticlesChangeInventory.ArticlesViewHolder holder = ((AdapterArticlesChangeInventory) recyclerArticles.getAdapter()).getViewByPosition(i);

                    if (holder != null) {
                        View view = holder.itemView;

                        int value, key;

                        TextView txtKey = view.findViewById(R.id.txtKey);
                        EditText editTxtViewNewAmount = view.findViewById(R.id.editTxtViewNewAmount);

                        if(txtKey.getText().toString().length() > 0){
                            key = Integer.valueOf(txtKey.getText().toString());
                        }else{
                            key = 0;
                        }

                        if(editTxtViewNewAmount.getText().toString().length() > 0){
                            value = Integer.valueOf(editTxtViewNewAmount.getText().toString());
                        }else{
                            value = 0;
                        }

                        if(functionsApp.getAmountArticleRoute(idRoute, key, false, true) != value) {
                            baseApp.showLog("CAMBIO EN INVENTARIO\n" +
                                    "Clave:" + key + "\n" +
                                    "Actual: " + functionsApp.getAmountArticleRoute(idRoute, key, false, true) + "\n" +
                                    "Ahora: " + value);


                            RealmResults<Inventories> inventories = realm.where(Inventories.class).equalTo("ruta", idRoute).equalTo("clave_articulo", key).findAll();

                            realm.beginTransaction();

                            ChangesInventories changesInventories = new ChangesInventories(
                                    idRoute,
                                    key,
                                    functionsApp.getAmountArticleRoute(idRoute, key, false, true),
                                    value,
                                    baseApp.getCurrentDateFormated(),
                                    nUser);

                            realm.insertOrUpdate(changesInventories);

                            if (inventories.size() > 0) {
                                //inventories.get(0).setCantidad(value);
                            } else {
                                baseApp.showToast("No se pudo cambiar la cantidad de un artículo en el Inventario");
                            }

                            realm.commitTransaction();
                        }

                    }
                }

                baseApp.showToast("Inventario modificado con éxito.");
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }

        finish();
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

}
