package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText user,pass;
    TextView register;
    Button login;
    DBHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=findViewById(R.id.et_login);
        login=findViewById(R.id.btn_login);
        pass=findViewById(R.id.et_pass);
        register=findViewById(R.id.tv_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=user.getText().toString();
                String userpass=pass.getText().toString();
                if(!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(userpass)){
                    database=new DBHelper(LoginActivity.this);
                    String returnPass=database.findUser(username);
                    if(userpass.equals(returnPass)){
                        Intent i=new Intent(LoginActivity.this,WelcomeActivity.class);
                        i.putExtra("USERNAME",username);
                        startActivity(i);
                    }else{
                        Toast.makeText(LoginActivity.this,"This passaword do not match",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}