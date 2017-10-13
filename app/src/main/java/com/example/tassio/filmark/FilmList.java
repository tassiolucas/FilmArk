package com.example.tassio.filmark;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;


public class FilmList extends Activity {

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerFilm_content);

    List<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);




        String[] listaExemplo = new String[] {"BLABLABLA", "Altera texto fragment 1", "Fragment 2", "Fragment 3", "E por ai vai"};




    }






}
