package com.example.tassio.filmark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tassi on 11/10/2017.
 */

public class Film implements Serializable {

    private String title;
    private String year;
    private String rating;
    private String linkCartaz;
    private String overview;
    private int genresId;
    private String genres;
    private String diretor;
    private String estrelas;


    public Film(){
    }

    Film(String titulo, String ano, String rating, String linkCartaz, String overview) {
        this.title = titulo;
        this.year = ano;
        this.rating = rating;
        this.linkCartaz = linkCartaz;
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear(){
        return year;
    }

    public void setYear(String year){
        this.year = year;
    }

    public String getRating(){
        return rating;
    }

    public void setRating(String rating){
        this.rating = rating;
    }

    public String getLinkCartaz(){
        return linkCartaz;
    }

    public void setLinkCartaz(String linkCartaz){
        this.linkCartaz = linkCartaz;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOverview(){
        return overview;
    }



}
