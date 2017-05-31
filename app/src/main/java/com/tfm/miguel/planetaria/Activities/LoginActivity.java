package com.tfm.miguel.planetaria.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.tfm.miguel.planetaria.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Switch switchLogin;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindUI();
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
            //    if(login(email,password)){
                    goToMain();
            //    }
            }
        });
    }

    private void bindUI(){

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        switchLogin = (Switch) findViewById(R.id.switchRemember);
        buttonLogin = (Button) findViewById(R.id.buttonAcceder);

    }

    private boolean login(String email, String password){
        if(!isValidEmail(email)){
            Toast.makeText(this,"El email no es válido",Toast.LENGTH_LONG).show();
            return false;
        }else if(!isValidPassword(password)) {
            Toast.makeText(this, "La contraseña no es válida", Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }

    private boolean isValidEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password){
        return  password.length()>=4;
    }

    private void goToMain(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
