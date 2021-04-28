package com.mds.ventasabpollo.activities;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mazenrashed.printooth.Printooth;
import com.mazenrashed.printooth.ui.ScanningActivity;
import com.mazenrashed.printooth.utilities.Printing;
import com.mazenrashed.printooth.utilities.PrintingCallback;
import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.FunctionsApp;
import com.mds.ventasabpollo.application.SPClass;

import java.util.Calendar;

public class ConfigurationActivity extends AppCompatActivity {

    SPClass spClass = new SPClass(this);
    BaseApp baseApp = new BaseApp(this);
    FunctionsApp functionsapp = new FunctionsApp(this);
    TimePicker timePicker;
    AlarmManager am;
    Intent i;

    LinearLayout layoutHour;
    Switch switchAutoLoadData, switchConnection;

    private Printing printing = null;
    PrintingCallback printingCallback=null;

    TextView txtViewPrinter;
    Button btnPiarUnpair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        getSupportActionBar().hide();

        layoutHour = findViewById(R.id.layoutHour);
        switchAutoLoadData = findViewById(R.id.switchAutoLoadData);
        switchConnection = findViewById(R.id.switchConnection);
        timePicker = findViewById(R.id.timePicker);

        txtViewPrinter = findViewById(R.id.txtViewPrinter);
        btnPiarUnpair = findViewById(R.id.btnPiarUnpair);

        Printooth.INSTANCE.init(this);

        switchConnection.setChecked(spClass.boolGetSP("onlineConnection"));

        switchConnection.setOnCheckedChangeListener((buttonView, isChecked) -> {
            spClass.boolSetSP("onlineConnection", isChecked);

            if(!isChecked){
                baseApp.showToast("Online desactivado, no olvides sincronizar los datos.");
            }
        });

        if (Printooth.INSTANCE.hasPairedPrinter())
            printing = Printooth.INSTANCE.printer();

        initViewsPrinter();
        initListeners();

        btnPiarUnpair.setOnClickListener(v->{
            if (Printooth.INSTANCE.hasPairedPrinter()) {Printooth.INSTANCE.removeCurrentPrinter();
            } else {
                startActivityForResult(new Intent(this, ScanningActivity.class ),ScanningActivity.SCANNING_FOR_PRINTER);
            }

            initViewsPrinter();
        });
        baseApp.darkenStatusBar(this, Color.WHITE);
    }

    private void initViewsPrinter() {
        if (Printooth.INSTANCE.getPairedPrinter()!=null){
            txtViewPrinter.setText(
                    (Printooth.INSTANCE.hasPairedPrinter())?("Impresora vinculada: "+ Printooth.INSTANCE.getPairedPrinter().getName()):"Impresora vinculada: ninguna");

            btnPiarUnpair.setText(
                    (Printooth.INSTANCE.hasPairedPrinter())?("Desvincular "+ Printooth.INSTANCE.getPairedPrinter().getName()):"Vincular impresora");
          }else{
            txtViewPrinter.setText("Impresora vinculada: ninguna");
            btnPiarUnpair.setText("Vincular impresora");
        }
    }

    private void initListeners() {
        if (printing!=null && printingCallback==null) {
            Log.d("xxx", "initListeners ");
            printingCallback = new PrintingCallback() {

                public void connectingWithPrinter() {
                    Toast.makeText(getApplicationContext(), "Conectando con la impresora", Toast.LENGTH_SHORT).show();
                    Log.d("xxx", "Connecting");
                }
                public void printingOrderSentSuccessfully() {
                    Toast.makeText(getApplicationContext(), "Ticket impreso con éxito", Toast.LENGTH_SHORT).show();
                    Log.d("xxx", "printingOrderSentSuccessfully");
                }
                public void connectionFailed(@NonNull String error) {
                    Toast.makeText(getApplicationContext(), "Error en la conexión de la impresa :"+error, Toast.LENGTH_SHORT).show();
                    Log.d("xxx", "connectionFailed : "+error);
                }
                public void onError(@NonNull String error) {
                    Toast.makeText(getApplicationContext(), "Error en la impresora :"+error, Toast.LENGTH_SHORT).show();
                    Log.d("xxx", "onError : "+error);
                }
                public void onMessage(@NonNull String message) {
                    Toast.makeText(getApplicationContext(), "Mensaje de la impresora :" +message, Toast.LENGTH_SHORT).show();
                    Log.d("xxx", "onMessage : "+message);
                }
            };

            Printooth.INSTANCE.printer().setPrintingCallback(printingCallback);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("xxx", "onActivityResult "+requestCode);

        if (requestCode == ScanningActivity.SCANNING_FOR_PRINTER && resultCode == Activity.RESULT_OK) {
            initListeners();
            //printSomePrintable();
        }
        initViewsPrinter();
    }

    public void onResume() {
        super.onResume();
        initViewsPrinter();
    }
}