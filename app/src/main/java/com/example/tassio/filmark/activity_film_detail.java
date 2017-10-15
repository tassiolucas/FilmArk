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

import com.squareup.picasso.Picasso;

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

        String stringUrl;

        try { // Tentativa de busca das informações passadas entre telas do JSONObject baixado

            Intent it = getIntent();

            Film filmDetail = (Film) it.getSerializableExtra("jsonFilm");

            filmDetail.getTitle();

            filmeTextInfo.setText(filmDetail.getTitle());
            notaTextInfo.setText(filmDetail.getRating());
            anoTextInfo.setText(filmDetail.getYear().substring(0, 4));
            //generoTextInfo.setText(json.getString("genre"));
            //estrelasTextInfo.setText(json.getString("stars"));
            plotTextInfo.setText(filmDetail.getOverview());
            stringUrl = filmDetail.getLinkCartaz();
            collapsingToolbarLayout.setTitle(filmDetail.getTitle());

            // Veiculação e download da imagem URL do cataz do filme com a ImageView dos detalhes do filme pesquisado
            Picasso.with(getApplicationContext()).load(stringUrl).into(filmImageView);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
