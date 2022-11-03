package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class linkActivity extends AppCompatActivity {
    TextView twlink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);
        twlink=findViewById(R.id.tw_link);
        twlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent linkintent =new Intent(Intent.ACTION_VIEW);
                linkintent.setData(Uri.parse("https://www.karabuk.edu.tr"));
                startActivity(linkintent);
            }
        });
    }
}