package com.tfm.miguel.planetaria.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.estimote.cloud_plugin.common.EstimoteCloudCredentials;
import com.estimote.internal_plugins_api.cloud.CloudCredentials;
import com.estimote.mustard.rx_goodness.rx_requirements_wizard.Requirement;
import com.estimote.mustard.rx_goodness.rx_requirements_wizard.RequirementsWizardFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tfm.miguel.planetaria.Models.Ejemplo;
import com.tfm.miguel.planetaria.R;
import com.tfm.miguel.planetaria.estimote.ProximityContentAdapter;
import com.tfm.miguel.planetaria.estimote.ProximityContentManager;

import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public class Ejercicio1Activity extends AppCompatActivity {


    private ProximityContentManager proximityContentManager;
    private ProximityContentAdapter proximityContentAdapter;
    private Button btn;
    private TextView tv;
    private DatabaseReference mDatabaseReference;

    public CloudCredentials cloudCredentials =
            new EstimoteCloudCredentials("gamificacion-proximidad-oms", "e134ca8549d5e356c06504db5b13d0e9");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Tarea 1");
        setSupportActionBar(myToolbar);


        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btn = (Button) findViewById(R.id.buttonConfirm);
        tv = (TextView) findViewById(R.id.ejemplo);
        FirebaseApp.initializeApp(this);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ejemplo ejemplo = new Ejemplo(tv.getText().toString());
                mDatabaseReference.child("ejercicios").push().setValue(ejemplo);
                finish();
            }
        });


    }

}
