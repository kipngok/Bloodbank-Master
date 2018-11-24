package com.example.kenni.blooddonation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private TextView txtregister;
    private Button btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlogin=findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Home.class);
                startActivity(intent);
            }
        });

        txtregister=findViewById(R.id.txtregister);
         txtregister.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent x=new Intent(Login.this,Register.class);
                 startActivity(x);
             }
         });
    }
}
