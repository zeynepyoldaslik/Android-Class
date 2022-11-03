package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mailActivity extends AppCompatActivity {
    EditText mail,subject,adress;
    Button sendmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        mail=findViewById(R.id.et_mail);
        subject=findViewById(R.id.et_subject);
        adress=findViewById(R.id.et_mailadress);
        sendmail=findViewById(R.id.sendmail);
        sendmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=adress.getText().toString();
                String sub=subject.getText().toString();
                String text=mail.getText().toString();
                Intent mailintent=new Intent(Intent.ACTION_SEND);
                mailintent.setType("message/rfc822");
                mailintent.putExtra(Intent.EXTRA_EMAIL,new String[] {email});
                mailintent.putExtra(Intent.EXTRA_SUBJECT,sub);
                mailintent.putExtra(Intent.EXTRA_TEXT,text);
                startActivity(mailintent);
            }
        });
    }
}