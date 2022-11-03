package com.example.layoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LineerActivity extends AppCompatActivity {
    EditText user,passaword;
    Button login;
    String realUserName="Zeynep";
    String pass="123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lineer);
        user=findViewById(R.id.et_id);
        passaword=findViewById(R.id.et_pass);
        login=findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=user.getText().toString();
                String userpass=passaword.getText().toString();
                if(username.equals(realUserName)&&userpass.equals(pass)){
                    Toast.makeText(getApplicationContext(),"Your have logined.",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"Your passaword is wrong.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}