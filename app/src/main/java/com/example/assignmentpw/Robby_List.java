package com.example.assignmentpw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.example.assignmentpw.adapter.Adapter;
import com.example.assignmentpw.model.Model;

public class Robby_List extends AppCompatActivity {

    //init apk in url
    private static final String url="https://my-json-server.typicode.com/easygautam/data/users";

    //RecycleView
    RecyclerView recyclerView;

    //Back Button
    private ImageButton btnBack;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Robby_List.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robby_list);


        btnBack=findViewById(R.id.backbtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Robby_List.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



        //connecting With RecycleView
        recyclerView=findViewById(R.id.robbyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        processData();


    }

    private void processData() {
        StringRequest request =new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder=new GsonBuilder();
                Gson gson=builder.create();
                Model data[]= gson.fromJson(response, Model[].class);

                Adapter adapter=new Adapter(data);
                recyclerView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Robby_List.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
}