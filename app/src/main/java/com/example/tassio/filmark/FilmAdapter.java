package com.example.tassio.filmark;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tassi on 13/10/2017.
 */

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    public static class FilmViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView tv;

        FilmViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            tv = (TextView) itemView.findViewById(R.id.titleFilmCard);

        }

    }

    List<Film> films;

    FilmAdapter(List<Film> films) {
        this.films = films;
    }

    @Override
    public int getItemCount(){
        return films.size();
    }

    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.film_fragment, viewGroup, false);

        FilmViewHolder filmViewHolder = new FilmViewHolder(v);

        return filmViewHolder;

    }

    @Override
    public void onBindViewHolder(FilmViewHolder filmViewHolder, int i){
        filmViewHolder.tv.setText(films.get(i).titulo);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }


}
