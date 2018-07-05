package com.tfm.miguel.planetaria.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.estimote.cloud_plugin.common.EstimoteCloudCredentials;
import com.estimote.internal_plugins_api.cloud.CloudCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tfm.miguel.planetaria.Models.Pregunta;
import com.tfm.miguel.planetaria.R;
import com.tfm.miguel.planetaria.estimote.ProximityContentAdapter;
import com.tfm.miguel.planetaria.estimote.ProximityContentManager;

public class Ejercicio1Activity extends AppCompatActivity {


    private ProximityContentManager proximityContentManager;
    private ProximityContentAdapter proximityContentAdapter;
    private Button btn;
    private TextView tv,respuesta;
    private RadioButton r1,r2,r3;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference pregunta = ref.child("ejercicios");

    //DatabaseReference myRef = database.getReference("message");

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

        FirebaseApp.initializeApp(this);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        btn = (Button) findViewById(R.id.buttonConfirm);
        tv = (TextView) findViewById(R.id.ejemplo);
        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        respuesta = (TextView) findViewById(R.id.respuesta);


        readFromDataBase();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeDatabase();
            }
        });


    }

    public void readFromDataBase(){

        pregunta.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Pregunta pregunta = dataSnapshot.getValue(Pregunta.class);
                tv.setText(pregunta.pregunta);
                r1.setText(pregunta.respuesta1);
                r2.setText(pregunta.respuesta2);
                r3.setText(pregunta.respuesta3);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }

    public void checkAnswer (){
        pregunta.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Pregunta pregunta = dataSnapshot.getValue(Pregunta.class);
                if(r1.isChecked()){
                     respuesta.setText("Correcto");
                 } else {
                    respuesta.setText("Incorrecto");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }
    public void writeDatabase (){
        mDatabaseReference.child("respuestas").push().setValue(r1.isChecked());
        checkAnswer();
    }

}
