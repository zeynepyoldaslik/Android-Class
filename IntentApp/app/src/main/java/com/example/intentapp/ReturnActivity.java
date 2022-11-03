package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReturnActivity extends AppCompatActivity {
    Button sendback;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);
        sendback=findViewById(R.id.btn_sendback);
        name=findViewById(R.id.et_name);
        sendback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID=name.getText().toString();
                Intent returnintent=new Intent();
                returnintent.putExtra("USERNAME",ID);
                setResult(Activity.RESULT_OK,returnintent);
                finish();
            }
        });
    }
}