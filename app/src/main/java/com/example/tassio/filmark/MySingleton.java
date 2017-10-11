package com.example.tassio.filmark;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by tassi on 11/10/2017.
 */

public class MySingleton {

    private static final String TAG = MainActivity.class.getName();

    private static MySingleton mainInstance;
    private RequestQueue mainRequestQueue;

    Context context;

    public MySingleton(Context context) {
        this.context = context;
        mainRequestQueue = getRequestQueue();
    }

    public static synchronized MySingleton getInstance(Context context) {
        if (mainInstance == null) {
            mainInstance = new MySingleton(context);
        }
        return mainInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mainRequestQueue == null) {
            mainRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return mainRequestQueue;
    }

    public <T> void addToResquestQueue(Request<T> request, String tag){
        request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(request);
    }

    public <T> void addToRequestQueue(Request<T> request) {
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    public void cancelPendingRequests(Object tag) {
        if (mainRequestQueue != null) {
            mainRequestQueue.cancelAll(tag);
        }
    }





}
