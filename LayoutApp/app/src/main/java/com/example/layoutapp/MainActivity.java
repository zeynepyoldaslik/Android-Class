package com.example.layoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button lineer,relative,table,grid,frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineer=findViewById(R.id.btn_lineer);
        relative=findViewById(R.id.btn_relative);
        frame=findViewById(R.id.btn_frame);
        lineer.setOnClickListener(this);
        relative.setOnClickListener(this);
        frame.setOnClickListener(this);
    }
    public void onClick(View view){
        int id=view.getId();
        Intent i;
        switch (id){
            case R.id.btn_lineer:
                i =new Intent(MainActivity.this,LineerActivity.class);
                startActivity(i);
                break;
            case R.id.btn_relative:
                i =new Intent(MainActivity.this,RelativeActivity.class);
                startActivity(i);
                break;
            case R.id.btn_frame:
                i =new Intent(MainActivity.this,FrameActivity.class);
                startActivity(i);
                break;
        }
    }
}