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

import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.activities.AboutActivity;
import com.mds.ventasabpollo.activities.AccountActivity;
import com.mds.ventasabpollo.activities.ChangeConnectionActivity;
import com.mds.ventasabpollo.activities.ConfigurationActivity;
import com.mds.ventasabpollo.activities.LoginActivity;
import com.mds.ventasabpollo.activities.MainActivity;
import com.mds.ventasabpollo.activities.RestoreDBActivity;

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

}

