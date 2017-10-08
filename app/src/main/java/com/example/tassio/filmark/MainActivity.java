package com.example.tassio.filmark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.Serializable;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private Button btSearch;
    private EditText fieldSearch;
    private String url = "http://theapache64.xyz:8080/movie_db/search?keyword=";

    private JSONObject object = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSearch = (Button) findViewById(R.id.btSearch);
        fieldSearch = (EditText) findViewById(R.id.fieldSearch);

        btSearch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                sendRequestAndPrintResponse();

            }

        });

    }

    private void moveAct() {

        Intent it = new Intent(MainActivity.this, activity_film_detail.class);

        it.putExtra("json", object.toString());

        //it.putExtra("VALOR", stringRequest.toString());

        startActivity(it);
    }

    private void sendRequestAndPrintResponse() {

        String input = fieldSearch.getText().toString();
        input = input.replace(" ", "");

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url + input, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                try {

                    object = response.getJSONObject("data");

                    Log.d(TAG, object.toString());

                    moveAct();


                } catch (JSONException e) {
                    Log.d(TAG, e.toString());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
                VolleyLog.e("Error: ", error.getMessage());
                Toast.makeText(getApplicationContext(),
                        "Erro na pesquisa...", Toast.LENGTH_SHORT).show();
            }
        });

        // Adding request to request queue
        Volley.newRequestQueue(this).add(req);

    }



}




