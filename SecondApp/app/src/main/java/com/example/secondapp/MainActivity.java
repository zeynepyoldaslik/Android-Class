package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnage,btncalculator,btnmass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncalculator=findViewById(R.id.btn_calculate);
        btnage=findViewById(R.id.btn_age);
        btnmass=findViewById(R.id.btn_mass);
        btnmass.setOnClickListener(this);
        btnage.setOnClickListener(this);
        btncalculator.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        int id=view.getId();
        Intent i;
        switch(id){
            case R.id.btn_age:
                i=new Intent(MainActivity.this,AgeActivity.class);
                startActivity(i);  break;
            case R.id.btn_calculate:
                i=new Intent(MainActivity.this,CalculatorActivity.class);
                startActivity(i);  break;
            case R.id.btn_mass:
                i=new Intent(MainActivity.this,MassActivity.class);
                startActivity(i);  break;
        }
    }
}