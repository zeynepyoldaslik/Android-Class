package com.example.hesapmakinasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText first,second;
    Button sub,add,div,multip;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        int firstnumber=Integer.parseInt(first.getText().toString());
        int secondnumber=Integer.parseInt(second.getText().toString());
        int result=0;

        switch(ID){
            case R.id.add: result=firstnumber+secondnumber; break;
            case R.id.sub: result=firstnumber-secondnumber; break;
            case R.id.div: result=firstnumber/secondnumber; break;
            case R.id.multiple: result=firstnumber*secondnumber; break;
        }
        text.setText("Sonuc : "+result);
    }
}