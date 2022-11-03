package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MassActivity extends AppCompatActivity {
    Button masscalculator;
    TextView index,result;
    EditText etweight,etheight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);
        masscalculator=findViewById(R.id.butonmass);
        etheight=findViewById(R.id.et_height);
        etweight=findViewById(R.id.et_weight);
        index=findViewById(R.id.tvmass);
        result=findViewById(R.id.tvmassinfo);

        masscalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double height=Double.parseDouble(etheight.getText().toString());
                Double weight=Double.parseDouble(etweight.getText().toString());
                Double mass=weight/Math.pow(height,2);
                index.setText("Your mass index is : "+mass);
                if(mass>25)
                    result.setText("Overweight");
                else
                    result.setText(("Normal"));
            }
        });
    }
}