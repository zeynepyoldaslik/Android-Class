package com.example.intentapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button sms,mail,link,share,rtrn;
    TextView txt;
    final static int request=1200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sms=findViewById(R.id.btn_sms);
        mail=findViewById(R.id.btn_mail);
        link=findViewById(R.id.btn_link);
        share=findViewById(R.id.btn_share);
        rtrn=findViewById(R.id.btn_return);
        txt=findViewById(R.id.textView);
        sms.setOnClickListener(this);
        mail.setOnClickListener(this);
        link.setOnClickListener(this);
        share.setOnClickListener(this);
        rtrn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        int ID=view.getId();
        Intent i;
        switch(ID){
            case R.id.btn_sms:
                i=new Intent(MainActivity.this,smsActivity.class);
                startActivity(i); break;
            case R.id.btn_link:
                i=new Intent(MainActivity.this,linkActivity.class);
                startActivity(i); break;
            case R.id.btn_mail:
                i=new Intent(MainActivity.this,mailActivity.class);
                startActivity(i); break;
            case R.id.btn_share:
                i=new Intent(MainActivity.this,shareActivity.class);
                startActivity(i); break;
            case R.id.btn_return:
                i=new Intent(MainActivity.this,ReturnActivity.class);
                startActivityForResult(i,1200); break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==request) {
            if(resultCode== Activity.RESULT_OK){
                String name=data.getStringExtra("USERNAME");
                txt.setText(name);
            }
        }
    }
}