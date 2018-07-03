package com.tfm.miguel.planetaria.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;

import com.estimote.cloud_plugin.common.EstimoteCloudCredentials;
import com.estimote.internal_plugins_api.cloud.CloudCredentials;
import com.estimote.mustard.rx_goodness.rx_requirements_wizard.Requirement;
import com.estimote.mustard.rx_goodness.rx_requirements_wizard.RequirementsWizardFactory;
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


            proximityContentAdapter = new ProximityContentAdapter(this);
            GridView gridView = findViewById(R.id.gridView);
            gridView.setAdapter(proximityContentAdapter);


            RequirementsWizardFactory
                    .createEstimoteRequirementsWizard()
                    .fulfillRequirements(this,
                            new Function0<Unit>() {
                                @Override
                                public Unit invoke() {
                                    Log.d("app", "requirements fulfilled");
                                    startProximityContentManager();
                                    return null;
                                }
                            },
                            new Function1<List<? extends Requirement>, Unit>() {
                                @Override
                                public Unit invoke(List<? extends Requirement> requirements) {
                                    Log.e("app", "requirements missing: " + requirements);
                                    return null;
                                }
                            },
                            new Function1<Throwable, Unit>() {
                                @Override
                                public Unit invoke(Throwable throwable) {
                                    Log.e("app", "requirements error: " + throwable);
                                    return null;
                                }
                            });
        }

        private void startProximityContentManager() {
            proximityContentManager = new ProximityContentManager(this, proximityContentAdapter, cloudCredentials);
            proximityContentManager.start();
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            if (proximityContentManager != null)
                proximityContentManager.stop();
        }


}
