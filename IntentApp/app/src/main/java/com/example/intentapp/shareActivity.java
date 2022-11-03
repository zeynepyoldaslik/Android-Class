package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class shareActivity extends AppCompatActivity {
    EditText etshare;
    Button share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        etshare=findViewById(R.id.et_share);
        share=findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=etshare.getText().toString();
                Intent shareintent=new Intent(Intent.ACTION_SEND);
                shareintent.setType("plain/text");
                shareintent.putExtra(Intent.EXTRA_TEXT,text);
                startActivity(Intent.createChooser(shareintent,"Select Platform"));
            }
        });
    }
}