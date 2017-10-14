package com.example.tassio.filmark;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FilmList extends Activity {

    List<Film> filmList;
    FilmAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerFilm_content);


        List<Film> filmList = (ArrayList<Film>) getIntent().getSerializableExtra("filmArray");

        System.out.println("TESTE: " + filmList.toString());

        //filmList = new ArrayList<>();

        adapter = new FilmAdapter(this, filmList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareFilms();

    }

    private void prepareFilms() {

//        Film a = new Film("Titanic", "1991", "9.5", "BLABLA");
//        filmList.add(a);
//
//        Film b = new Film("Games of Thones", "2017", "10", "BLABLA");
//        filmList.add(b);
    }





}
