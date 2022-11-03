package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AgeActivity extends AppCompatActivity {
    Button btnage;
    EditText etbirthy;
    TextView tvage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        btnage=findViewById(R.id.buttonage);
        etbirthy=findViewById(R.id.et_birthyear);
        tvage=findViewById(R.id.tv_age);

        btnage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String birthyear=etbirthy.getText().toString();
                int age=0;
                if(!TextUtils.isEmpty(birthyear)){
                    int strbirthyear=Integer.parseInt(birthyear);
                    int currentyear= Calendar.getInstance().get(Calendar.YEAR);
                    if(currentyear>=strbirthyear)
                    age=currentyear-strbirthyear;
                     else Toast.makeText(getApplicationContext(),"You enter a wrong birth year",Toast.LENGTH_SHORT).show();
                    tvage.setText("Your age is :" + age); }
            }
        });
        }
}
