package com.example.jsopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tvtitle;
    ListView lvlist;
    Button duyuru;
    ArrayList<String> dataList;
    final static String URL="https://www.karabuk.edu.tr/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvtitle=findViewById(R.id.tv_title);
        lvlist=findViewById(R.id.lv_list);
        duyuru=findViewById(R.id.btn_duyurular);
        dataList=new ArrayList<>();
        duyuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataList.clear();
                tvtitle.setText("Duyurular");
                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                StringRequest request=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Document doc= Jsoup.parse(response);
                        Elements duyurular= doc.select("span.containerDuyuruBaslikLabel");
                        for(Element duyuru:duyurular){
                            dataList.add(duyuru.text());
                        }
                        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,dataList);
                        lvlist.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                        Log.e("Error",error.getMessage());
                    }
                }); queue.add(request);
            }
        });
    }
}