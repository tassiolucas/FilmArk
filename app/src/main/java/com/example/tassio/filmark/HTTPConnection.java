package com.example.tassio.filmark;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

    private JSONObject objectResposta = new JSONObject();

    private static final String TAG = HTTPConnection.class.getName();
    public Context context;

    private String keyApi = "5c03f6eb91d5afc669745ebc92817eab";
    private String enderecoApi = "https://api.themoviedb.org/3/";
    private String tokenApi;

    private String entradaRequest;


    public String sendRequestToken() {
        String endAutentication = "authentication/token/new?api_key=" + keyApi;

        objectResposta = request(endAutentication);

        try {
            tokenApi = objectResposta.getJSONObject("request_token").getString();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "Error sendRequestToken: " + e);
        }

        return tokenApi;
    }

    public String sendRequestSession(String token) {

        String endSession = "authentication/session/new?api_key=" + keyApi + "&request_token=" + tokenApi ;

        objectJson = request(endSession);

        try {
            String siteAutenticação = "https://www.themoviedb.org/authenticate/";

            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(siteAutenticação));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                // Chrome browser presumably not installed so allow user to choose instead
                intent.setPackage(null);
                context.startActivity(intent);
            }


        }catch (JSONObject e) {
            Log.d(TAG, e);
        }

        // Verificar tentativa de abertura de link.





    }

    private JSONObject request(String entrada) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, enderecoApi+ entrada, null, new Response.Listener<JSONObject>() {

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
