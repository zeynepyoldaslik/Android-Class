package com.example.jsonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    ListView comp;
    ImageView logo;
    final static String URL="https://web.karabuk.edu.tr/yasinortakci/dokumanlar/web_dokumanlari/recyle.json";
    String [] imageURLs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comp=findViewById(R.id.lv_comp);
        logo=findViewById(R.id.iv_logo);
        RequestQueue queue= Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("Companies");
                    int length=jsonArray.length();
                    String [] companyInfo=new String[length];
                     imageURLs=new String[length];
                    for(int i=0;i<length;i++){
                        JSONObject company=jsonArray.getJSONObject(i);
                        companyInfo[i]=company.getString("Heading")+"-"+company.getString("Detail");
                        imageURLs[i]=company.getString("ImageURL");
                    }
                    ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,companyInfo);
                    comp.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                Log.e("error",error.getMessage());
            }
        });
    queue.add(request);
    comp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Picasso.get().load(imageURLs[i]).into(logo);
        }
    });
    }
}