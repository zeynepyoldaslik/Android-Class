package com.example.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button strt,stp;
    Intent service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        strt=findViewById(R.id.btn_start);
        stp=findViewById(R.id.btn_stop);
        strt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service=new Intent(MainActivity.this,SoundIntentService.class);
                startService(service);
            }
        });
        stp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(service);
            }
        });
    }
}