package com.example.tassio.filmark;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONObject;

/**
 * Created by tassi on 10/10/2017.
 */

public class HTTPConnection extends Application {

    //Declaração das variáveis
    private static final String TAG = HTTPConnection.class.getName();
    private String keyApi = "5c03f6eb91d5afc669745ebc92817eab";
    private String enderecoApi = "https://api.themoviedb.org/3/";
    private String enderecoApiAlternativo = "http://theapache64.xyz:8080/movie_db/search?keyword=";

    public void sendSearchMovie(final Context context, String entradaSearch, final MainActivity.SearchCallBack callBack) {

        String input = entradaSearch;
        input = input.replace(" ", "%20");

        String endPointSearch = enderecoApi + "search/movie?api_key=" + keyApi + "&language=pt-BR&query=" + input + "&page=1&include_adult=true";

        request(endPointSearch, context, new ServerCallBack() {
            public void onSuccess(JSONObject result) {
                callBack.onAnswer(result);
            }
        });

    }

    public void sendSearchDetailsMovie(final Context context, String entradaSearch, final activity_film_detail.SearchCallBack callBack) {
        String input = entradaSearch;

        input = input.replace(" ", "%20");

        String endPointSearch = enderecoApiAlternativo + input;

        request(endPointSearch, context, new ServerCallBack() {
            @Override
            public void onSuccess(JSONObject result) {
                callBack.onAnswer(result);
            }
        });

    }

    private void request(String endPoint, Context context, final ServerCallBack callBack) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, endPoint, null, new Response.Listener<JSONObject>() {

            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, error.toString());
                VolleyLog.e("Error: " + error.getMessage());
            }
        });

        MySingleton.getInstance(context).addToRequestQueue(request);

    }

    public interface ServerCallBack {
        void onSuccess(JSONObject result);
    }

}
