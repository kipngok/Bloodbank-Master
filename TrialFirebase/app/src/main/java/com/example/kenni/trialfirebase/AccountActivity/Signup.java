package com.example.kenni.trialfirebase.AccountActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kenni.trialfirebase.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class Signup extends AppCompatActivity {
    private EditText txtemail;
    private EditText txtpass;
    private Button btnsignup;
    private TextView txtreset;
    private TextView txtlogin;
    private ProgressBar progressBar = findViewById(R.id.progressBar);

    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth=FirebaseAuth.getInstance();

        txtemail=findViewById(R.id.txtemail);
        txtpass=findViewById(R.id.txtpassword);
        txtlogin=findViewById(R.id.txtlogin);
        btnsignup=findViewById(R.id.btnsingup);
        txtreset=findViewById(R.id.txtreset);


        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Signup.this,Login.class);
                startActivity(intent);
            }
        });

        txtreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Signup.this,Resetpassword.class);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtemail.getText().toString().trim();
                String password = txtpass.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "please enter the password", Toast.LENGTH_SHORT).show();
                return;
                }

                if (password.length() <6){
                    Toast.makeText(getApplicationContext(),"Password is too short",Toast.LENGTH_SHORT).show();
                    return;
                }


                progressBar.setVisibility(onCreateView().VISIBLE);
            }
        });

    }
}
