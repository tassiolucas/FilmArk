package com.example.tassio.filmark;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by tassi on 13/10/2017.
 */

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    Context context;
    List<Film> filmList;

    public class FilmViewHolder extends RecyclerView.ViewHolder {

        TextView titleFilmCard;
        TextView yearFilmCard;
        TextView ratingFilmCard;
        ImageView imageFilmCard;

        public FilmViewHolder(View view) {
            super(view);
            titleFilmCard = (TextView) view.findViewById(R.id.titleFilmCard);
            yearFilmCard = (TextView) view.findViewById(R.id.yearFilmCard);
            ratingFilmCard = (TextView) view.findViewById(R.id.ratingFilmCard);
            imageFilmCard = (ImageView) view.findViewById(R.id.imageFilmCard);
        }
    }

    public FilmAdapter(Context context, List<Film> filmList) {
        this.context = context;
        this.filmList = filmList;
    }

    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup parent, int i){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_fragment, parent, false);

        return new FilmViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FilmViewHolder holder, int position){
        try {
            Film film = filmList.get(position);
            holder.titleFilmCard.setText(film.getTitle());
            holder.yearFilmCard.setText("Ano: " + film.getYear().substring(0, 4));
            holder.ratingFilmCard.setText("Avaliação: " + film.getRating());
            Picasso.with(context).load(film.getLinkCartaz()).into(holder.imageFilmCard);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
    }

    @Override
    public int getItemCount(){
        return filmList.size();
    }

}
