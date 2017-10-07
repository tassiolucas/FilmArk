package com.example.tassio.filmark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private Button btSearch;
    private EditText fieldSearch;
    private RequestQueue mRequestQueue;
    private StringRequest stringRequest;
    private String url = "http://theapache64.xyz:8080/movie_db/search?keyword=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSearch = (Button) findViewById(R.id.btSearch);
        fieldSearch = (EditText) findViewById(R.id.fieldSearch);

        btSearch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                sendRequestAndPrintResponse();

                Intent it = new Intent(MainActivity.this, activity_film_detail.class);
                it.putExtra("VALOR", fieldSearch.getText().toString());
                startActivity(it);


            }

        });

    }

    private void sendRequestAndPrintResponse() {

        mRequestQueue = Volley.newRequestQueue(this);

        stringRequest = new StringRequest(Request.Method.GET, url + fieldSearch.getText().toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "Resposta : " + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,error.toString());
            }

        });

        mRequestQueue.add(stringRequest);
    }


}
