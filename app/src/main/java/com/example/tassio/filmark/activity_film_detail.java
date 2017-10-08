package com.example.tassio.filmark;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class activity_film_detail extends AppCompatActivity implements Serializable {

    private static final String TAG = MainActivity.class.getName();

    private TextView filmeTextView;
    private TextView filmeTextInfo;
    private TextView notaTextView;
    private TextView notaTextInfo;
    private TextView anoTextView;
    private TextView anoTextInfo;
    private TextView generoTextView;
    private TextView generoTextInfo;
    private TextView estrelasTextView;
    private TextView estrelasTextInfo;
    private TextView plotTextView;
    private TextView plotTextInfo;
    private ImageView filmImageView;


    private List<String> request = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_film_detail);

        filmeTextInfo = (TextView) findViewById(R.id.filmeTextInfo);
        notaTextInfo = (TextView) findViewById(R.id.notaTextInfo);
        anoTextInfo = (TextView) findViewById(R.id.anoTextInfo);
        generoTextInfo = (TextView) findViewById(R.id.generoTextInfo);
        estrelasTextInfo = (TextView) findViewById(R.id.estrelasTextInfo);
        plotTextInfo = (TextView) findViewById(R.id.plotTextInfo);
        filmImageView = (ImageView) findViewById(R.id.imageView);

        String stringUrl = new String();

        Intent intent = getIntent();


        try {
            JSONObject json = new JSONObject(getIntent().getStringExtra("json"));
            System.out.println("DEU CERTO: " + json);



            filmeTextInfo.setText(json.getString("name"));
            notaTextInfo.setText(json.getString("rating"));
            anoTextInfo.setText(json.getString("year"));
            generoTextInfo.setText(json.getString("genre"));
            estrelasTextInfo.setText(json.getString("stars"));
            plotTextInfo.setText(json.getString("plot"));
            stringUrl = json.getString("poster_url");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            URL url = new URL(stringUrl);
            new DownloadImageTask((ImageView) filmImageView).execute(stringUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }




        // System.out.println("DEU CERTO!!! " + json);



    }






}
