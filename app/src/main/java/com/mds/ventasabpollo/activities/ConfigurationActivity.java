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

        switchConnection.setChecked(spClass.boolGetSP("onlineConnection"));
        switchConnection.setOnCheckedChangeListener((buttonView, isChecked) -> {
            spClass.boolSetSP("onlineConnection", isChecked);

            if(!isChecked){
                baseApp.showToast("Online desactivado, no olvides sincronizar los datos.");
            }
        });

        baseApp.darkenStatusBar(this, Color.WHITE);
    }

    public void onResume() {
        super.onResume();
    }
}