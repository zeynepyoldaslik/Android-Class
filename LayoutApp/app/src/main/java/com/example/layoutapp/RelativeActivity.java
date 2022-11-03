package com.example.layoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class RelativeActivity extends AppCompatActivity {
    Button colorize,load;
    ImageView image;
    RelativeLayout relative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        colorize=findViewById(R.id.btn_colorize);
        load=findViewById(R.id.btn_loadimage);
        image=findViewById(R.id.imageButton2);
        relative=findViewById(R.id.Relative);
        colorize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relative.setBackgroundColor(Color.RED);
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageDrawable(getDrawable(R.drawable.ic_launcher_background));
            }
        });
    }
}