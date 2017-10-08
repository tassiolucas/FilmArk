package com.example.tassio.filmark;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.CollapsingToolbarLayout;
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

    // Declaração da variável de LOG de depuração
    private static final String TAG = MainActivity.class.getName();

    // Declaração das variáveis de informação do filme
    private TextView filmeTextInfo;
    private TextView notaTextInfo;
    private TextView anoTextInfo;
    private TextView generoTextInfo;
    private TextView estrelasTextInfo;
    private TextView plotTextInfo;
    private ImageView filmImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Método para esconder a barra de título em cima da foto do filme
        setContentView(R.layout.activity_film_detail);

        // Veiculação dos itens da janela à lógica do programa
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.main_backdrop);
        filmeTextInfo = (TextView) findViewById(R.id.filmeTextInfo);
        notaTextInfo = (TextView) findViewById(R.id.notaTextInfo);
        anoTextInfo = (TextView) findViewById(R.id.anoTextInfo);
        generoTextInfo = (TextView) findViewById(R.id.generoTextInfo);
        estrelasTextInfo = (TextView) findViewById(R.id.estrelasTextInfo);
        plotTextInfo = (TextView) findViewById(R.id.plotTextInfo);
        filmImageView = (ImageView) findViewById(R.id.imageView);

        String stringUrl = new String();

        try { // Tentativa de busca das informações passadas entre telas do JSONObject baixado
            JSONObject json = new JSONObject(getIntent().getStringExtra("json"));
            // Veiculação das informações passadas entre telas para os campos da activity_film_detail
            filmeTextInfo.setText(json.getString("name"));
            notaTextInfo.setText(json.getString("rating"));
            anoTextInfo.setText(json.getString("year"));
            generoTextInfo.setText(json.getString("genre"));
            estrelasTextInfo.setText(json.getString("stars"));
            plotTextInfo.setText(json.getString("plot"));
            stringUrl = json.getString("poster_url");
            collapsingToolbarLayout.setTitle(json.getString("name"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            // Veiculação e download da imagem URL do cataz do filme com a ImageView dos detalhes do filme pesquisado
            URL url = new URL(stringUrl);
            new DownloadImageTask((ImageView) filmImageView).execute(stringUrl);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }






}
