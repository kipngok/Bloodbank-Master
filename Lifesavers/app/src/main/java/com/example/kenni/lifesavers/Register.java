package com.example.kenni.lifesavers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    EditText txtuname,txtpass,txtconfirmpass,txtemail;
    TextView txtlogin;
    Button btnregi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtuname=findViewById(R.id.txtusername);
        txtemail=findViewById(R.id.txtemail);
        txtpass=findViewById(R.id.txtpass);
        txtconfirmpass=findViewById(R.id.txtconfirmpass);

        btnregi=findViewById(R.id.btnregi);
        txtlogin=findViewById(R.id.txtlogin);

        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register.this,Login.class);
                startActivity(intent);

            }
        });
    }




    }

