package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class smsActivity extends AppCompatActivity{
    Button send;
    EditText no,text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        send=findViewById(R.id.send);
        no=findViewById(R.id.et_smsno);
        text=findViewById(R.id.et_text);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneno=no.getText().toString();
                String smstext=text.getText().toString();
                Intent smsintent=new Intent(Intent.ACTION_SENDTO);
                smsintent.setData(Uri.parse("smsto:"+phoneno));
                smsintent.putExtra(Intent.EXTRA_TEXT,smstext);
                startActivity(smsintent);
            }
        });
    }
}