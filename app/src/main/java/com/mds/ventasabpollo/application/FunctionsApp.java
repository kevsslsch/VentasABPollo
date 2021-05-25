package com.mds.ventasabpollo.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.mazenrashed.printooth.Printooth;
import com.mazenrashed.printooth.data.printable.ImagePrintable;
import com.mazenrashed.printooth.data.printable.Printable;
import com.mazenrashed.printooth.data.printable.TextPrintable;
import com.mazenrashed.printooth.data.printer.DefaultPrinter;
import com.mazenrashed.printooth.utilities.Printing;
import com.mazenrashed.printooth.utilities.PrintingCallback;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.activities.AboutActivity;
import com.mds.ventasabpollo.activities.AccountActivity;
import com.mds.ventasabpollo.activities.AddClientActivity;
import com.mds.ventasabpollo.activities.AveragesActivity;
import com.mds.ventasabpollo.activities.ChangeConnectionActivity;
import com.mds.ventasabpollo.activities.ChangeInventoryActivity;
import com.mds.ventasabpollo.activities.ChangeUbicationClientActivity;
import com.mds.ventasabpollo.activities.ConfigurationActivity;
import com.mds.ventasabpollo.activities.DetailsDepartureActivity;
import com.mds.ventasabpollo.activities.DetailsSalesActivity;
import com.mds.ventasabpollo.activities.FinalReportActivity;
import com.mds.ventasabpollo.activities.InventoryActivity;
import com.mds.ventasabpollo.activities.ListClientsActivity;
import com.mds.ventasabpollo.activities.LoginActivity;
import com.mds.ventasabpollo.activities.MainActivity;
import com.mds.ventasabpollo.activities.MapsActivity;
import com.mds.ventasabpollo.activities.MapsRouteActivity;
import com.mds.ventasabpollo.activities.OthersActivity;
import com.mds.ventasabpollo.activities.PayOffActivity;
import com.mds.ventasabpollo.activities.PrepareDepartureActivity;
import com.mds.ventasabpollo.activities.ReChargeInventoryActivity;
import com.mds.ventasabpollo.activities.RestoreDBActivity;
import com.mds.ventasabpollo.activities.RoutesActivity;
import com.mds.ventasabpollo.activities.SalesActivity;
import com.mds.ventasabpollo.activities.VisitsActivity;
import com.mds.ventasabpollo.models.Articles;
import com.mds.ventasabpollo.models.BranchOffices;
import com.mds.ventasabpollo.models.ChangesInventories;
import com.mds.ventasabpollo.models.Clients;
import com.mds.ventasabpollo.models.DetailsDepartures;
import com.mds.ventasabpollo.models.DetailsSales;
import com.mds.ventasabpollo.models.Images;
import com.mds.ventasabpollo.models.Inventories;
import com.mds.ventasabpollo.models.NewClients;
import com.mds.ventasabpollo.models.PrepareDeparture;
import com.mds.ventasabpollo.models.Prices;
import com.mds.ventasabpollo.models.RechargeInventories;
import com.mds.ventasabpollo.models.Routes;
import com.mds.ventasabpollo.models.VisitsClasifications;
import com.mds.ventasabpollo.models.VisitsClients;
import com.mds.ventasabpollo.models.VisitsMovements;
import com.mds.ventasabpollo.models.VisitsPayments;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class FunctionsApp extends Application {

    private Realm realm;
    private static Context context;

    int nextID;
    String messagesSync = "";

    private Printing printing = null;
    PrintingCallback printingCallback=null;

    public FunctionsApp(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    // funcion para ir al LoginActivity
    public void goLoginActivity() {
        Intent iLoginActivity = new Intent(context, LoginActivity.class);
        context.startActivity(iLoginActivity);
        ((Activity) (context)).finish();
    }

    // funcion para ir al MainActivity
    public void goMainActivity() {
        Intent iMainActivity = new Intent(context, MainActivity.class);
        context.startActivity(iMainActivity);
        ((Activity) (context)).finish();
    }

    // funcion para ir al MainActivity
    public void goMainActivity(int nDeparture) {
        Intent iMainActivity = new Intent(context, MainActivity.class);
        iMainActivity.putExtra("nDeparture", nDeparture);
        context.startActivity(iMainActivity);
        ((Activity) (context)).finish();
    }

    // funcion para ir al MainActivity
    @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
    public void goChangeConnection() {
        Intent iChangeConnectionActivity = new Intent(context, ChangeConnectionActivity.class);
        iChangeConnectionActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(iChangeConnectionActivity);
        ((Activity) (context)).overridePendingTransition(0, 0);
        ((Activity) (context)).finish();
    }

    // funcion para ir al AboutActivity
    public void goAboutActivity() {
        Intent iAboutActivity = new Intent(context, AboutActivity.class);
        iAboutActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(iAboutActivity);
        ((Activity) (context)).overridePendingTransition(0, 0);
        ((Activity) (context)).finish();
    }

    // funcion para ir al AboutActivity
    public void goRestoreDBActivity() {
        Intent iRestoreDBActivity = new Intent(context, RestoreDBActivity.class);
        iRestoreDBActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(iRestoreDBActivity);
        ((Activity) (context)).overridePendingTransition(0, 0);
        ((Activity) (context)).finish();
    }

    public void goAccountActivity() {
        Intent iAccountActivity = new Intent(context, AccountActivity.class);
        context.startActivity(iAccountActivity);
        //((Activity) (context)).finish();
    }

    public void goConfigurationActivity() {
        Intent iConfigurationActivity = new Intent(context, ConfigurationActivity.class);
        context.startActivity(iConfigurationActivity);
        //((Activity) (context)).finish();
    }

    public void goListClientsActivity(int list, boolean clearActivity) {
        Intent iListClientsActivity = new Intent(context, ListClientsActivity.class);
        iListClientsActivity.putExtra("nList", list);

        if (clearActivity) {
            iListClientsActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }

        context.startActivity(iListClientsActivity);
        ((Activity) (context)).finish();
    }

    public void goMapsRouteActivity(int list) {
        Intent iMapsRouteActivity = new Intent(context, MapsRouteActivity.class);
        iMapsRouteActivity.putExtra("nList", list);
        context.startActivity(iMapsRouteActivity);
        //((Activity) (context)).finish();
    }

    // funcion para la lista de articulos
    public void goSalesActivity() {
        Intent iArticlesActivity = new Intent(context, SalesActivity.class);
        iArticlesActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(iArticlesActivity);
        ((Activity) (context)).overridePendingTransition(0, 0);
        ((Activity) (context)).finish();
    }

    public void goOthersActivity() {
        Intent iArticlesActivity = new Intent(context, OthersActivity.class);
        iArticlesActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(iArticlesActivity);
        iArticlesActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        ((Activity) (context)).overridePendingTransition(0, 0);
        ((Activity) (context)).finish();
    }

    public void goInventoryActivity() {
        Intent iInventoryActivity = new Intent(context, InventoryActivity.class);
        context.startActivity(iInventoryActivity);
        //((Activity) (context)).finish();
    }

    public void goPayOffActivity(int nClient) {
        Intent iPayOffActivity = new Intent(context, PayOffActivity.class);
        iPayOffActivity.putExtra("nClient", nClient);
        context.startActivity(iPayOffActivity);
        //((Activity) (context)).finish();
    }

    public void goChangeInventoryActivity() {
        Intent iChangeInventoryActivity = new Intent(context, ChangeInventoryActivity.class);
        iChangeInventoryActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(iChangeInventoryActivity);
        ((Activity) (context)).overridePendingTransition(0, 0);
    }

    public void goReChargeInventoryActivity() {
        Intent iRechargeInventoryActivity = new Intent(context, ReChargeInventoryActivity.class);
        iRechargeInventoryActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(iRechargeInventoryActivity);
        ((Activity) (context)).overridePendingTransition(0, 0);
    }

    // funcion para ir a la lista de detalles de un pedido
    public void goDetailsSaleActivity(int visit) {
        Intent iDetailsSaleActivity = new Intent(context, DetailsSalesActivity.class);
        iDetailsSaleActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        iDetailsSaleActivity.putExtra("nPedido", 1);
        iDetailsSaleActivity.putExtra("nVisit", visit);
        context.startActivity(iDetailsSaleActivity);
        ((Activity) (context)).overridePendingTransition(0, 0);
        //((Activity) (context)).finish();
    }

    public void goMapsActivity(int client) {
        Intent iMapsActivity = new Intent(context, MapsActivity.class);
        iMapsActivity.putExtra("nClient", client);
        context.startActivity(iMapsActivity);
        //((Activity) (context)).finish();
    }

    // funcion para ir al ChangeUbicationClientActivity
    public void goChangeUbicationClientActivity(int client) {
        Intent iChangeUbicationClientActivity = new Intent(context, ChangeUbicationClientActivity.class);
        iChangeUbicationClientActivity.putExtra("nClient", client);
        context.startActivity(iChangeUbicationClientActivity);
        //((Activity) (context)).finish();
    }

    public void goAveragesActivity(int client) {
        Intent iAveragesActivity = new Intent(context, AveragesActivity.class);
        iAveragesActivity.putExtra("nClient", client);
        context.startActivity(iAveragesActivity);
        //((Activity) (context)).finish();
    }

    public void goSalesActivity2() {
        Intent iArticlesActivity = new Intent(context, SalesActivity.class);
        iArticlesActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(iArticlesActivity);
        ((Activity) (context)).overridePendingTransition(0, 0);
        //((Activity) (context)).finish();
    }

    public void goDetailsDepartureActivity(int nDeparture, String sNameAuthorized) {
        Intent iDetailsDepartureActivity = new Intent(context, DetailsDepartureActivity.class);
        iDetailsDepartureActivity.putExtra("nDeparture", nDeparture);
        iDetailsDepartureActivity.putExtra("sNameAuthorized", sNameAuthorized);
        context.startActivity(iDetailsDepartureActivity);
        //((Activity) (context)).finish();
    }

    public void goFinalReportRouteActivity(int route) {
        Intent iFinalReportActivity = new Intent(context, FinalReportActivity.class);
        iFinalReportActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        iFinalReportActivity.putExtra("idRoute", route);
        context.startActivity(iFinalReportActivity);
        ((Activity) (context)).overridePendingTransition(0, 0);
    }

    public void goRoutesActivity() {
        Intent iRoutesActivity = new Intent(context, RoutesActivity.class);
        context.startActivity(iRoutesActivity);
        //((Activity) (context)).finish();
    }

    public void goVisitsRouteActivity(int route) {
        Intent iVisitsActivity = new Intent(context, VisitsActivity.class);
        iVisitsActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        iVisitsActivity.putExtra("idRoute", route);
        context.startActivity(iVisitsActivity);
        ((Activity) (context)).overridePendingTransition(0, 0);

        //((Activity) (context)).finish();
    }

    public void goAddClientActivity() {
        Intent iAddClientActivity = new Intent(context, AddClientActivity.class);
        context.startActivity(iAddClientActivity);
        //((Activity) (context)).finish();
    }

    public void goPrepareDepartureActivity() {
        Intent iPrepareDepartureActivity = new Intent(context, PrepareDepartureActivity.class);
        context.startActivity(iPrepareDepartureActivity);
        //((Activity) (context)).finish();
    }

    public int clasificationVisit(int client, int route) {
        BaseApp baseApp = new BaseApp(context);

        try {
            realm = Realm.getDefaultInstance();

            RealmResults<VisitsClients> visits = realm.where(VisitsClients.class)
                    .equalTo("ruta", route)
                    .equalTo("cliente", client)
                    .sort("id", Sort.DESCENDING)
                    .findAll();

            if(visits.size() > 0){
                return visits.get(0).getClasificacion_visita();
            }else{
                return 0;
            }

        } catch (Exception ex) {
            baseApp.showToast("Ocurrió el error: " + ex);
            return 0;
        }
    }

    public String getBase64(int clave_integer, String table){
        String base64 = "";
        BaseApp baseApp = new BaseApp(context);

        try {
            realm = Realm.getDefaultInstance();

            if (clave_integer != 0 && !table.isEmpty()) {
                RealmResults<Images> images = realm.where(Images.class).equalTo("tabla", table).equalTo("clave_integer", clave_integer).findAll();
                int countImages = images.size();

                if (countImages > 0) {
                    if (!images.get(0).getTexto_base64().isEmpty()) {
                        base64 = images.get(0).getTexto_base64();
                    } else {
                        base64 = "";
                    }
                } else {
                    base64 = "";
                }

            } else {
                baseApp.showToast("Error al traer Base64, la clave de la imagen no puede ser 0 o la tabla estar vacia");
            }
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al obtener la imagen de un artículo, error: " + ex);
            base64 = "";
        }

        return base64;
    }

    // función para verificar si hay una ..
    public void inVisitVerify() {
        SPClass spClass = new SPClass(context);
        int nVisit = spClass.intGetSP("nVisit");

        if (spClass.boolGetSP("inVisit")) {
            //goClientActivity(nClient);
            if(getStatusSalesVisit(nVisit)){
                goSalesActivity();
            }else{
                goOthersActivity();
            }
        }
    }

    public boolean getStatusSalesVisit(int visit){
        BaseApp baseApp = new BaseApp(context);
        VisitsClients visits;

        try{
            realm = Realm.getDefaultInstance();

            RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class).equalTo("id", visit).findAll();

            if(visitsClients.size() > 0){
                visits = visitsClients.get(0);

                return visits.isEstado_ventas();
            }else{
                return false;
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
            return false;
        }
    }

    public double getTotalSaleRoute(int route){
        realm = Realm.getDefaultInstance();
        BaseApp baseApp = new BaseApp(context);

        try {
            int countDetail;
            double total = 0.0;
            double totalImport = 0.0;
            double lnIVA = 0.0;
            double lnIEPS = 0.0;

            RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class)
                    .equalTo("ruta", route)
                    .equalTo("metodo_pago", "Efectivo MXP")
                    .findAll();

            baseApp.showLog("visitsPayments" + visitsPayments.size());
            //RealmResults<VisitsPayments> visitsPayments2 = realm.where(VisitsPayments.class).equalTo("ruta", route).equalTo("metodo_pago", "Crédito").equalTo("cobrado", true).findAll();

            int countVisits = visitsPayments.size();
            //int countVisits2 = visitsPayments2.size();

            int contador = 1;

            if(countVisits > 0){
                for(VisitsPayments visit: visitsPayments){
                    total += visit.getImporte_saldado();
                    baseApp.showLog(contador + "" +  + visit.getImporte_saldado());
                    contador++;
                }
            }

           /*/ if(countVisits2 > 0){
                for(VisitsPayments visit: visitsPayments2){
                    total += visit.getTotal_venta();
                }
            }/

            //return round(total);***/

            return total;
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al cargar un Total, reporta el siguiente error al Dpto de Sistemas: " + ex);
            baseApp.showLog("Error: " + ex);
            return 0;
        }
    }

    public double getTotalRoute(int route, String paymentMethod){
        realm = Realm.getDefaultInstance();
        BaseApp baseApp = new BaseApp(context);

        try {
            int countDetail;
            double total = 0.0;
            double totalImport = 0.0;
            double lnIVA = 0.0;
            double lnIEPS = 0.0;

            RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class)
                    .equalTo("ruta", route)
                    .equalTo("metodo_pago", paymentMethod)
                    .findAll();

            baseApp.showLog("visitsPayments" + visitsPayments.size());
            //RealmResults<VisitsPayments> visitsPayments2 = realm.where(VisitsPayments.class).equalTo("ruta", route).equalTo("metodo_pago", "Crédito").equalTo("cobrado", true).findAll();

            int countVisits = visitsPayments.size();
            //int countVisits2 = visitsPayments2.size();

            int contador = 1;

            if(countVisits > 0){
                for(VisitsPayments visit: visitsPayments){
                    total += visit.getImporte_saldado();
                    baseApp.showLog(contador + "" +  + visit.getImporte_saldado());
                    contador++;
                }
            }

           /*/ if(countVisits2 > 0){
                for(VisitsPayments visit: visitsPayments2){
                    total += visit.getTotal_venta();
                }
            }/

            //return round(total);***/

            return total;
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al cargar un Total, reporta el siguiente error al Dpto de Sistemas: " + ex);
            baseApp.showLog("Error: " + ex);
            return 0;
        }
    }

    public double getDataInventoryRoute(int route, int article, String data){
        BaseApp baseApp = new BaseApp(context);
        double amountSale = 0, amountDevolution = 0, amountChange = 0, amountSeparated = 0;

        try{
            realm = Realm.getDefaultInstance();

            RealmResults<VisitsMovements> visitMovements = realm.where(VisitsMovements.class)
                    .equalTo("ruta", route)
                    .equalTo("clave_articulo", article)
                    .findAll();

            RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class)
                    .equalTo("ruta", route)
                    .notEqualTo("fecha_visita_fin", "")
                    .findAll();

            switch (data){
                case "venta":

                    for(VisitsClients visitsClients1: visitsClients){
                        RealmResults<DetailsSales> detailsSales = realm.where(DetailsSales.class)
                                .equalTo("visita", visitsClients1.getId())
                                .equalTo("clave_articulo", article)
                                .findAll();

                        for(DetailsSales detailsSales1: detailsSales) {
                            amountSale += detailsSales1.getCantidad();
                        }
                    }

                    return amountSale;
                case "devolucion":

                    for(VisitsMovements movement: visitMovements) {
                        amountDevolution += movement.getPiezas_devolucion();
                    }

                    return amountDevolution;
                case "cambio":

                    for(VisitsMovements movement: visitMovements) {
                        amountChange += movement.getPiezas_cambio();
                    }

                    return amountChange;
                case "apartado":

                    for(VisitsMovements movement: visitMovements) {
                        amountSeparated += movement.getPiezas_apartado();
                    }

                    return amountSeparated;
                default:
                    return 0;
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
            return 0;
        }
    }

    public double getAmountArticleRoute(int route, int article, boolean inDevoluting, boolean isInventory){
        SPClass spClass = new SPClass(context);
        BaseApp baseApp = new BaseApp(context);

        int nVisit;
        double amountSales = 0, amountDevolutions = 0, countChanges = 0, countRecharges = 0;

        try{
            realm = Realm.getDefaultInstance();

            nVisit = spClass.intGetSP("nVisit");

            if (!spClass.boolGetSP("inVisit")) {
                nVisit = 0;
            }

            RealmResults<Inventories> inventories = realm.where(Inventories.class)
                    .equalTo("ruta", route)
                    .equalTo("clave_articulo", article)
                    .findAll();

            RealmResults<ChangesInventories> changesInventories = realm.where(ChangesInventories.class)
                    .equalTo("ruta", route)
                    .equalTo("clave_articulo", article)
                    .findAll();

            RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class)
                    .equalTo("ruta", route)
                    .notEqualTo("fecha_visita_fin", "")
                    .findAll();

            countRecharges = realm.where(RechargeInventories.class)
                    .equalTo("ruta", route)
                    .equalTo("clave_articulo", article)
                    .findAll()
                    .sum("cantidad")
                    .doubleValue();

            for(ChangesInventories changes: changesInventories){
                countChanges += (changes.getCantidad_nueva()-changes.getCantidad_anterior());
            }

            for(VisitsClients visitsClients1: visitsClients){
                amountSales += (
                        realm.where(DetailsSales.class)
                                .equalTo("visita", visitsClients1.getId())
                                .equalTo("clave_articulo", article)
                                .sum("cantidad")
                                .doubleValue()
                );
            }

            if(isInventory){
                /*amountSales = realm.where(DetailsSales.class)
                        .equalTo("ruta", route)
                        .equalTo("clave_articulo", article)
                        .sum("cantidad")
                        .intValue();*/
                amountDevolutions = getDataInventoryRoute(route, article, "devolucion");

            }else if(inDevoluting){
                /*amountSales = realm.where(DetailsSales.class)
                        .equalTo("ruta", route)
                        .equalTo("clave_articulo", article)
                        .sum("cantidad")
                        .intValue();*/

                amountDevolutions = realm.where(VisitsMovements.class)
                        .equalTo("ruta", route)
                        .equalTo("clave_articulo", article)
                        .notEqualTo("visita", nVisit)
                        .sum("piezas_devolucion")
                        .doubleValue();
            }else{
                /*amountSales = realm.where(DetailsSales.class)
                        .equalTo("ruta", route)
                        .equalTo("clave_articulo", article)
                        .notEqualTo("visita", nVisit)
                        .sum("cantidad")
                        .intValue();*/

                amountSales = 0;

                for(VisitsClients visitsClients1: visitsClients){
                    if(visitsClients1.getId() != nVisit){
                        amountSales += (
                                realm.where(DetailsSales.class)
                                        .equalTo("visita", visitsClients1.getId())
                                        .equalTo("clave_articulo", article)
                                        .sum("cantidad")
                                        .doubleValue()
                        );
                    }
                }

                amountDevolutions = getDataInventoryRoute(route, article, "devolucion");
            }

            if(inventories.size() > 0){
                //return inventories.get(0).getCantidad();

                baseApp.showLog("sales: " + amountSales);
                baseApp.showLog("devolutions: " + amountDevolutions);

                return (inventories.get(0).getCantidad_inicial() + countRecharges) - amountSales;
                //return (inventories.get(0).getCantidad_inicial() + countChanges) - amountSales - amountDevolutions;
            }else{
                return 0;
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
            ex.printStackTrace();
            return 0;
        }
    }

    public String getDataPrices(int client, int clave_integer, String field){
        BaseApp baseApp = new BaseApp(context);

        String data = "";

        try{
            realm = Realm.getDefaultInstance();

            if(client != 0 && clave_integer != 0 && !field.isEmpty()) {

                RealmResults<Prices> prices = realm.where(Prices.class).equalTo("cliente", client).equalTo("clave_articulo", clave_integer).sort("clave_articulo", Sort.DESCENDING).findAll();
                int countPrices = prices.size();

                if(countPrices > 0){

                    switch (field){
                        case "precio_credito":
                            if(prices.get(0).getPrecio_credito() != 0.0) {
                                data = String.valueOf(prices.get(0).getPrecio_credito());
                            }else{
                                data = "0.00";
                            }
                            break;
                        case "precio_contado":
                            /*if(prices.get(0).getPrecio_contado() != 0.0) {
                                data = String.valueOf(prices.get(0).getPrecio_contado());
                            }else{
                                data = "0.00";
                            }*/
                            if(prices.get(0).getPrecio() != 0.0) {
                                data = String.valueOf(prices.get(0).getPrecio());
                            }else{
                                data = "0.00";
                            }
                            break;

                        case "tasa_iva":
                            if(prices.get(0).getTasa_IVA() != 0.0) {
                                data = String.valueOf(prices.get(0).getTasa_IVA());
                            }else{
                                data = "0.00";
                            }
                            break;

                        case "tasa_IEPS":
                            if(prices.get(0).getTasa_IEPS() != 0.0) {
                                data = String.valueOf(prices.get(0).getTasa_IEPS());
                            }else{
                                data = "0.00";
                            }
                            break;

                        case "tiene_IVA":
                            data = String.valueOf(prices.get(0).getTiene_iva());
                            break;
                    }

                }else{
                    data = "";
                }

            }else{
                baseApp.showToast("Error al traer información, no puede estar vacia la clave del cliente, la clave integer o el campo requerido a buscar");
            }
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al obtener la información de un Artículo, error: " + ex);
        }

        if(data == ""){
            return "0.00";
        }else {
            return data;
        }
    }

    public double getFinalPrice(int client, int clave_integer, String field){
        BaseApp baseApp = new BaseApp(context);

        double data = 0.0, tasaIVA = 0.0;

        try{
            realm = Realm.getDefaultInstance();

            if(client != 0 && clave_integer != 0 && !field.isEmpty()) {

                RealmResults<Prices> prices = realm.where(Prices.class)
                        .equalTo("cliente", client)
                        .equalTo("clave_articulo", clave_integer)
                        .sort("clave_articulo", Sort.DESCENDING)
                        .findAll();
                int countPrices = prices.size();

                if(countPrices > 0){

                    switch (field){
                        case "precio_credito":
                            if(prices.get(0).getPrecio_credito() != 0.0) {
                                data = prices.get(0).getPrecio_credito();
                            }else{
                                data = 0.0;
                            }
                            break;
                        case "precio_contado":
                            /*if(prices.get(0).getPrecio_contado() != 0.0) {
                                data = String.valueOf(prices.get(0).getPrecio_contado());
                            }else{
                                data = "0.00";
                            }*/
                            if(prices.get(0).getPrecio() != 0.0) {
                                data = prices.get(0).getPrecio();
                            }else{
                                data = 0.0;
                            }
                            break;
                    }

                    tasaIVA = (prices.get(0).getTiene_iva() == 1 ? prices.get(0).getTasa_IVA() : 0.0);
                    data = data * (1 + (tasaIVA + prices.get(0).getTasa_IEPS()));

                }else{
                    data = 0.0;
                }

            }else{
                baseApp.showToast("Error al traer información, no puede estar vacia la clave del cliente, la clave integer o el campo requerido a buscar");
            }
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al obtener la información de un Artículo, error: " + ex);
        }

       return data;
    }

    public boolean getIsVisitFinished(int visit){
        realm = Realm.getDefaultInstance();

        RealmResults<VisitsClients> visits = realm.where(VisitsClients.class)
                .equalTo("id", visit)
                .sort("id", Sort.DESCENDING)
                .findAll();
        if(visits.size() > 0){
            if(visits.get(0).getFecha_visita_fin() != null) {
                return true;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }

    public double getDataInventoryVisit(int route, int visit, int article, String data){
        BaseApp baseApp = new BaseApp(context);

        try{
            realm = Realm.getDefaultInstance();

            RealmResults<VisitsMovements> visitMovements = realm.where(VisitsMovements.class).equalTo("ruta", route).equalTo("visita", visit).equalTo("clave_articulo", article).findAll();
            RealmResults<DetailsSales> detailsSales = realm.where(DetailsSales.class).equalTo("ruta", route).equalTo("visita", visit).equalTo("clave_articulo", article).findAll();

            if(visitMovements.size() > 0 || detailsSales.size() > 0){
                switch (data){
                    case "venta":

                        if(detailsSales.size() > 0){
                            return detailsSales.get(0).getCantidad();
                        }else{
                            return 0;
                        }

                    case "devolucion":

                        return visitMovements.get(0).getPiezas_devolucion();
                    case "cambio":

                        return visitMovements.get(0).getPiezas_cambio();
                    case "apartado":

                        return visitMovements.get(0).getPiezas_apartado();
                    default:
                        return 0;
                }
            }else{
                return 0;
            }

        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
            ex.printStackTrace();
            return 0;
        }
    }

    public boolean clientVisitedinRoute(int client, int route) {
        BaseApp baseApp = new BaseApp(context);
        boolean exist = false;

        try {
            realm = Realm.getDefaultInstance();

            RealmResults<VisitsClients> visits = realm.where(VisitsClients.class)
                    .equalTo("ruta", route)
                    .equalTo("cliente", client)
                    .sort("id", Sort.DESCENDING)
                    .findAll();

            if(visits.size() > 0) {
                if (visits.get(0).getClasificacion_visita() == 1 || visits.get(0).getClasificacion_visita() == 2 || visits.get(0).getClasificacion_visita() == 5) {
                    exist = true;
                }

            }

            return exist;

        } catch (Exception ex) {
            baseApp.showToast("Ocurrió el error: " + ex);
            return false;
        }
    }

    public double getTotalSale(int visit, String operation){
        realm = Realm.getDefaultInstance();
        BaseApp baseApp = new BaseApp(context);

        try {
            int countDetail;
            double total = 0.00;
            double totalImport = 0.00;
            double lnIVA = 0.00;
            double lnIEPS = 0.00;

            RealmResults<DetailsSales> details = realm.where(DetailsSales.class).equalTo("visita", visit).findAll();
            int countDetails = details.size();

            switch (operation) {

                case "subTotal":
                    for (int i = 0; i < countDetails; i++) {
                        totalImport += details.get(i).getImporte();
                    }
                    for (int i = 0; i < countDetails; i++) {
                        lnIVA += details.get(i).getIVA();
                    }
                    for (int i = 0; i < countDetails; i++) {
                        lnIEPS += details.get(i).getIEPS();
                    }

                    total = totalImport - lnIVA - lnIEPS;
                    break;

                case "totalIVA":
                    for (int i = 0; i < countDetails; i++) {
                        total += details.get(i).getIVA();
                    }

                    break;

                case "totalIEPS":
                    for (int i = 0; i < countDetails; i++) {
                        total += details.get(i).getIEPS();
                    }
                    break;

                case "totalImport":
                    for (int i = 0; i < countDetails; i++) {
                        total += details.get(i).getImporte();
                    }
                    break;

                default:
                    total = 0;
                    break;
            }

            //return round(total);
            return total;
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al cargar un Total, reporta el siguiente error al Dpto de Sistemas: " + ex);
            return 0;
        }
    }

    public double getCurrentCustomerBalance(int nClient){
        BaseApp baseApp = new BaseApp(context);
        double creditVisits = 0.0, moneyPaidOff = 0.0;

        // del saldo de la base de datos, sumarle los pagos pendientes ya liquidados y restarle los importes de las visitas no enviadas a crédito

        try {
            RealmResults<Clients> client = realm.where(Clients.class).equalTo("cliente", nClient).findAll();

            //Crédito de visitas sin enviar
            RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class)
                    .equalTo("pago", 0)
                    .equalTo("cliente", nClient)
                    .equalTo("metodo_pago", "Crédito")
                    .equalTo("cobrado", false)
                    .equalTo("enviado", false)
                    .findAll();

            //Dinero abonado de los créditos pendientes y de las nuevas visitas a crédito (que se saldaron en la misma ruta)
            RealmResults<VisitsPayments> visitsPayments2 = realm.where(VisitsPayments.class)
                    .equalTo("cliente", nClient)
                    .equalTo("metodo_pago", "Crédito")
                    .equalTo("cobrado", true)
                    .equalTo("enviado", false)
                    .findAll();


            if (client.size() > 0) {

                for (VisitsPayments visitsPayments1 : visitsPayments) {
                    creditVisits = creditVisits + visitsPayments1.getImporte();
                }

                for (VisitsPayments visitsPayments1 : visitsPayments2) {
                    moneyPaidOff = moneyPaidOff + visitsPayments1.getImporte_saldado();
                }

                return client.get(0).getSaldo_actual() - creditVisits + moneyPaidOff;
                //return client.get(0).getLimite_credito() + moneyPaidOff - getCurrentCustomerDebt(nClient);
            }else{
                return 0.0;
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
            return 0.0;
        }
    }

    public boolean getIsCredit(int nVisit){
        SPClass spClass = new SPClass(context);
        String sPaymentMethod;
        boolean isCredit = false;

        if(getIsVisitFinished(nVisit)) {
            RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class).equalTo("visita", nVisit).findAll();

            if (visitsPayments.size() > 0) {
                if (visitsPayments.get(0).getMetodo_pago().equals("Crédito")) {
                    return true;
                } else {
                    return false;
                }
            }
        }else{
            if(spClass.strGetSP("sTypeSale").equals("credit")){
                return true;
            }else{
                return false;
            }
        }

        return isCredit;
    }

    public int countDetailsSaleVisit(int visit, int isSent){
        int totalDetails;
        RealmResults<DetailsSales> listDetails = null;

        realm = Realm.getDefaultInstance();
        if(isSent == 1){
            listDetails = realm.where(DetailsSales.class).equalTo("visita", visit).equalTo("enviado", true).findAll();
        }else if(isSent == 0){
            listDetails = realm.where(DetailsSales.class).equalTo("visita", visit).equalTo("enviado", false).findAll();
        }else if(isSent == 2){
            listDetails = realm.where(DetailsSales.class).equalTo("visita", visit).findAll(); // no lo toma en cuenta
        }

        totalDetails = listDetails.size();

        return totalDetails;
    }

    public void uploadData(){

        BaseApp baseApp = new BaseApp(context);
        SPClass spClass = new SPClass(context);

        String stringSplitDomiciles, stringSplitPendingPayments, stringSplitVisits, stringSplitSales, stringSplitChanges, stringSplitDevolutions,
                stringSplitPayments, stringSplitClients, stringSplitReturns, stringSplitChangesInventories, stringSplitSeparateds;
        int nUser;
        boolean isResultSet;
        int countResults = 0;

        nUser = spClass.intGetSP("user");
        messagesSync =  "";

        baseApp.showLog("Comenzando a sincronizar los datos...");

        try (Realm realm = Realm.getDefaultInstance()) {

            RealmResults<VisitsClients> visits = realm.where(VisitsClients.class).equalTo("enviada", false).isNotEmpty("fecha_visita_fin").findAll();
            RealmResults<Routes> routes = realm.where(Routes.class)
                    .equalTo("enviada", false)
                    .isNotEmpty("fecha_fin").findAll();

            int countVisits = visits.size();
            int countRoutes = routes.size();

            stringSplitDomiciles = "";
            stringSplitPendingPayments = "";

            stringSplitDomiciles = generateSplitDomiciles();
            stringSplitPendingPayments = generateSplitPendingPayments();

            stringSplitVisits = ""; // reset
            stringSplitSales = ""; // reset
            stringSplitChanges = ""; // reset
            stringSplitDevolutions = ""; // reset
            stringSplitPayments = ""; // reset
            stringSplitClients = ""; // reset
            stringSplitReturns = "";
            stringSplitChangesInventories = "";

            PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.Guarda_Datos_Android ?, ?, ?, ?, ?, ?, ?, ?, ?");
            if (loComando == null) {
                baseApp.showLog("Error al Crear SP Guarda_Datos_Android");
                messagesSync += "\n\n Error al Crear SP Guarda_Datos_Android";

            } else {
                try {

                    stringSplitVisits = generateSplitVisits();
                    stringSplitSales = generateSplitSales();
                    stringSplitChanges = generateSplitChanges();
                    stringSplitDevolutions = generateSplitDevolutions();
                    stringSplitPayments = generateSplitPayments();
                    stringSplitReturns = generateSplitReturns();

                    loComando.setInt(1, nUser);
                    loComando.setString(2, stringSplitVisits);
                    loComando.setString(3, stringSplitSales);
                    loComando.setString(4, stringSplitChanges);
                    loComando.setString(5, stringSplitDevolutions);
                    loComando.setString(6, stringSplitPayments);
                    loComando.setString(7, stringSplitReturns);
                    loComando.setString(8, stringSplitDomiciles);
                    loComando.setString(9, stringSplitPendingPayments);

                    baseApp.showLog("SQL PARAMETERS 1: " + nUser);
                    baseApp.showLog("SQL PARAMETERS 2: " + stringSplitVisits);
                    baseApp.showLog("SQL PARAMETERS 3: " + stringSplitSales);
                    baseApp.showLog("SQL PARAMETERS 4: " + stringSplitChanges);
                    baseApp.showLog("SQL PARAMETERS 5: " + stringSplitDevolutions);
                    baseApp.showLog("SQL PARAMETERS 6: " + stringSplitPayments);
                    baseApp.showLog("SQL PARAMETERS 7: " + stringSplitReturns);
                    baseApp.showLog("SQL PARAMETERS 8: " + stringSplitDomiciles);
                    baseApp.showLog("SQL PARAMETERS 9: " + stringSplitPendingPayments);

                    isResultSet = loComando.execute();

                    while (true) {
                        if (isResultSet) {

                            if (countResults == 0) {
                                ResultSet Datos = loComando.getResultSet();

                                while (Datos.next()) {

                                    if (Datos.getInt("exito") == 1) {
                                        baseApp.showLog("Datos de la visitas registrados en el Servidor");
                                        messagesSync += "\n\n Datos de la visitas registrados en el Servidor";

                                        markAllDataLikeSent();
                                    } else {
                                        baseApp.showLog("Ocurrió un error al guardar los datos");
                                        messagesSync += "\n\n Ocurrió un error al guardar los datos";
                                    }

                                }

                                Datos.close();
                            }

                            if (countResults == 1) {
                                ResultSet Datos1 = loComando.getResultSet();

                                while (Datos1.next()) {

                                    VisitsClients visit = realm.where(VisitsClients.class)
                                            .equalTo("id", Datos1.getInt("folio_interno"))
                                            .findFirst();
                                    if(visit != null){
                                        realm.beginTransaction();
                                        visit.setId_db(Datos1.getInt("visita"));
                                        visit.setFactura(Datos1.getInt("factura"));
                                        realm.commitTransaction();
                                    }
                                }

                                Datos1.close();
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

                } catch (Exception ex) {
                    baseApp.showLog("Error en SP Guarda_Datos_Android, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
                    messagesSync += "\n\n Error IMPORTANTE, LOS DATOS SE PUDIERON DUPLICAR, CONTACTAR A SISTEMAS. En SP Guarda_Datos_Android, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso";
                }
            }


            //}
        }catch (Exception ex){
            messagesSync += "\n\n Error al subir los datos:  " + ex + " y se detuvo el proceso";
            baseApp.showLog("ERRROR: " + ex);
            ex.printStackTrace();
        }

        baseApp.showLog("Fin de la sincronización de datos");
    }

    public String generateSplitDomiciles(){
        String stringSplit = "";

        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<Clients> listsClients = realm.where(Clients.class)
                    .notEqualTo("latitud_nueva", 0.0)
                    .notEqualTo("longitud_nueva", 0.0)
                    .findAll();
            int countClients = listsClients.size();

            if(countClients > 0){
                for(Clients client: listsClients) {
                    stringSplit += client.getCliente() + "|"; // cliente
                    stringSplit += client.getLatitud_nueva() + "|"; // latitud_nueva
                    stringSplit += client.getLongitud_nueva() + "|"; // longitud_nueva
                    stringSplit += client.getCalle_nueva() + "|"; // calle_nueva
                    stringSplit += client.getNumero_exterior_nuevo() + "|"; // numero_exterior
                    stringSplit += client.getColonia_nueva() + "|"; // colonia_nueva
                    stringSplit += client.getCodigo_postal_nuevo() + "|"; // codigo_postal
                    stringSplit += client.getCiudad_nueva() + "Ç"; // ciudad
                }
            }
        }

        return stringSplit;
    }

    public String generateSplitPendingPayments(){
        String stringSplit = "";
        int nDeparture = 0;

        try (Realm realm = Realm.getDefaultInstance()) {

            RealmResults<VisitsPayments> visits = realm.where(VisitsPayments.class)
                    .notEqualTo("pago", 0)
                    .equalTo("enviado", false)
                    .equalTo("cobrado", true)
                    .findAll();
            int countVisits = visits.size();

            if(countVisits > 0){
                for(VisitsPayments visit: visits){
                    String isCharged;
                    if(visit.isCobrado()){ isCharged = "1"; }else{ isCharged = "0"; }

                    stringSplit += visit.getPago() + "|"; // id
                    stringSplit += isCharged + "|"; // 2 cuenta_saldada
                    stringSplit += visit.getImporte_saldado() + "|"; // 3 importe pago
                    stringSplit += visit.getFecha_cobrado() + "|"; //  // 4 fecha cobrado

                    RealmResults<Routes> routes = realm.where(Routes.class).equalTo("ruta", visit.getRuta()).findAll();
                    nDeparture = routes.get(0).getSalida();

                    stringSplit += nDeparture + "Ç"; // 4 salida
                }
            }

        }catch (Exception ex){
            messagesSync += "\n\n Error en generateSplitPendingPayments: " + ex;
            ex.printStackTrace();
        }

        return stringSplit;
    }

    public String generateSplitVisits(){
        String stringSplit = "";

        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<VisitsClients> visits = realm.where(VisitsClients.class)
                    .equalTo("enviada", false)
                    .isNotNull("fecha_visita_fin")
                    .findAll();
            int countVisits = visits.size();

            if(countVisits > 0){
                for(VisitsClients visit: visits){
                    RealmResults<Routes> routes = null;

                    /*if(visit.getRuta() != 0){
                        routes = realm.where(Routes.class).equalTo("ruta", visit.getRuta()).findAll();
                    }*/

                    routes = realm.where(Routes.class).equalTo("ruta", visit.getRuta()).findAll();

                    stringSplit += visit.getId() + "|"; // folio interno
                    stringSplit += visit.getCliente() + "|"; // 2 cliente
                    stringSplit += visit.getClasificacion_visita() + "|"; // 3 clasificacion visita

                    if(routes.size() > 0){
                        stringSplit += routes.get(0).getSalida() + "|"; // 4 salida
                    }else{
                        stringSplit += "0|"; // 4 salida
                    }

                    stringSplit += visit.getFecha_visita_inicio() + "|"; // 4 hora visita
                    stringSplit += visit.getFecha_visita_fin() + "|"; // 5 hora termino
                    stringSplit += visit.getLat_visita_inicio() + "|"; // 6 latitud
                    stringSplit += visit.getLong_visita_inicio() + "Ç"; // 7 longitud
                }
            }
        }

        return stringSplit;
    }

    public String generateSplitSales(){
        String stringSplit = "";

        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<DetailsSales> details = realm.where(DetailsSales.class)
                    .equalTo("enviado", false)
                    .findAll();
            int countDetails = details.size();
            int line =  1;

            if(countDetails > 0){
                for(DetailsSales detail: details){
                    if(realm.where(VisitsClients.class)
                            .equalTo("id", detail.getVisita())
                            .isNotNull("fecha_visita_fin")
                            .findAll().size() > 0){

                        stringSplit += detail.getVisita() + "|"; // 1 folio interno visita
                        stringSplit += line + "|"; // 2 folio interno visita
                        stringSplit += detail.getClave_articulo() + "|"; // 3 clave_articulo
                        stringSplit += detail.getCantidad() + "|"; // 4 cantidad
                        stringSplit += detail.getPrecio() + "|"; // 5 precio
                        stringSplit += detail.getTasa_IVA() + "|"; // 6 tasa_impuesto
                        stringSplit += detail.getIVA() + "|"; // 7 impuesto*/
                        stringSplit += getVisit(detail.getVisita()).isEs_credito()  + "|"; // 8 es_credito
                        stringSplit += getVisit(detail.getVisita()).isEs_remision() + "Ç"; // 9 es_remision
                        line++;
                    }
                }
            }
        }

        return stringSplit;
    }

    public String generateSplitChanges(){
        String stringSplit = "";

        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<VisitsMovements> visitMovements = realm.where(VisitsMovements.class)
                    .equalTo("enviada", false)
                    .findAll();
            int countVisits = visitMovements.size();

            if(countVisits > 0){
                for(VisitsMovements movement: visitMovements){
                    if(movement.getPiezas_cambio() != 0){
                        stringSplit += movement.getVisita() + "|"; // folio interno visita
                        stringSplit += movement.getClave_articulo() + "|"; // 2 articulo
                        stringSplit += movement.getPiezas_cambio() + "Ç"; // 3 cantidad
                    }
                }
            }
        }

        return stringSplit;
    }

    public String generateSplitDevolutions(){
        String stringSplit = "";

        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<VisitsMovements> visitMovements = realm.where(VisitsMovements.class)
                    .equalTo("enviada", false)
                    .findAll();
            int countVisits = visitMovements.size();

            if(countVisits > 0){
                for(VisitsMovements movement: visitMovements){
                    if(movement.getPiezas_devolucion() != 0) {
                        stringSplit += movement.getVisita() + "|"; // folio interno visita
                        stringSplit += movement.getClave_articulo() + "|"; // 2 articulo
                        stringSplit += movement.getPiezas_devolucion() + "Ç"; // 3 cantidad
                    }
                }
            }
        }

        return stringSplit;
    }

    public String generateSplitPayments(){
        String stringSplit = "";

        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<VisitsPayments> visits = realm.where(VisitsPayments.class)
                    .equalTo("pago", 0)
                    .equalTo("enviado", false)
                    .findAll();
            int countVisits = visits.size();

            if(countVisits > 0){
                for(VisitsPayments visit: visits){
                    String isCharged;

                    if(visit.isCobrado()){
                        if(visit.getImporte() == visit.getImporte_saldado()){
                            isCharged = "1";
                        }else{
                            isCharged = "0";
                        }
                    }else{
                        isCharged = "0";
                    }

                    stringSplit += visit.getVisita() + "|"; // folio interno visita
                    stringSplit += (isCharged.equals("0") ? visit.getImporte()-visit.getImporte_saldado() : visit.getImporte()) + "|"; // 2 importe
                    stringSplit += visit.getMetodo_pago() + "|"; // 3 metodo pago
                    stringSplit += visit.getUltimos_4_tarjeta() + "|"; // 4 metodo pago
                    stringSplit += isCharged + "|"; // 5 es cobrado
                    stringSplit += ((visit.getFecha_cobrado() == null) ? "" : visit.getFecha_cobrado()) + "Ç"; // 6 fecha cobrado
                }
            }
        }

        return stringSplit;
    }

    public String generateSplitSeparateds(){
        String stringSplit = "";

        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<VisitsMovements> visitMovements = realm.where(VisitsMovements.class)
                    .equalTo("enviada", false)
                    .findAll();
            int countVisits = visitMovements.size();

            if(countVisits > 0){
                for(VisitsMovements movement: visitMovements){
                    if(movement.getPiezas_apartado() != 0) {
                        stringSplit += movement.getVisita() + "|"; // folio interno visita
                        stringSplit += movement.getClave_articulo() + "|"; // 2 articulo
                        stringSplit += movement.getPiezas_apartado() + "|"; // 3 cantidad
                        stringSplit += movement.getFecha_apartado() + "Ç"; // 4 fecha
                    }
                }
            }
        }

        return stringSplit;
    }

    public String generateSplitReturns(){
        String stringSplit = "";
        int i;

        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<Routes> routes = realm.where(Routes.class)
                    .equalTo("enviada", false)
                    .isNotEmpty("fecha_fin").findAll();
            int countRoutes = routes.size();

            if(countRoutes > 0){
                for(Routes route: routes) {

                    i = 0;
                    RealmResults<Inventories> inventories = realm.where(Inventories.class).equalTo("ruta", route.getRuta()).findAll();

                    for(Inventories inventories1: inventories){
                        stringSplit += route.getSalida() + "|"; // salida
                        stringSplit += i + "|"; // numero_linea
                        stringSplit += inventories1.getClave_articulo() + "|"; // clave_articulo
                        stringSplit += "-" + "|"; // tipo_regreso
                        //stringSplit += inventories1.getCantidad() + "Ç"; // 3 cantidad
                        stringSplit += getAmountArticleRoute(route.getRuta(), inventories1.getClave_articulo(), false, true) + "Ç"; // 3 cantidad
                        i++;
                    }
                }
            }
        }

        return stringSplit;
    }

    public String generateSplitChangesInventory(){
        String stringSplit = "";
        int i;

        try (Realm realm = Realm.getDefaultInstance()) {

            RealmResults<Routes> routes = realm.where(Routes.class)
                    .equalTo("enviada", false)
                    .isNotEmpty("fecha_fin")
                    .findAll();

            int countRoutes = routes.size();

            if(countRoutes > 0){
                for(Routes route: routes) {

                    i = 0;
                    RealmResults<ChangesInventories> changesInventories = realm.where(ChangesInventories.class)
                            .equalTo("ruta", route.getRuta())
                            .findAll();

                    for(ChangesInventories changes: changesInventories){
                        stringSplit += route.getSalida() + "|"; // salida
                        stringSplit += changes.getClave_articulo() + "|"; // clave_articulo
                        stringSplit += changes.getCantidad_anterior() + "|"; // clave_articulo
                        stringSplit += changes.getCantidad_nueva() + "Ç"; // 3 cantidad
                    }
                }
            }
        }

        return stringSplit;
    }

    public String generateSplitPrepareDeparture(){
        String stringSplit = "";

        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<PrepareDeparture> detailsPrepareDeparture = realm.where(PrepareDeparture.class)
                    .findAll();
            int countDetails = detailsPrepareDeparture.size();

            if(countDetails > 0){
                for(PrepareDeparture detail: detailsPrepareDeparture){
                    stringSplit += detail.getClave_articulo() + "|"; // articulo
                    stringSplit += detail.getCantidad() + "Ç"; // 2 cantidad
                }
            }
        }

        return stringSplit;
    }


    public void markAllDataLikeSent() {
        BaseApp baseApp = new BaseApp(context);

        try (Realm realm = Realm.getDefaultInstance()) {

            RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class)
                    .equalTo("enviada", false)
                    .isNotNull("fecha_visita_fin")
                    .findAll();
            int countVisits = visitsClients.size();

            RealmResults<DetailsSales> detailsSales = realm.where(DetailsSales.class)
                    .equalTo("enviado", false)
                    .findAll();
            int countDetailsSales = detailsSales.size();

            RealmResults<VisitsMovements> visitMovements = realm.where(VisitsMovements.class)
                    .equalTo("enviada", false)
                    .findAll();
            int countMovements = visitMovements.size();

            RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class)
                    .equalTo("enviado", false)
                    .findAll();
            int countPayments = visitsPayments.size();

            RealmResults<Routes> routes = realm.where(Routes.class)
                    .equalTo("enviada", false)
                    .isNotEmpty("fecha_fin").findAll();
            int countRoutes = routes.size();

            RealmResults<ChangesInventories> changesInventories = realm.where(ChangesInventories.class).equalTo("enviado", false).findAll();
            int countChanges = changesInventories.size();

            if (countVisits > 0) {
                for (VisitsClients visit : visitsClients) {
                    realm.beginTransaction();
                    visit.setEnviada(true);
                    visit.setFecha_enviada(baseApp.getCurrentDateFormated());
                    realm.commitTransaction();
                }
                baseApp.showLog("Visitas sincronizadas al Servidor marcadas como enviadas");
                messagesSync += "\n\n Visitas sincronizadas al Servidor marcadas como enviadas";
            }

            if (countDetailsSales > 0) {
                for (DetailsSales detailSale : detailsSales) {
                    if(realm.where(VisitsClients.class)
                            .equalTo("id", detailSale.getVisita())
                            .isNotNull("fecha_visita_fin")
                            .findAll().size() > 0) {
                        realm.beginTransaction();
                        detailSale.setEnviado(true);
                        realm.commitTransaction();
                    }
                }

                baseApp.showLog("Detalles de Ventas sincronizados al Servidor marcadas como enviados");
                messagesSync += "\n\n Detalles de Ventas sincronizados al Servidor marcadas como enviados";
            }

            if (countMovements > 0) {
                for (VisitsMovements visitsMovements1 : visitMovements) {
                    if(realm.where(VisitsClients.class)
                            .equalTo("id", visitsMovements1.getVisita())
                            .isNotNull("fecha_visita_fin")
                            .findAll().size() > 0) {
                        realm.beginTransaction();
                        visitsMovements1.setEnviada(true);
                        realm.commitTransaction();
                    }
                }

                baseApp.showLog("Movimientos de Visitas sincronizados al Servidor marcadas como enviados");
                messagesSync += "\n\n Movimientos de Visitas sincronizados al Servidor marcadas como enviados";
            }

            if (countPayments > 0) {
                for (VisitsPayments visitsPayments1 : visitsPayments) {

                    if(visitsPayments1.isDescargado()){
                        realm.beginTransaction();
                        visitsPayments1.setEnviado(true);
                        realm.commitTransaction();
                    }else if(realm.where(VisitsClients.class)
                            .equalTo("id", visitsPayments1.getVisita())
                            .isNotNull("fecha_visita_fin")
                            .findAll().size() > 0) {
                        realm.beginTransaction();
                        visitsPayments1.setEnviado(true);
                        realm.commitTransaction();
                    }
                }

                baseApp.showLog("Movimientos de Visitas sincronizados al Servidor marcadas como enviados");
                messagesSync += "\n\n Movimientos de Visitas sincronizados al Servidor marcadas como enviados";
            }

            if (countRoutes > 0) {
                for (Routes routes1 : routes) {
                    realm.beginTransaction();
                    routes1.setEnviada(true);
                    realm.commitTransaction();
                }

                baseApp.showLog("Regresos de Rutas sincronizadas al Servidor marcadas como enviados");
                messagesSync += "\n\n Regresos de Rutas sincronizadas al Servidor marcadas como enviados";
            }

            if (countChanges > 0) {
                for (ChangesInventories change : changesInventories) {
                    realm.beginTransaction();
                    change.setEnviado(true);
                    realm.commitTransaction();
                }

                baseApp.showLog("Cambios de Inventarios sincronizadas al Servidor marcadas como enviados");
                messagesSync += "\n\n Cambios de Inventarios sincronizadas al Servidor marcadas como enviados";
            }
        } catch (Exception ex) {
            baseApp.showLog("Ocurrió el error: " + ex + " y se detuvo el proceso");
            messagesSync += "\n\nOcurrió el error: " + ex + " y se detuvo el proceso" + ", al intentar marcas los datos como enviadas";
        }
    }

    public double getTotalSaleRouteCreditPayed(int route){
        realm = Realm.getDefaultInstance();
        BaseApp baseApp = new BaseApp(context);

        try {
            int countDetail;
            double total = 0.0;
            double totalImport = 0.0;
            double lnIVA = 0.0;
            double lnIEPS = 0.0;

            RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class)
                    .equalTo("ruta", route)
                    .equalTo("metodo_pago", "Crédito")
                    .equalTo("cobrado", true)
                    .findAll();
            //RealmResults<VisitsPayments> visitsPayments2 = realm.where(VisitsPayments.class).equalTo("ruta", route).equalTo("metodo_pago", "Crédito").equalTo("cobrado", true).findAll();

            int countVisits = visitsPayments.size();
            //int countVisits2 = visitsPayments2.size();

            int contador = 1;

            if(countVisits > 0){
                for(VisitsPayments visit: visitsPayments){
                    total += visit.getImporte_saldado();
                    baseApp.showLog(contador + "" +  + visit.getImporte_saldado());
                    contador++;
                }
            }

           /*/ if(countVisits2 > 0){
                for(VisitsPayments visit: visitsPayments2){
                    total += visit.getTotal_venta();
                }
            }/

            //return round(total);***/
            return total;
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al cargar un Total, reporta el siguiente error al Dpto de Sistemas: " + ex);
            return 0;
        }
    }

    public double getTotalSaleRouteCredit(int route){
        realm = Realm.getDefaultInstance();
        BaseApp baseApp = new BaseApp(context);

        try {
            int countDetail;
            double total = 0.0;
            double totalImport = 0.0;
            double lnIVA = 0.0;
            double lnIEPS = 0.0;

            RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class)
                    .equalTo("ruta", route)
                    .equalTo("metodo_pago", "Crédito")
                    .findAll();
            int countVisits = visitsPayments.size();

            if(countVisits > 0){
                for(VisitsPayments visit: visitsPayments){
                    total += visit.getImporte() - visit.getImporte_saldado();
                }
            }

            //return round(total);
            return total;
        }catch (Exception ex){
            baseApp.showAlert("Error", "Ocurrió un error al cargar un Total, reporta el siguiente error al Dpto de Sistemas: " + ex);
            return 0;
        }
    }

    public int getNextIdVist() {
        realm = Realm.getDefaultInstance();

        realm.executeTransaction(realm -> {
            // increment index
            Number num = realm.where(VisitsClients.class).max("id");
            if (num == null) {
                nextID = 1;
            } else {
                nextID = num.intValue() + 1;
            }
        });
        return nextID;
    }

    public int getNextIdRoute() {
        realm = Realm.getDefaultInstance();

        realm.executeTransaction(realm -> {
            // increment index
            Number num = realm.where(Routes.class).max("ruta");
            if (num == null) {
                nextID = 1;
            } else {
                nextID = num.intValue() + 1;
            }
        });
        return nextID;
    }

    public int getNextIdClientNew() {
        realm = Realm.getDefaultInstance();

        realm.executeTransaction(realm -> {
            // increment index
            Number num = realm.where(NewClients.class).max("id");
            if (num == null) {
                nextID = 1;
            } else {
                nextID = num.intValue() + 1;
            }
        });
        return nextID;
    }

    public void initiateMovementsArticlesVisit(int route, int visit){
        BaseApp baseApp = new BaseApp(context);
        SPClass spClass = new SPClass(context);

        RealmResults<Articles> listArticles;
        VisitsMovements visitsMovements;
        int nUser;

        try{
            realm = Realm.getDefaultInstance();

            listArticles = realm.where(Articles.class).findAll();
            nUser = spClass.intGetSP("user");

            realm.beginTransaction();
            for(Articles articles: listArticles){
                visitsMovements = new VisitsMovements(
                        route,
                        visit,
                        articles.getClave_articulo(),
                        0,
                        0,
                        0,
                        "",
                        false,
                        nUser);

                realm.copyToRealm(visitsMovements);
            }
            realm.commitTransaction();

        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error inesperado: " + ex);
        }
    }

    public void changeMovementsArticle(int route, int visit, int article, double amountDevolution,
                                       double amountChange, double amountSeparated, String dateSeparated){

        BaseApp baseApp = new BaseApp(context);
        double pieces;
        boolean errorUpdateSaleAmount = false;

        try{
            //updateAmountDevolution(route, article, amountDevolution);
            pieces = getAmountArticleRoute(route, article, false, false);

            /*if(checkAmountSale(route, article, amountSale)){
                updateAmountSale(route, article, amountSale);
                errorUpdateSaleAmount = false;
            }else{
                baseApp.showToast("No tienes suficientes cantidades en Inventario, quedan " + pieces + " piezas.");
                errorUpdateSaleAmount = true;
            }*/

            RealmResults<VisitsMovements> movements = realm.where(VisitsMovements.class).equalTo("ruta", route).equalTo("visita", visit).equalTo("clave_articulo", article).findAll();

            realm.beginTransaction();

            if(movements.size() > 0){
                //movements.get(0).setPiezas_venta(amountSale);
                movements.get(0).setPiezas_devolucion(amountDevolution);
                movements.get(0).setPiezas_cambio(amountChange);
                movements.get(0).setPiezas_apartado(amountSeparated);

                if (!dateSeparated.equals("")) {
                    movements.get(0).setFecha_apartado(dateSeparated);
                }

                //baseApp.showLog("1- " + amountSale);
                baseApp.showLog("2- " + amountDevolution);
                baseApp.showLog("3- " + amountChange);
                baseApp.showLog("4- " + amountSeparated);

            }

            realm.commitTransaction();

            //baseApp.showSnackBar("Cambios guardados");
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error : " + ex);
        }
    }

    public void resetAmountsVisit(int route, int visit){
        BaseApp baseApp = new BaseApp(context);

        baseApp.showLog("Route: " + route + ", visit:" + visit);
        try{
            realm = Realm.getDefaultInstance();

            RealmResults<DetailsSales> detailsSales = realm.where(DetailsSales.class).equalTo("ruta", route).equalTo("visita", visit).findAll();

            for(DetailsSales detail: detailsSales){

                RealmResults<Inventories> inventories = realm.where(Inventories.class).equalTo("ruta", route).equalTo("clave_articulo", detail.getClave_articulo()).findAll();

                baseApp.showLog("Piezas Ventas: " + detail.getClave_articulo() + " , " + detail.getCantidad());

                realm.beginTransaction();
                //inventories.get(0).setCantidad(inventories.get(0).getCantidad() + (int)detail.getCantidad());
                realm.commitTransaction();

            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    public void refreshDataClient(int nClient){
        BaseApp baseApp = new BaseApp(context);
        SPClass spClass = new SPClass(context);
        int nUser = spClass.intGetSP("user");

        realm = Realm.getDefaultInstance();

        try{
            String messagesSync = "";
            boolean isResultSet;
            int countResults = 0, resultCount = 0;

            RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class)
                    .notEqualTo("pago", 0)
                    .equalTo("cobrado", false)
                    .equalTo("cliente", nClient)
                    .findAll();

            realm.beginTransaction();
            visitsPayments.deleteAllFromRealm();
            realm.commitTransaction();

            PreparedStatement loComando = baseApp.execute_SP("EXECUTE ABPollo.dbo.Consulta_Cliente_Android ?");

            if (loComando == null) {
                baseApp.showLog("Error al Crear SP Consulta_Cliente_Android");
                messagesSync += "\n\n Error al Crear SP Consulta_Cliente_Android";

            } else {
                try {

                    loComando.setInt(1, nClient); //cliente

                    isResultSet = loComando.execute();

                    while (true) {
                        if (isResultSet) {

                            if (countResults == 0) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando Clientes de Listas...");

                                while (Datos.next()) {

                                    realm.beginTransaction();
                                    Clients client = realm.where(Clients.class).equalTo("cliente", nClient).findFirst();
                                    if(client != null){
                                        client.setLimite_credito(Datos.getDouble("limite_credito"));
                                        client.setSaldo_actual(Datos.getDouble("saldo_actual"));
                                    }
                                    realm.commitTransaction();
                                }

                                Datos.close();
                            }

                            if (countResults == 1) {
                                ResultSet Datos = loComando.getResultSet();

                                baseApp.showLog("Descargando pagos pendientes...");

                                while (Datos.next()) {

                                    realm.beginTransaction();
                                    VisitsPayments visitsPayment = new VisitsPayments(
                                            Datos.getInt("pago"),
                                            Datos.getInt("visita"),
                                            Datos.getInt("cliente"),
                                            Datos.getDouble("importe"),
                                            Datos.getString("forma_pago").trim(),
                                            Datos.getString("fecha"),
                                            true,
                                            nUser);

                                    realm.copyToRealm(visitsPayment);
                                    realm.commitTransaction();
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

                } catch (Exception ex) {
                    //baseApp.showAlert("Error", "Error en SP Consulta_Cliente_Android, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
                    baseApp.showLog("Error en SP Consulta_Cliente_Android, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso");
                    messagesSync += "\n\n Error en SP Consulta_Cliente_Android id, reporta el siguiente error al departamento de Sistemas: " + ex + " y se detuvo el proceso";
                }
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
        }
    }

    public double getCurrentCustomerDebt(int nClient){
        BaseApp baseApp = new BaseApp(context);
        double debtClient = 0.0;

        // del saldo de la base de datos, sumarle los pagos pendientes ya liquidados y restarle los importes de las visitas no enviadas a crédito

        try {
            ArrayList<VisitsPayments> visitsPaymentsArrayList = new ArrayList<>();
            ArrayList<VisitsPayments> visitsPayments2ArrayList = new ArrayList<>();

            //generados con las visitas aun sin pagar
            RealmResults<VisitsPayments> visitsPayments = realm.where(VisitsPayments.class)
                    .equalTo("pago", 0)
                    .equalTo("cliente", nClient)
                    .equalTo("metodo_pago", "Crédito")
                    .equalTo("enviado", false)
                    .findAll();

            // se agregan solo lo que aún no se liquidan
            for(VisitsPayments payment: visitsPayments){
                if(payment.isCobrado()){
                    if(payment.getImporte() > payment.getImporte_saldado()){
                        visitsPaymentsArrayList.add(payment);
                    }
                }else{
                    visitsPaymentsArrayList.add(payment);
                }
            }

            //pagos pendientes de la db aun sin pagar
            RealmResults<VisitsPayments> visitsPayments2 = realm.where(VisitsPayments.class)
                    .notEqualTo("pago", 0)
                    .equalTo("cliente", nClient)
                    .equalTo("enviado", false)
                    .findAll();

            for(VisitsPayments payment: visitsPayments2){
                if(payment.isCobrado()){
                    if(payment.getImporte() > payment.getImporte_saldado()){
                        visitsPayments2ArrayList.add(payment);
                    }
                }else{
                    visitsPaymentsArrayList.add(payment);
                }
            }

            if (visitsPaymentsArrayList.size() > 0) {
                for (VisitsPayments visitsPayments1 : visitsPaymentsArrayList) {
                    debtClient = debtClient + ( visitsPayments1.getImporte() - visitsPayments1.getImporte_saldado());
                }
            }

            if (visitsPayments2ArrayList.size() > 0) {
                for (VisitsPayments visitsPayments1 : visitsPayments2ArrayList) {
                    debtClient = debtClient + ( visitsPayments1.getImporte() - visitsPayments1.getImporte_saldado());
                }
            }

            return debtClient;
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
            return 0.0;
        }
    }

    public boolean checkAmountSale(int route, int article, double amount){
        BaseApp baseApp = new BaseApp(context);

        try{
            String amountString = Double.toString(amount);

            if(amountString.substring(amountString.length() - 1).equals(".")){
                String removePoint = amountString.substring(0, amountString.length() - 1);
                amount = Double.parseDouble(removePoint);
            }

            if (amount > getAmountArticleRoute(route, article, false, false)) {
                return false;
            } else {
                return true;
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
            return false;
        }
    }

    public boolean checkAmountDevolution(int route, int article, double amount){
        BaseApp baseApp = new BaseApp(context);

        try{
            String amountString = Double.toString(amount);

            if(amountString.substring(amountString.length() - 1).equals(".")){
                String removePoint = amountString.substring(0, amountString.length() - 1);
                amount = Double.parseDouble(removePoint);
            }

            if (amount > getAmountArticleRoute(route, article, true, false)) {
                return false;
            } else {
                return true;
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error: " + ex);
            return false;
        }
    }


    public String getNameClasification(int clasification){
        String data = "";
        BaseApp baseApp = new BaseApp(context);

        realm = Realm.getDefaultInstance();

        try {
            RealmResults<VisitsClasifications> visitsClasifications = realm.where(VisitsClasifications.class).equalTo("clasificacion", clasification).findAll();
            int countPrices = visitsClasifications.size();

            if (countPrices > 0) {
                if (!visitsClasifications.get(0).getNombre_clasificacion().isEmpty()) {
                    data = String.valueOf(visitsClasifications.get(0).getNombre_clasificacion().trim());
                } else {
                    data = "Clasificación inválida";
                }
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error al obtener el nombre de la clásificación");
        }

        return data;
    }

    public boolean routeFinished(int route) {
        BaseApp baseApp = new BaseApp(context);

        try {
            realm = Realm.getDefaultInstance();

            RealmResults<Routes> routes = realm.where(Routes.class).equalTo("ruta", route).findAll();

            return !routes.get(0).getFecha_fin().equals("");
        } catch (Exception ex) {
            baseApp.showToast("Ocurrió el error: " + ex);
            return false;
        }
    }

    public void startRoute(int departure, int authorized_by, String name_authorized_by){
        SPClass spClass = new SPClass(context);
        BaseApp baseApp = new BaseApp(context);

        RealmResults<DetailsDepartures> listDetailsDepartures;
        int idRoute, nUser;
        Routes routes;
        Inventories inventories;

        try{
            realm = Realm.getDefaultInstance();

            idRoute = getNextIdRoute();
            nUser = spClass.intGetSP("user");

            realm.beginTransaction();
            routes = new Routes(
                    idRoute,
                    departure,
                    authorized_by,
                    0,
                    name_authorized_by,
                    baseApp.getCurrentDateFormated(),
                    "",
                    false,
                    nUser);
            realm.copyToRealm(routes);

            listDetailsDepartures = realm.where(DetailsDepartures.class).equalTo("salida", departure).findAll();

            for(DetailsDepartures detailsDepartures: listDetailsDepartures){
                inventories = new Inventories(
                        idRoute,
                        detailsDepartures.getClave_articulo(),
                        detailsDepartures.getNombre_articulo(),
                        detailsDepartures.getCantidad(),
                        //detailsDepartures.getCantidad(),
                        nUser);

                realm.copyToRealm(inventories);
            }

            realm.commitTransaction();

            spClass.boolSetSP("inRoute", true);
            spClass.boolSetSP("inventoryLoaded", true);
            spClass.intSetSP("idRoute", idRoute);

            baseApp.showToast("Ruta iniciada con éxito.");
            goMainActivity(departure);
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error al iniciar la Ruta.");
        }
    }

    public void finishRoute(int route, int authorizer, String name_authorizer){
        SPClass spClass = new SPClass(context);
        BaseApp baseApp = new BaseApp(context);
        int idRoute;

        try {
            realm = Realm.getDefaultInstance();

            RealmResults<Routes> routes = realm.where(Routes.class).equalTo("ruta", route).findAll();

            if(routes.size() > 0){
                realm.beginTransaction();
                routes.get(0).setAutorizado_fin(authorizer);
                routes.get(0).setFecha_fin(baseApp.getCurrentDateFormated());
                realm.commitTransaction();
            }

            idRoute = spClass.intGetSP("idRoute");
            spClass.intSetSP("idRouteTemp", idRoute);

            spClass.deleteSP("idRoute");
            spClass.deleteSP("inRoute");
            spClass.deleteSP("inventoryLoaded");

            baseApp.showToast( "Ruta terminada con éxito");
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error : " + ex);
        }
    }

    public void addNewClient(){
        SPClass spClass = new SPClass(context);
        BaseApp baseApp = new BaseApp(context);

        RealmResults<Articles> listArticles;
        int idClient, nUser;
        NewClients newClients;
        Inventories inventories;

        try{
            realm = Realm.getDefaultInstance();

            idClient = getNextIdClientNew();
            nUser = spClass.intGetSP("user");

            realm.beginTransaction();
            newClients = new NewClients(
                    idClient,
                    "",
                    "",
                    "XAXX-010101-000",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    0,
                    "",
                    "",
                    "",
                    "",
                    "",
                    0,
                    true,
                    false,
                    "");

            realm.copyToRealm(newClients);
            realm.commitTransaction();

            spClass.intSetSP("idNewClient", idClient);

            goAddClientActivity();
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error al registrar un nuevo cliente.");
        }
    }

    public void cancelAddClient(){
        SPClass spClass = new SPClass(context);
        BaseApp baseApp = new BaseApp(context);

        try {
            realm = Realm.getDefaultInstance();

            RealmResults<NewClients> newClients = realm.where(NewClients.class).
                    equalTo("id", spClass.intGetSP("idNewClient"))
                    .findAll();

            if(newClients.size() > 0){
                realm.beginTransaction();
                newClients.deleteAllFromRealm();
                realm.commitTransaction();
            }

            spClass.deleteSP("idNewClient");
            baseApp.showToast("Registro de cliente cancelado");
            ((Activity) (context)).finish();
        }catch (Exception ex){
            baseApp.showToast("Ocurrió el error : " + ex);
        }
    }

    public VisitsClients getVisit(int nVisit){
        BaseApp baseApp = new BaseApp(context);

        try{
            realm = Realm.getDefaultInstance();

            return realm.where(VisitsClients.class).equalTo("id", nVisit).findFirst();
        }catch (Exception ex){
            ex.printStackTrace();
            baseApp.showLog("Ocurrió un error al obtener una visita");
            return null;
        }
    }

    public Clients getClient(int nClient){
        BaseApp baseApp = new BaseApp(context);

        try{
            realm = Realm.getDefaultInstance();

            return realm.where(Clients.class).equalTo("cliente", nClient).findFirst();
        }catch (Exception ex){
            ex.printStackTrace();
            baseApp.showLog("Ocurrió un error al obtener un cliente");
            return null;
        }
    }

    public Articles getArticle(int nArticle){
        BaseApp baseApp = new BaseApp(context);

        try{
            realm = Realm.getDefaultInstance();

            return realm.where(Articles.class).equalTo("clave_articulo", nArticle).findFirst();
        }catch (Exception ex){
            ex.printStackTrace();
            baseApp.showLog("Ocurrió un error al obtener un cliente");
            return null;
        }
    }

    public double getAmountPrepareDeparture(int article){
        BaseApp baseApp = new BaseApp(context);

        try{
            realm = Realm.getDefaultInstance();

            PrepareDeparture prepareDeparture = realm.where(PrepareDeparture.class).equalTo("clave_articulo", article).findFirst();

            if(prepareDeparture != null){
                return prepareDeparture.getCantidad();
            }else{
                return 0;
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error interno: " + ex);
            ex.printStackTrace();

            return 0;
        }
    }

    public void printTicket(int nVisit){
        BaseApp baseApp = new BaseApp(context);
        SPClass spClass = new SPClass(context);

        String newline = "\n";

        try {
            Printooth.INSTANCE.init(context);

            VisitsClients visit = null;
            Clients client = null;
            RealmResults<DetailsSales> detailsSales;
            BranchOffices branchOffice;
            String details = "", header = "";

            realm = Realm.getDefaultInstance();

            visit = realm.where(VisitsClients.class)
                    .equalTo("id", nVisit)
                    .findFirst();

            if(visit != null){

                branchOffice = getBranchOffice(spClass.intGetSP("sucursal"));

                //baseApp.showLog("x" + visit.getFactura());

                if(branchOffice != null) {
                    client = realm.where(Clients.class).equalTo("cliente", visit.getCliente()).findFirst();

                    detailsSales = realm.where(DetailsSales.class)
                            .equalTo("visita", nVisit)
                            .findAll();

                    header = branchOffice.getDireccion() + "\n" +
                            branchOffice.getColonia() + "\n" +
                            branchOffice.getMunicipio() + "\n" +
                            "RFC: " + branchOffice.getRfc() + "\n" +
                            "Tel: " + branchOffice.getArea() + " " + branchOffice.getTelefono() +"\n" +
                            branchOffice.getEmail() + "\n" +
                            "VENTA A " + (getIsCredit(nVisit) ? "CRÉDITO" : "CONTADO") + "\n";

                    if (detailsSales.size() > 0) {
                        if (Printooth.INSTANCE.hasPairedPrinter()) {
                            printing = Printooth.INSTANCE.printer();

                            initListeners();

                            if (!Printooth.INSTANCE.hasPairedPrinter()) {
                                baseApp.showToast("Sin impresora, vincule una impresora en la sección de Configuraciones.");
                                //startActivityForResult(new Intent(this, ScanningActivity.class ),ScanningActivity.SCANNING_FOR_PRINTER);
                            } else {
                                if (printing != null) {
                                    ArrayList<Printable> al = new ArrayList<>();
                                    Resources resources = context.getResources();

                                    al.add(new ImagePrintable.Builder(R.drawable.logo_abpollo_microsmall, resources)
                                            .setAlignment(DefaultPrinter.Companion.getALIGNMENT_CENTER())
                                            .setNewLinesAfter(1)
                                            .build());

                                    al.add((new TextPrintable.Builder())
                                            .setText(header)
                                            .setAlignment(DefaultPrinter.Companion.getALIGNMENT_CENTER())
                                            .setCharacterCode(DefaultPrinter.Companion.getCHARCODE_PC1252())
                                            .setNewLinesAfter(1)
                                            .build());

                                    al.add((new TextPrintable.Builder())
                                            .setText(baseApp.getCurrentDateFormated2() + "\n" +
                                            "Factura: #" + visit.getFactura() + "\n" +
                                            "Vendedor: " + spClass.strGetSP("name").trim() + "\n" +
                                            "Cliente: " + (client != null ? client.getNombre_cliente().trim() : "Sin nombre de cliente."))
                                            .setAlignment(DefaultPrinter.Companion.getALIGNMENT_CENTER())
                                            .setCharacterCode(DefaultPrinter.Companion.getCHARCODE_PC1252())
                                            .setNewLinesAfter(1)
                                            .build());

                                    al.add((new TextPrintable.Builder())
                                            .setText("Artículos: \n" +
                                                    "Desc.    Cant.  Precio SubTotal" + newline +
                                                    "-------------------------------" + newline)
                                            .setCharacterCode(DefaultPrinter.Companion.getCHARCODE_PC1252())
                                            .setNewLinesAfter(0)
                                            .build());

                                    for (DetailsSales detail : detailsSales) {
                                        String article, amount, price, subtotal;

                                        details = "";

                                        article = detail.getNombre_articulo();
                                        amount = String.valueOf(detail.getCantidad());
                                        price = String.valueOf(baseApp.formattedNumber(detail.getPrecio()));
                                        subtotal = String.valueOf(baseApp.formattedNumber(detail.getCantidad() * detail.getPrecio()));

                                        if (article.length() > 9) {
                                            article = article.substring(0, 9);
                                        } else {
                                            article = String.format("%-9s", article);
                                        }

                                        if (amount.length() > 7) {
                                            amount = amount.substring(0, 7);
                                        } else {
                                            amount = String.format("%-7s", amount);
                                        }

                                        if (price.length() > 6) {
                                            price = price.substring(0, 6);
                                        } else {
                                            price = String.format("%-6s", price);
                                        }

                                        if (subtotal.length() > 7) {
                                            subtotal = subtotal.substring(0, 7);
                                        } else {
                                            subtotal = String.format("%-6s", subtotal);
                                        }

                                        details = article + " " + amount + "$ " + price + "$" + subtotal;

                                        al.add((new TextPrintable.Builder())
                                                .setText(details)
                                                .setAlignment(DefaultPrinter.Companion.getALIGNMENT_CENTER())
                                                .setNewLinesAfter(0)
                                                .build());

                                    }

                                    al.add((new TextPrintable.Builder())
                                            .setText("TOTAL: $" + baseApp.formattedNumber(getTotalSale(nVisit, "totalImport")))
                                            .setCharacterCode(DefaultPrinter.Companion.getCHARCODE_PC1252())
                                            .setAlignment(DefaultPrinter.Companion.getALIGNMENT_RIGHT())
                                            .setNewLinesAfter(4)
                                            .build());

                                    al.add((new TextPrintable.Builder())
                                            .setText("________________________")
                                            .setAlignment(DefaultPrinter.Companion.getALIGNMENT_CENTER())
                                            .setNewLinesAfter(1)
                                            .build());

                                    al.add((new TextPrintable.Builder())
                                            .setText("Firma")
                                            .setAlignment(DefaultPrinter.Companion.getALIGNMENT_CENTER())
                                            .setNewLinesAfter(1)
                                            .build());

                                    al.add((new TextPrintable.Builder())
                                            .setText("GRACIAS POR SU COMPRA")
                                            .setAlignment(DefaultPrinter.Companion.getALIGNMENT_CENTER())
                                            .setNewLinesAfter(2)
                                            .build());

                                    al.add((new TextPrintable.Builder())
                                            .setText(branchOffice.getSitio_web())
                                            .setAlignment(DefaultPrinter.Companion.getALIGNMENT_CENTER())
                                            .setNewLinesAfter(3)
                                            .build());

                                    if(getIsCredit(nVisit)){
                                        al.add((new TextPrintable.Builder())
                                                .setText("PAGARE\n" +
                                                        "DEBEMOS Y PAGAREMOS EN FORMA INCONDICIONAL POR ESTE PAGARE A LA ORDEN DE AB POLLO SA DE CV EN CHIHUAHUA CHIHUAHUA LA CANTIDAD DE $ " + baseApp.formattedNumber(getTotalSale(nVisit, "totalImport")) + "PESOS IMPORTE EN LETRA ( 00/100 M.N).\n" +
                                                        "ASI COMO LOS INTERESES MORATORIOS DEL 5% MENSUAL SOBRE SALDOS INSOLUTOS A PARTIR DEL VENCIMIENTO. PAGARE QUE ACEPTO(AMOS) A LA VISTA DE EN LA INTELIGENCIA DEL QUE SUSCRIBE ESTA, AUTORIZO A SUSCRIBIR TITULOS DE CREDITO EN LOS TERMINOS DEL ARTICULO 11 DE LA LEY GRAL. DE TITULOS Y OPERACIONES.\n" +
                                                        "LA FIRMA QUE APAREZCA EN CUALQUIER LUGAR DEL CUERPO DE ESTE TITULO DE CREDITO, IMPLICA SU ACEPTACION POR EL TOTAL DE LA SUMA QUE EXPRESA.\n")
                                                .setAlignment(DefaultPrinter.Companion.getALIGNMENT_CENTER())
                                                .setNewLinesAfter(1)
                                                .build());

                                        al.add((new TextPrintable.Builder())
                                                .setText("NOMBRE Y FIRMA: _____________________________")
                                                .setAlignment(DefaultPrinter.Companion.getALIGNMENT_CENTER())
                                                .setNewLinesAfter(1)
                                                .build());

                                        al.add((new TextPrintable.Builder())
                                                .setText("LUGAR Y FECHA: _________________________")
                                                .setAlignment(DefaultPrinter.Companion.getALIGNMENT_CENTER())
                                                .setNewLinesAfter(1)
                                                .build());
                                    }

                                    baseApp.showLog(al.toString());
                                    printing.print(al);
                                } else {
                                    baseApp.showToast("No hay nada que imprimir.");
                                }
                            }
                        }
                    }
                }else{
                    baseApp.showToast("Cargue los datos antes de imprimir tickets.");
                }
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error al imprimir el ticket.");
            baseApp.showLog( "Error en la impresión del ticket: " + ex);
            ex.printStackTrace();
        }
    }

    private void initListeners() {
        BaseApp baseApp = new BaseApp(context);

        if (printing!=null && printingCallback==null) {
            Log.d("xxx", "initListeners ");
            printingCallback = new PrintingCallback() {

                public void connectingWithPrinter() {
                    baseApp.showToast("Conectando con la impresora...");
                    Log.d("xxx", "Connecting");
                }
                public void printingOrderSentSuccessfully() {
                    baseApp.showToast("Ticket impreso con éxito.");
                    Log.d("xxx", "printingOrderSentSuccessfully");
                }
                public void connectionFailed(@NonNull String error) {
                    baseApp.showToast("Error de conexión con la impresora: " + error);
                    Log.d("xxx", "connectionFailed : "+error);
                }
                public void onError(@NonNull String error) {
                    baseApp.showToast("Error en la impresora: " + error);
                    Log.d("xxx", "onError : "+error);
                }
                public void onMessage(@NonNull String message) {
                    baseApp.showToast("Mensaje de la impresora: " + message);
                    Log.d("xxx", "onMessage : "+message);
                }
            };

            Printooth.INSTANCE.printer().setPrintingCallback(printingCallback);
        }
    }

    public boolean visitHaveSale(int nVisit){
        BaseApp baseApp = new BaseApp(context);

        try{
            realm = Realm.getDefaultInstance();

            return realm.where(DetailsSales.class).equalTo("visita", nVisit).findAll().size() > 0;
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error interno.");

            return false;
        }
    }

    public BranchOffices getBranchOffice(int nId){
        BaseApp baseApp = new BaseApp(context);

        try{
            realm = Realm.getDefaultInstance();

            return realm.where(BranchOffices.class).equalTo("sucursal", nId).findFirst();
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error interno.");

            return null;
        }
    }
}

