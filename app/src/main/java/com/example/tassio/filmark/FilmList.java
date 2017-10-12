package com.example.tassio.filmark;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class FilmList extends FragmentActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        String[] listaExemplo = new String[] {"BLABLABLA", "Altera texto fragment 1", "Fragment 2", "Fragment 3", "E por ai vai"};

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_content, new FilmFragment());

        fragmentTransaction.add(R.id.fragment_content, new FilmFragment());
        fragmentTransaction.add(R.id.fragment_content, new FilmFragment());
        fragmentTransaction.add(R.id.fragment_content, new FilmFragment());

        fragmentTransaction.commit();

    }






}
