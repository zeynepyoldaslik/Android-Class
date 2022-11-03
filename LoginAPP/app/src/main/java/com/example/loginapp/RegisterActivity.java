package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText email,username,pass1,pass2;
    Button btn_register;
    DBHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn_register=findViewById(R.id.button);
        email=findViewById(R.id.editTextTextEmailAddress);
        pass1=findViewById(R.id.editTextTextPassword);
        pass2=findViewById(R.id.editTextTextPassword2);
        username=findViewById(R.id.editTextTextPersonName);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=username.getText().toString();
                String mail=email.getText().toString();
                String pass=pass1.getText().toString();
                String confirm=pass2.getText().toString();
                if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(mail)&&!TextUtils.isEmpty(pass)&&!TextUtils.isEmpty(confirm)){
                    if(pass.equals(confirm)){
                        database=new DBHelper(RegisterActivity.this);
                        if(database.insertUser(name,mail,pass)){
                            Toast.makeText(RegisterActivity.this,"Your account create succesfully.",Toast.LENGTH_SHORT).show();}
                        else{Toast.makeText(RegisterActivity.this,"An error occured.",Toast.LENGTH_SHORT).show();}
                    }else{
                        Toast.makeText(RegisterActivity.this,"This passaword do not match",Toast.LENGTH_SHORT).show();} }
            }
        });
    }
}