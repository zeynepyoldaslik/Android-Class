package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {
    EditText first,second;
    Button sub,add,div,multip;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        first=findViewById(R.id.et_firstnumber);
        second=findViewById(R.id.et_secondnum);
        sub=findViewById(R.id.sub);
        add=findViewById(R.id.add);
        div=findViewById(R.id.div);
        multip=findViewById(R.id.multiple);
        text=findViewById(R.id.textView3);
    }

    public void ButtonClick(View w){
        int ID=w.getId();
        String firstt=first.getText().toString();
        String secondd=second.getText().toString();
        if(!TextUtils.isEmpty(firstt) && !TextUtils.isEmpty(secondd)){
        double firstnumber=Double.parseDouble(firstt);
        double secondnumber=Double.parseDouble(secondd);
        double result=0.0;

        switch(ID){
            case R.id.add: result=firstnumber+secondnumber; break;
            case R.id.sub: result=firstnumber-secondnumber; break;
            case R.id.div: result=firstnumber/secondnumber; break;
            case R.id.multiple: result=firstnumber*secondnumber; break;
        }
        text.setText("Sonuc : "+result);}
        else
            Toast.makeText(getApplicationContext(),"You did not enter two numbers.",Toast.LENGTH_SHORT).show();
    }
}