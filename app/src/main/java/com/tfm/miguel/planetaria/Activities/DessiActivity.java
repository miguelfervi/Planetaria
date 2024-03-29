package com.tfm.miguel.planetaria.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import com.tfm.miguel.planetaria.R;

public class DessiActivity extends AppCompatActivity {

    private ImageButton btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessi);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("DESSI");
        setSupportActionBar(myToolbar);

        Window window = this.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));


        setSupportActionBar(myToolbar);
       // myToolbar.setNavigationIcon(R.drawable.bell); // Set the icon

        // Icon click listener
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btn1 = (ImageButton) findViewById(R.id.imageButton1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getIntent().hasExtra("state")){
                    if (getIntent().getStringExtra("state").equals("success")){
                        btn1.setEnabled(true);
                        Intent intent = new Intent(DessiActivity.this, Ejercicio1Activity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Disable",Toast.LENGTH_LONG).show();
                        btn1.setEnabled(false);
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Disable",Toast.LENGTH_LONG).show();
                    btn1.setEnabled(false);
                }

            }
        });
    }
}
