package com.example.tassio.filmark;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.widget.*;

import org.json.JSONException;
import org.json.JSONObject;

import static android.app.PendingIntent.getActivity;


/**
 * Created by tassi on 10/10/2017.
 */

public class HTTPConnection extends AppCompatActivity {

    //Declaração das variáveis
    private JSONObject objectJson = new JSONObject();
    private static final String TAG = HTTPConnection.class.getName();
    public Context context;


    public JSONObject sendRequest(String entrada) {

        String input = entrada.toString();

        input = input.replace(" ", "");

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, entrada, null, new Response.Listener<JSONObject>() {

            public void onResponse(JSONObject response) {

                Log.d(TAG, response.toString());
                objectJson = response;

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, error.toString());

                VolleyLog.e("Error: ", error.getMessage());

            }

        });

        Volley.newRequestQueue(this).add(request);

        return objectJson;

    }


}
