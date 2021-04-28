package com.mds.ventasabpollo.activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.adapters.AdapterDetailsSales;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.classes.MyDividerItemDecoration;
import com.mds.ventasabpollo.models.Clients;
import com.mds.ventasabpollo.models.DetailsSales;
import com.mds.ventasabpollo.models.VisitsClasifications;
import com.mds.ventasabpollo.models.VisitsClients;
import com.mds.ventasabpollo.models.VisitsMovements;
import com.mds.ventasabpollo.models.VisitsPayments;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class DetailsSalesActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<DetailsSales>>,
        LocationListener {

    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsapp = new FunctionsApp(this);
    SPClass spClass = new SPClass(this);

    private Realm realm;
    private RealmResults<DetailsSales> listDetails;

    RecyclerView recyclerDetailsSale;
    RelativeLayout layoutNotData, layoutMoney;
    LinearLayout layoutTotales, layoutDetails, layoutTypeSale;
    FloatingActionButton fbtnBack, fbtnDeleteAll, fbtnHelp, fbtnNext, fbtnFinishSale;
    TextView txtChange, txtSubTotalValueD, txtIVAValueD, txtIEPSValueD, txtTotalValueD, txtTitleLimitCredit, txtTitleDebt, txtTitleRemainingCredit;
    EditText editTxtImport;
    ScrollView scrollViewDetailsSale;
    TableLayout tableHeaders;
    BottomSheetDialog menuBottomSheet;
    Switch switchTypeSale;
    CheckBox chkBoxFiscalInvoice;
    LinearLayout layoutSwitchTypeSale;

    CardView cardExact, card20, card50, card100, card200, card500, cardReset, cardSPEI, cardCreditCard;

    int nUser, nClient, nVisit, nList, idRoute, nPedido, totalDetails;
    boolean bAlertDetailsSale;
    String valueImport;
    double totalImport = 0.0, change = 0.0;

    private static final long TIEMPO_MINIMO = 4000; // Minimo de espera para click
    private long ultimoClick= 0; // Fecha del Ultimo click capturado

    Spinner spinnerClasifications;
    int position = 0;
    boolean locationDisabled = false;

    double latitudeUser = 0.0, longitudeUser = 0.0;
    LocationManager locationManager;
    private static final long MIN_TIME = 400;
    private static final float MIN_DISTANCE = 1000;
    RealmResults<VisitsClasifications> listClasifications;

    boolean isSPEI = false, isCreditCard = false;
    String cCreditCard = "", cLast4 = "";

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_sales);
        getSupportActionBar().hide();

        realm = Realm.getDefaultInstance();
        nUser = spClass.intGetSP("user");

        if (getIntent().getExtras() != null) {
            nPedido = getIntent().getExtras().getInt("nPedido");
        }else{
            nPedido = 1;
        }

        if (getIntent().getExtras() != null) {
            nVisit = getIntent().getExtras().getInt("nVisit");
            if(nVisit == 0){
                nVisit = spClass.intGetSP("nVisit");
            }
        }else{
            nVisit = 0;
        }

        idRoute = spClass.intGetSP("idRoute");
        nClient = spClass.intGetSP("nClient");
        nList = spClass.intGetSP("nList");

        recyclerDetailsSale = findViewById(R.id.recyclerDetailsSale);
        layoutNotData = findViewById(R.id.layoutNotData);
        layoutTotales = findViewById(R.id.layoutTotales);
        layoutDetails = findViewById(R.id.layoutDetails);
        layoutTypeSale = findViewById(R.id.layoutTypeSale);
        layoutMoney = findViewById(R.id.layoutMoney);
        layoutSwitchTypeSale = findViewById(R.id.layoutSwitchTypeSale);

        txtSubTotalValueD = findViewById(R.id.txtSubTotalValueD);
        txtIVAValueD = findViewById(R.id.txtIVAValueD);
        txtIEPSValueD = findViewById(R.id.txtIEPSValueD);
        txtChange = findViewById(R.id.txtChange);
        txtTotalValueD = findViewById(R.id.txtTotalValueD);
        editTxtImport = findViewById(R.id.editTxtImport);

        tableHeaders = findViewById(R.id.tableHeaders);
        fbtnBack = findViewById(R.id.fbtnBack);
        fbtnDeleteAll = findViewById(R.id.fbtnDeleteAll);
        fbtnHelp = findViewById(R.id.fbtnHelp);
        fbtnNext = findViewById(R.id.fbtnNext);
        fbtnFinishSale = findViewById(R.id.fbtnFinishSale);

        txtTitleLimitCredit = findViewById(R.id.txtTitleLimitCredit);
        txtTitleDebt = findViewById(R.id.txtTitleDebt);
        txtTitleRemainingCredit = findViewById(R.id.txtTitleRemainingCredit);
        switchTypeSale = findViewById(R.id.switchTypeSale);
        chkBoxFiscalInvoice = findViewById(R.id.chkBoxFiscalInvoice);

        cardExact = findViewById(R.id.cardExact);
        card20 = findViewById(R.id.card20);
        card50 = findViewById(R.id.card50);
        card100 = findViewById(R.id.card100);
        card200 = findViewById(R.id.card200);
        card500 = findViewById(R.id.card500);
        cardReset = findViewById(R.id.cardReset);
        cardSPEI = findViewById(R.id.cardSPEI);
        cardCreditCard = findViewById(R.id.cardCreditCard);

        scrollViewDetailsSale = findViewById(R.id.scrollViewDetailsSale);

        bAlertDetailsSale = spClass.boolGetSP("bAlertDetailsSale");

        GridLayoutManager mGridLayoutManagerDetails = new GridLayoutManager(this, 1);
        recyclerDetailsSale.setLayoutManager(mGridLayoutManagerDetails);
        recyclerDetailsSale.setItemAnimator(new DefaultItemAnimator());
        recyclerDetailsSale.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 0));

        fbtnBack.setOnClickListener(v -> backFunction());
        fbtnDeleteAll.setOnClickListener(v -> askDeleteAllDetails());
        fbtnNext.setOnClickListener(v -> finishSale(false));
        fbtnFinishSale.setOnClickListener(v -> finishSale(true));
        fbtnHelp.setOnClickListener(v -> showAlertHelp());

        cardExact.setOnClickListener(v-> updateTotalImport(-1));
        card20.setOnClickListener(v-> updateTotalImport(20));
        card50.setOnClickListener(v-> updateTotalImport(50));
        card100.setOnClickListener(v-> updateTotalImport(100));
        card200.setOnClickListener(v-> updateTotalImport(200));
        card500.setOnClickListener(v-> updateTotalImport(500));
        cardReset.setOnClickListener(v->updateTotalImport(0));
        cardSPEI.setOnClickListener(v->askSPEI());
        cardCreditCard.setOnClickListener(v->alertCreditCard());

        if(!bAlertDetailsSale && !functionsapp.getIsVisitFinished(nVisit)){
            //showAlertHelp();
            spClass.boolSetSP("bAlertDetailsSale",true);
        }

        scrollViewDetailsSale.smoothScrollTo(0, 0);
        baseApp.darkenStatusBar(this, Color.WHITE);

        editTxtImport.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                   updateChange();
                }catch (Exception ex){
                    baseApp.showToast("Ocurrió un error");
                }

            }
        });

        switchTypeSale.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                spClass.strSetSP("sTypeSale", "credit");
            } else {
                spClass.strSetSP("sTypeSale", "counted");
            }

            visibilityCredit();
        });

        if(functionsapp.getIsVisitFinished(nVisit)){
            switchTypeSale.setEnabled(false);
            chkBoxFiscalInvoice.setEnabled(false);
            setAmountPaid();
        }else{
            switchTypeSale.setEnabled(true);
            chkBoxFiscalInvoice.setEnabled(true);
        }

        chkBoxFiscalInvoice.setOnCheckedChangeListener((buttonView, isChecked) -> {
            VisitsClients visitsClients = realm.where(VisitsClients.class)
                    .equalTo("id", nVisit)
                    .findFirst();
            realm.beginTransaction();
            visitsClients.setEs_remision(!isChecked);
            realm.commitTransaction();
        });

        if(functionsapp.getIsVisitFinished(nVisit)){
            fbtnFinishSale.setVisibility(View.GONE);
        }

        chkBoxFiscalInvoice.setChecked(!(realm.where(VisitsClients.class)
                .equalTo("id", nVisit)
                .findFirst().isEs_remision()));

        refreshVisibilityButtons();
        refreshTotales();
        getDetailsSale();
        visibilityCredit();
        getLocation();
    }

    public void updateTotalImport(double amount){
        try{
            if(!functionsapp.getIsVisitFinished(nVisit)){
                if(amount == -1){
                    baseApp.setTextView(findViewById(R.id.editTxtImport), baseApp.formattedNumber(functionsapp.getTotalSale(nVisit, "totalImport")));
                }else if(amount == 0) {
                    baseApp.setTextView(findViewById(R.id.editTxtImport), Double.toString(amount));
                }else{
                    double currentImport = 0.0;

                    if(!editTxtImport.getText().toString().isEmpty()){
                        currentImport = Double.valueOf(editTxtImport.getText().toString().replaceAll(",", ""));
                    }

                    baseApp.setTextView(findViewById(R.id.editTxtImport), baseApp.formattedNumber((currentImport + amount)));
                }

                updateChange();
            }else{
                baseApp.showToast("Esta visita ya ha sido terminada.");
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error interno");
        }
    }
    public void finishSale(boolean finishVisit){

        try{

            if(functionsapp.getIsVisitFinished(nVisit)){
                functionsapp.goOthersActivity();
                finish();
            }else{

                if((functionsapp.getTotalSale(nVisit, "totalImport") > totalImport)
                        && spClass.strGetSP("sTypeSale").equals("counted")){
                    baseApp.showToast("Aún hay importe pendiente a pagar");
                }else {

                    paySale();

                    if(finishVisit){
                        if(functionsapp.visitHaveSale(nVisit)){
                            finishVisit(0);
                        }else{
                            showBottomClasificationVisit();
                        }

                    }else{
                        functionsapp.goOthersActivity();
                    }
                }
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    public void updateChange(){
        try{
            valueImport = editTxtImport.getText().toString();

            if(valueImport.length() == 0){
                totalImport = 0;
                txtChange.setText("$ 0.0");
            }else{
                totalImport = Double.parseDouble(valueImport.replaceAll(",",""));

                change = totalImport - functionsapp.getTotalSale(nVisit, "totalImport");
                txtChange.setText("$ " + baseApp.formattedNumber(change));
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    public void setAmountPaid(){
        try{
            if(functionsapp.getIsVisitFinished(nVisit)){

                RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class).equalTo("visita", nVisit).findAll();

                if(visitsPayments.size() > 0){
                    editTxtImport.setText(String.valueOf(visitsPayments.get(0).getImporte_pago()));
                    editTxtImport.setEnabled(false);
                }
            }else{
                switchTypeSale.setEnabled(true);
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    public void visibilityCredit(){
        try{
            RealmResults<Clients> client = realm.where(Clients.class).equalTo("cliente", nClient).findAll();
            double currentCustomerDebt;

            if(client.size() > 0){
                currentCustomerDebt = functionsapp.getCurrentCustomerDebt(nClient);

                if(client.get(0).getLimite_credito() > 0.0){
                    //layoutTypeSale.setVisibility(View.VISIBLE);
                    txtTitleLimitCredit.setVisibility(View.VISIBLE);
                    txtTitleRemainingCredit.setVisibility(View.VISIBLE);
                    layoutSwitchTypeSale.setVisibility(View.VISIBLE);

                    txtTitleLimitCredit.setText("Limite Crédito: $" + baseApp.formattedNumber(client.get(0).getLimite_credito()));
                    txtTitleRemainingCredit.setText("Crédito Restante: $" + baseApp.formattedNumber(functionsapp.getCurrentCustomerBalance(nClient)));
                }else{
                    //layoutTypeSale.setVisibility(View.INVISIBLE);
                    txtTitleLimitCredit.setVisibility(View.GONE);
                    txtTitleRemainingCredit.setVisibility(View.GONE);
                    layoutSwitchTypeSale.setVisibility(View.GONE);
                }

                 /*if(functionsapp.getCurrentCustomerDebt(nClient) > 0.0){
                    txtTitleDebt.setVisibility(View.VISIBLE);
                    txtTitleDebt.setText("Adeudo: $" + currentCustomerDebt);

                    baseApp.showAlert("Adeudo", "El cliente tiene un adeudo de: $" + currentCustomerDebt);
                }else{
                    txtTitleDebt.setVisibility(View.GONE);
                }*/
                /* TODO */
                txtTitleDebt.setVisibility(View.GONE);
            }else{
                //layoutTypeSale.setVisibility(View.INVISIBLE);
                txtTitleLimitCredit.setVisibility(View.GONE);
                txtTitleRemainingCredit.setVisibility(View.GONE);
            }

            if(functionsapp.getIsVisitFinished(nVisit)) {

                RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class).equalTo("visita", nVisit).findAll();

                if (visitsPayments.size() > 0) {
                    if (visitsPayments.get(0).getMetodo_pago().equals("Crédito")) {
                        switchTypeSale.setChecked(true);
                        layoutMoney.setVisibility(View.GONE);
                    } else {
                        switchTypeSale.setChecked(false);
                        layoutMoney.setVisibility(View.VISIBLE);
                    }
                }

            }else{
                if(spClass.strGetSP("sTypeSale").equals("credit")){
                    switchTypeSale.setChecked(true);
                    layoutMoney.setVisibility(View.GONE);

                }else{
                    switchTypeSale.setChecked(false);
                    layoutMoney.setVisibility(View.VISIBLE);
                }
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    @SuppressLint("RestrictedApi")
    public void getDetailsSale(){
        final FunctionsApp functionsapp = new FunctionsApp(this);

        try {
            if(nVisit != 0 || nPedido != 0) {
                realm = Realm.getDefaultInstance();
                listDetails = realm.where(DetailsSales.class).equalTo("visita", nVisit).findAll();
                totalDetails = listDetails.size();
                listDetails.addChangeListener(this);

                if (totalDetails > 0) {
                    layoutDetails.setVisibility(View.VISIBLE);
                    layoutNotData.setVisibility(View.GONE);

                    AdapterDetailsSales adapterDetailsSales = new AdapterDetailsSales(this, listDetails);

                    recyclerDetailsSale.setItemAnimator(new DefaultItemAnimator());
                    recyclerDetailsSale.setAdapter(adapterDetailsSales);
                } else {
                    layoutDetails.setVisibility(View.GONE);
                    layoutNotData.setVisibility(View.VISIBLE);
                }
            }else{
                baseApp.showAlert("Error", "Ocurrió un error al cargar el valor de Visita o Pedido. Valor de Visita : " + nVisit + " , valor de Pedido: " + nPedido);
            }
        } catch (Exception ex) {
            baseApp.showAlert("Error", "Ocurrió un error al mostrar la lista de Detalles, reporta el siguiente error al departamento de Sistemas" +  ex);
            Log.e("ERR:", "" + ex);
        }
    }

    public void showBottomClasificationVisit(){
        BottomSheetDialog menuBottomSheet;
        TextView btnCancel, btnEndVisit;

        try {

            menuBottomSheet = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);
            menuBottomSheet.setContentView(R.layout.bottom_sheet_clasification_visit);
            menuBottomSheet.setCancelable(false);
            menuBottomSheet.show();

            btnCancel = menuBottomSheet.findViewById(R.id.btnCancel);
            btnEndVisit = menuBottomSheet.findViewById(R.id.btnEndVisit);
            spinnerClasifications = menuBottomSheet.findViewById(R.id.spinnerClasification);

            populateVisitsClasifications();

            btnEndVisit.setOnClickListener(v -> {
                // Evitar doble click boton
                if (false){/*SystemClock.elapsedRealtime() - ultimoClick < TIEMPO_MINIMO){*/
                    baseApp.showToast("Espera 4 segundos antes de volver a darle clic a este botón");
                }else {
                    if(spinnerClasifications.getSelectedItemPosition() == 0){
                        position = 0;
                    }else{
                        position = spinnerClasifications.getSelectedItemPosition();
                    }

                    finishVisit(position);

                    ultimoClick = SystemClock.elapsedRealtime();
                }
            });
            btnCancel.setOnClickListener(v -> {
                isSPEI = false;
                isCreditCard = false;
                cCreditCard = "";
                cLast4 = "";
                updateTotalImport(0);
                menuBottomSheet.dismiss();
            });

        }catch (Exception ex){
            baseApp.showToast("No se puede mostrar la alerta de clasificaciones. " + ex);
        }
    }

    public void finishVisit(int clasification) {
        BaseApp baseApp = new BaseApp(this);
        SPClass spClass = new SPClass(this);

        int clasificationValue;
        VisitsClients visits;

        try {
            realm = Realm.getDefaultInstance();

            RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class).equalTo("id", nVisit).findAll();

            if (baseApp.statusPermissionUbication()) {
                if (!locationDisabled) {
                    if (realm.where(VisitsClasifications.class).findAll().size() > 0) {
                        try {
                            //RealmResults<VisitsClasifications> visitsClasifications = realm.where(VisitsClasifications.class).equalTo("position", spinnerClasifications.getSelectedItemPosition()).findAll();
                            RealmResults<VisitsClasifications> visitsClasifications = realm.where(VisitsClasifications.class).findAll();
                            clasificationValue = visitsClasifications.get(clasification).getClasificacion();
                        } catch (Exception ex) {
                            clasificationValue = 1;
                            baseApp.showLog("Ocurrió el error:: " + ex);
                        }
                    } else {
                        clasificationValue = 0;
                    }

                    RealmResults<VisitsMovements> movements = realm.where(VisitsMovements.class).equalTo("ruta", idRoute).equalTo("visita", nVisit).findAll();

                    /*for (VisitsMovements movement : movements) {
                        functionsapp.changeMovementsSalesArticle(idRoute, nVisit, movement.getClave_articulo(), movement.getPiezas_devolucion());
                    }*/

                    visits = visitsClients.get(0);
                    realm.beginTransaction();
                    visits.setEs_credito(functionsapp.getIsCredit(nVisit));
                    visits.setVisitada(true);
                    visits.setFecha_visita_fin(baseApp.getCurrentDateFormated());
                    visits.setClasificacion_visita(clasificationValue);
                    visits.setLat_visita_fin(latitudeUser);
                    visits.setLong_visita_fin(longitudeUser);
                    realm.insertOrUpdate(visits);
                    realm.commitTransaction();

                    spClass.deleteSP("inVisit");
                    spClass.deleteSP("nClient");
                    spClass.deleteSP("nList");
                    spClass.deleteSP("nVisit");
                    spClass.deleteSP("sPaymentMethod");

                    if (spClass.boolGetSP("onlineConnection")) {
                        backgroundProcess("uploadData");
                    }else{
                        functionsapp.printTicket(nVisit);
                    }

                    baseApp.showToast("Visita dada por terminada");

                    functionsapp.goListClientsActivity(nList, true);

                    if(functionsapp.getIsCredit(nVisit)) {
                        new androidx.appcompat.app.AlertDialog.Builder(this)
                                .setTitle("Venta a crédito")
                                .setMessage("¿Desea imprimir una copia del ticket?")
                                .setCancelable(false)
                                .setPositiveButton("Sí", (dialog, id) -> {
                                    functionsapp.printTicket(nVisit);
                                    functionsapp.goListClientsActivity(nList, true);
                                })
                                .setNegativeButton("No", (dialog, id) -> {
                                    functionsapp.goListClientsActivity(nList, true);
                                })
                                .show();
                    }else{
                        functionsapp.goListClientsActivity(nList, true);
                    }

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        if (notificationManager != null) {
                            notificationManager.cancel(1);
                        }
                    }
                } else {
                    baseApp.showAlertDialog("warning", "Ubicación desactivada", "Por favor, activa el GPS y el Internet y vuelve a intentarlo.", true);
                }
            }else {
                baseApp.showToast("No está activado el permiso de Ubicación");
            }
        }catch(Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al intentar finalizar la visita, reporta el siguiente error al Dpto de Sistemas: " + ex);
            ex.printStackTrace();

            spClass.deleteSP("inVisit");
            spClass.deleteSP("nClient");
            spClass.deleteSP("nList");
            spClass.deleteSP("nVisit");
            spClass.deleteSP("sPaymentMethod");

            finish();
        }
    }

    public void populateVisitsClasifications(){
        try {
            List<String> listClasificationsArray = new ArrayList<>();
            listClasifications = realm.where(VisitsClasifications.class).findAll();

            if (listClasifications.size() == 0) {
                baseApp.showToast("No se encontraron Clasificaciones de Visitas para cargar.");
                //finish();
                spinnerClasifications.setEnabled(false);
            } else {

                for (int i = 0; i < listClasifications.size(); i++) {
                    listClasificationsArray.add(listClasifications.get(i).getNombre_clasificacion().trim());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        this, android.R.layout.simple_spinner_item, listClasificationsArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerClasifications.setAdapter(adapter);
                spinnerClasifications.setEnabled(true);

                RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class).equalTo("id", nVisit).findAll();

                spinnerClasifications.setSelection(visitsClients.get(0).getPosition_clasificacion_visita());
            }
        }catch (Exception ex){
            baseApp.showAlert("Error", "No se pudieron cargar las Clasificaciones de Visitas por este error: " + ex);
        }
    }

    public void deleteDetail(final int clave_article, final String article, final String article_name){

        if(functionsapp.getIsVisitFinished(nVisit)){
            baseApp.showToast("Visita finalizada, no puedes borrar un detalle");
        }else{
            new AlertDialog.Builder(this)
                    .setMessage("¿Estás seguro que quieres eliminar el detalle del articulo " + article_name + "?")
                    .setCancelable(true)
                    .setPositiveButton("Sí", (dialog, id) -> {

                        realm.beginTransaction();
                        final RealmResults<DetailsSales> results = realm.where(DetailsSales.class).equalTo("articulo", article).equalTo("visita", nVisit).findAll();
                        results.deleteAllFromRealm();
                        realm.commitTransaction();
                        getDetailsSale();
                        baseApp.showToast("Se ha eliminado el artículo " + article_name);
                        //functionsapp.changeMovementsSalesArticle(idRoute, nVisit, clave_article, 0);
                        refreshTotales();
                    })
                    .setNegativeButton("No", null)
                    .show();
        }

    }

    public void refreshTotales(){
        if(functionsapp.countDetailsSaleVisit(nVisit, 2) > 0){
            txtSubTotalValueD.setText("$ " + baseApp.formattedNumber(functionsapp.getTotalSale(nVisit, "subTotal")));
            txtIVAValueD.setText("$ " +  baseApp.formattedNumber(functionsapp.getTotalSale(nVisit, "totalIVA")));
            txtIEPSValueD.setText("$ " +  baseApp.formattedNumber(functionsapp.getTotalSale(nVisit, "totalIEPS")));
            txtTotalValueD.setText("$ " + baseApp.formattedNumber(functionsapp.getTotalSale(nVisit, "totalImport")));

            baseApp.setTextView(findViewById(R.id.txtViewExact), "$ " + baseApp.formattedNumber(functionsapp.getTotalSale(nVisit, "totalImport")));
        }else{
            txtSubTotalValueD.setText("$ 0.00");
            txtIVAValueD.setText("$ 0.00");
            txtIEPSValueD.setText("$ 0.00");
            txtTotalValueD.setText("$ 0.00");
        }
    }

    @SuppressLint("RestrictedApi")
    public void refreshVisibilityButtons(){

        if(totalDetails > 0){
            fbtnDeleteAll.setVisibility(View.VISIBLE);
        }else{
            fbtnDeleteAll.setVisibility(View.GONE);
        }

        if(functionsapp.getIsVisitFinished(nVisit)){
            fbtnDeleteAll.setVisibility(View.GONE);
        }
    }

    public void askDeleteAllDetails(){
        new AlertDialog.Builder(this)
                .setMessage("¿Estás seguro que quieres eliminar todos los Detalles?")
                .setCancelable(true)
                .setPositiveButton("Sí", (dialog, id) -> {
                    deleteAllDetails();
                    getDetailsSale();
                    refreshTotales();
                })
                .setNegativeButton("No", null)
                .show();

    }

    public void askSPEI(){
        new AlertDialog.Builder(this)
                .setMessage("¿Estás seguro de pagar la visita con Transferencia SPEI?")
                .setCancelable(true)
                .setPositiveButton("Sí", (dialog, id) -> {
                    isSPEI = true;
                    updateTotalImport(-1);
                    finishSale(true);
                })
                .setNegativeButton("No", (dialog, id) -> {
                    isSPEI = false;
                })
                .show();
    }

    public void alertCreditCard(){
        try{
            View popupInputDialogView;
            androidx.appcompat.app.AlertDialog alert;
            RadioButton radioBtnDebit, radioBtnCredit;
            EditText editTxtLast4;
            Button btnDialogSave, btnDialogCancel;

            alert = new androidx.appcompat.app.AlertDialog.Builder(this).create();
            LayoutInflater layoutInflater = LayoutInflater.from(this);
            popupInputDialogView = layoutInflater.inflate(R.layout.dialog_credit_card, null);

            radioBtnDebit = popupInputDialogView.findViewById(R.id.radioBtnDebit);
            radioBtnCredit = popupInputDialogView.findViewById(R.id.radioBtnCredit);

            editTxtLast4 = popupInputDialogView.findViewById(R.id.editTxtLast4);

            btnDialogSave = popupInputDialogView.findViewById(R.id.btnDialogSave);
            btnDialogCancel = popupInputDialogView.findViewById(R.id.btnDialogCancel);

            alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alert.setView(popupInputDialogView);

            alert.show();

            btnDialogSave.setOnClickListener(v -> {
                String valueEditTxtLast4 = editTxtLast4.getText().toString();

                if(valueEditTxtLast4.length() != 4){
                    baseApp.showToast("Escribe los últimos 4 digitos de la tarjeta.");
                }else if(!radioBtnDebit.isChecked() && !radioBtnCredit.isChecked()) {
                    baseApp.showToast("Seleccione el tipo de tarjeta.");
                }else{
                    isCreditCard = true;
                    cCreditCard = (radioBtnDebit.isChecked() ? "debit" : "credit");
                    cLast4 = editTxtLast4.getText().toString();

                    updateTotalImport(-1);
                    finishSale(true);

                    alert.cancel();
                }
            });

            btnDialogCancel.setOnClickListener(view -> {
                alert.cancel();
            });

        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error interno.");
        }
    }

    /*public void showMenuBottomFinishSale(boolean withDetails) {
        TextView btnYes, btnNo, txtViewTitle;

        menuBottomSheet = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);
        menuBottomSheet.setContentView(R.layout.bottom_sheet_confirm);
        menuBottomSheet.setCancelable(true);
        menuBottomSheet.show();

        txtViewTitle = menuBottomSheet.findViewById(R.id.txtViewInfo);
        btnYes = menuBottomSheet.findViewById(R.id.btnYes);
        btnNo = menuBottomSheet.findViewById(R.id.btnNo);

        if(withDetails){
            txtViewTitle.setText("¿Deseas terminar la venta?");
        }else{
            txtViewTitle.setText("¿Deseas terminar la venta sin detalles?");
        }

        btnYes.setOnClickListener(v-> {
            paySale();

            menuBottomSheet.dismiss();
        });
        btnNo.setOnClickListener(v-> menuBottomSheet.dismiss());
    }*/

    public void paySale(){
        try{

            // Evitar doble click boton
            if (SystemClock.elapsedRealtime() - ultimoClick < TIEMPO_MINIMO){
                baseApp.showToast("Espera 4 segundos antes de volver a darle clic a este botón");
            }else {
                ultimoClick = SystemClock.elapsedRealtime();

                VisitsClients visits;

                //desactivar en visitas las ventas
                //cambiar total de venta en visita

                RealmResults<Clients> client = realm.where(Clients.class).equalTo("cliente", nClient).findAll();

                if (client.size() > 0) {
                    if (spClass.strGetSP("sTypeSale").equals("credit") && functionsapp.getCurrentCustomerBalance(nClient) == 0) {
                        baseApp.showSnackBar("El cliente no tiene crédito en este momento.");
                    } else if (spClass.strGetSP("sTypeSale").equals("credit") && functionsapp.getTotalSale(nVisit, "totalImport") > functionsapp.getCurrentCustomerBalance(nClient)) {
                        baseApp.showSnackBar("El total de la venta supera al saldo actual del cliente.");
                    } else{
                        RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class).equalTo("id", nVisit).findAll();

                        visits = visitsClients.get(0);
                        realm.beginTransaction();
                        visits.setEstado_ventas(false);

                        RealmResults<VisitsPayments> visitsPaymentsOld = realm.where(VisitsPayments.class)
                                .equalTo("ruta", idRoute)
                                .equalTo("visita", nVisit)
                                .findAll();
                        visitsPaymentsOld.deleteAllFromRealm();

                        VisitsPayments visitsPayments = new VisitsPayments();
                        double totalImportSale = functionsapp.getTotalSale(nVisit, "totalImport");

                        visitsPayments.setRuta(idRoute);
                        visitsPayments.setVisita(nVisit);
                        visitsPayments.setCliente(nClient);
                        visitsPayments.setImporte(totalImportSale);
                        visitsPayments.setImporte_pago(totalImport);
                        //visitsPayments.setCambio(change);
                        visitsPayments.setEnviado(false);
                        visitsPayments.setFecha(baseApp.getCurrentDateFormated());

                        if (spClass.strGetSP("sTypeSale").equals("credit")) {
                            visitsPayments.setCobrado(false);
                            visitsPayments.setFecha_cobrado("");
                            visitsPayments.setMetodo_pago("");
                            visits.setEs_credito(true);
                        } else if (spClass.strGetSP("sTypeSale").equals("counted")) {

                            if(isSPEI){
                                visitsPayments.setMetodo_pago("Transferencia Electrónica");
                            }else if(isCreditCard) {
                                if(cCreditCard.equals("debit")){
                                    visitsPayments.setMetodo_pago("Tarjeta de Débito");
                                }else{
                                    visitsPayments.setMetodo_pago("Tarjeta de Crédito");
                                }

                                visitsPayments.setUltimos_4_tarjeta(Integer.parseInt(cLast4));
                            }else{
                                visitsPayments.setMetodo_pago("Efectivo MXP");
                            }

                            visitsPayments.setCobrado(true);
                            visitsPayments.setFecha_cobrado(baseApp.getCurrentDateFormated());
                            visitsPayments.setImporte_saldado(totalImportSale);
                        } else {
                            visitsPayments.setMetodo_pago("");
                        }

                        realm.insertOrUpdate(visits);
                        realm.insertOrUpdate(visitsPayments);
                        realm.commitTransaction();

                        listDetails = realm.where(DetailsSales.class).equalTo("visita", nVisit).findAll();

                        baseApp.showToast("Venta dada por pagada");
                    }
                }
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
            ex.printStackTrace();
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

    public void backgroundProcess(String process){
        Handler handler;
        ProgressDialog dialog;
        FunctionsApp functionsApp = new FunctionsApp(this);

        dialog = new ProgressDialog(this);

        dialog.setMessage("Espera unos momentos...");
        dialog.setCancelable(false);
        dialog.show();

        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {

            try {
                if(baseApp.verifyServerConnection()) {
                    if(baseApp.isOnline(this)) {

                        switch (process){
                            case "uploadData":
                                functionsApp.uploadData();
                                functionsApp.printTicket(nVisit);
                                break;
                            default:
                                return;
                        }

                    } else {
                        baseApp.showAlertDialog("error", "Error", "Prende tu señal de datos o conéctate a una red WIFI para poder descargar los datos", true);
                    }
                }else{
                    baseApp.showAlertDialog("error", "Error", "No hay conexión al Servidor, reconfigura los datos de conexión e inténtalo de nuevo.", true);
                }

            } catch (Exception ex) {
                baseApp.showAlert("Error", "Ocurrió un error, reporta el siguiente error al Dpto de Sistemas: " + ex);
            }

            try{
                if(dialog.isShowing()) {
                    dialog.dismiss();
                }
            }catch (Exception ex){
                baseApp.showLog("Ocurrió un error: " + ex);
            }


        }, 1000);
    }

    @Override
    public void onLocationChanged(Location location) {
        latitudeUser = location.getLatitude();
        longitudeUser = location.getLongitude();
    }

    @Override
    public void onProviderDisabled(String provider) {
        //Toast.makeText(ListClientsActivity.this, "Por favor, activa el GPS y el Internet", Toast.LENGTH_SHORT).show();
        baseApp.showToast("GPS desactivado. Por favor, actívalo.");
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

    public void deleteAllDetails(){
        realm.beginTransaction();
        final RealmResults<DetailsSales> results = realm.where(DetailsSales.class).equalTo("visita", nVisit).findAll();
        results.deleteAllFromRealm();
        realm.commitTransaction();

    }

    public void showAlertHelp(){
        baseApp.showAlertDialog("info", "Ayuda", " - Para eliminar un detalle presiónelo dos veces. \n" +
                " * Para editar un detalle, manténgalo presionado.", false);
    }

    public void onResume() {
        super.onResume();
        refreshTotales();
        visibilityCredit();
    }

    public void onBackPressed() {
        backFunction();
    }

    public void backFunction(){

        if(functionsapp.getIsVisitFinished(nVisit)){
            functionsapp.goSalesActivity();
        }else{
            finish();
            overridePendingTransition(0, 0);
        }
    }

    @Override
    public void onChange(RealmResults<DetailsSales> details) {

    }
}

