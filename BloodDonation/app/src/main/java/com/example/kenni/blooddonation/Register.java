package com.example.kenni.blooddonation;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DatabaseHelper db;
 private TextView txtlogin;
 EditText txtfname,txtlname,txtpassword,txtconfirmpassword, txtemail;
 Button btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db=new DatabaseHelper(this);
        txtfname=findViewById(R.id.txtfname);
        txtlname=findViewById(R.id.txtlname);
        txtemail=findViewById(R.id.txtemail);
        txtpassword=findViewById(R.id.txtpassword);
        txtconfirmpassword=findViewById(R.id.txtconfirmpassword);
        btnregister=findViewById(R.id.btnregister);


        txtlogin=findViewById(R.id.txtlogin);
        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y=new Intent(Register.this,Login.class);
                startActivity(y);
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname=txtfname.getText().toString();
                String lname=txtlname.getText().toString();
                String email=txtemail.getText().toString();
                String password=txtpassword.getText().toString();
                String cpassword=txtconfirmpassword.getText().toString();

                if (fname.equals("")||lname.equals("")||email.equals("")||password.equals("")||cpassword.equals("")){
                    Toast.makeText(getApplicationContext(),"Field empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (password.equals(cpassword)){
                        boolean chkemail = db.chkemail(email);
                        if (chkemail== true){}
                        Boolean insert = db.insert( fname,lname, email, password, cpassword);
                        if (insert==true){
                            Toast.makeText(getApplicationContext(),"Registered succesfully",Toast.LENGTH_SHORT).show();
                        }
                    }

                    else{
                        Toast.makeText(getApplicationContext(),"Email already exists",Toast.LENGTH_SHORT).show();
                    }

                }
                Toast.makeText(getApplicationContext(),"password do not match",Toast.LENGTH_SHORT).show();


            }
        });





    }
}
