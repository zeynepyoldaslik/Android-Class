package com.example.callapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton call;
    EditText no;
    final static int CALLREQUEST=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call=findViewById(R.id.imageButton);
        no=findViewById(R.id.editTextPhone);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED) { call();}
                else{
                    if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.CALL_PHONE))
                        Toast.makeText(getApplicationContext(),"This application needs call permission.",Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},CALLREQUEST);
                }

            }
        });

    }

    private void call() {
        String phoneno=no.getText().toString();
        Intent callintent=new Intent(Intent.ACTION_CALL);
        callintent.setData(Uri.parse("tel"+phoneno));
        startActivity(callintent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==CALLREQUEST){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){call();}
            else{Toast.makeText(getApplicationContext(),"You have denied to call permission",Toast.LENGTH_SHORT).show();}
        }

    }
}