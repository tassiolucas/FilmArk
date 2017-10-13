package com.example.tassio.filmark;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tassi on 11/10/2017.
 */

public class Film {

    String titulo;
    String ano;
    String rating;
    String linkCartaz;

    Film(String titulo, String ano, String rating, String linkCartaz) {
        this.titulo = titulo;
        this.ano = ano;
        this.rating = rating;
        this.linkCartaz = linkCartaz;
    }

    private List<Film> films;

    private void initializaData() {
        films = new ArrayList<>();
        films.add(new Film("Titanic", "1991", "9.5", "https://code.tutsplus.com/tutorials/getting-started-with-recyclerview-and-cardview-on-android--cms-23465"));
    }






}
