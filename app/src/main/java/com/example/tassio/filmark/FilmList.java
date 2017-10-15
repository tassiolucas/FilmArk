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

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilmList extends Activity {

    List<Film> filmList;
    FilmAdapter adapter;
    JSONArray arrayFilms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerFilm_content);

        Intent it = getIntent();
        String jsonString = it.getStringExtra("jsonArray");

        try {
            arrayFilms = new JSONArray(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println("TESTE: " + arrayFilms.toString());

        filmList = new ArrayList<>();

        adapter = new FilmAdapter(this, filmList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareFilms(arrayFilms);
    }

    private void prepareFilms(JSONArray arrayFilms) {

        for (int i = 0; i < arrayFilms.length(); i++){

            Film film = new Film();

            try {
                film.setTitle(arrayFilms.getJSONObject(i).getString("title"));
                film.setYear(arrayFilms.getJSONObject(i).getString("release_date"));
                film.setRating(arrayFilms.getJSONObject(i).getString("vote_average"));
                film.setLinkCartaz("http://image.tmdb.org/t/p/w185" + arrayFilms.getJSONObject(i).getString("poster_path"));
                film.setOverview(arrayFilms.getJSONObject(i).getString("overview"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            filmList.add(film);
        }
    }
}
