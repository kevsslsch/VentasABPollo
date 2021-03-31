package com.mds.ventasabpollo.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterTabsAddClient;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.NewClients;

import io.realm.Realm;
import io.realm.RealmResults;

public class AddClientActivity extends AppCompatActivity {

    Realm realm;

    SPClass spClass = new SPClass(this);
    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsApp = new FunctionsApp(this);

    int idNewClient;
    boolean finishActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        Toolbar toolbar = findViewById(R.id.toolbar_profile);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ico_close_white);
        getSupportActionBar().setTitle("Registrar nuevo cliente");

        TabLayout tabLayout = findViewById(R.id.tabs);

        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_text_1)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_text_2)));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = findViewById(R.id.container);

        AdapterTabsAddClient tabsAdapter = new AdapterTabsAddClient(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        baseApp.darkenStatusBar(this, ContextCompat.getColor(this, R.color.colorPrimary));
    }

    public void addClient(){
        try{
            realm = Realm.getDefaultInstance();
            idNewClient = spClass.intGetSP("idNewClient");

            RealmResults<NewClients> newClients = realm.where(NewClients.class).equalTo("id", idNewClient).findAll();
            if(newClients.get(0) != null){

                if(newClients.get(0).getNombre_cliente().equals("")){
                    baseApp.showToast("Falta el nombre del cliente");
                }/*else if(newClients.get(0).getNombre_contacto().equals("")) {
                    baseApp.showToast("Falta el nombre del contacto");
                }else if(newClients.get(0).getApellido_contacto().equals("")){
                    baseApp.showToast("Falta el apellido del contacto");
                }*/else if(newClients.get(0).getNombre_calle().equals("")){
                    baseApp.showToast("Registre la calle del domicilio del cliente");
                }else if(newClients.get(0).getNo_exterior().equals("")){
                    baseApp.showToast("Falta el número exterior del domicilio del cliente");
                }else{
                    realm.beginTransaction();
                    newClients.get(0).setBorrador(false);
                    realm.commitTransaction();

                    spClass.deleteSP("idNewClient");
                    baseApp.showToast("Cliente guardado con éxito.");
                    finishActivity = true;
                    finish();
                }
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_client, menu);
        return true;
    }

    public void onPause(){
        super.onPause();

        if(!finishActivity){
            baseApp.showToast("Registro de cliente guardado en borrador.");
        }
    }

    public void onBackPressed(){
        try{
            new AlertDialog.Builder(this)
                    .setMessage("¿Deseas dejar el cliente en borrador o cancelar el registro?")
                    .setCancelable(true)
                    .setPositiveButton("Dejar en borrador", (dialog, id2) -> finish())
                    .setNegativeButton("Cancelar registro", (dialog, id2) -> {
                        finishActivity = true;
                        functionsApp.cancelAddClient();
                    })
                    .show();
        }catch(Exception ex){
            baseApp.showToast("Oocurrió un error.");
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home) {
            onBackPressed();
        }else if(id == R.id.menu_option_send){
            addClient();
        }
        return super.onOptionsItemSelected(item);
    }
}