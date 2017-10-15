package com.example.tassio.filmark;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by tassi on 13/10/2017.
 */

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private Context context;
    private List<Film> filmList;
    JSONArray arrayFilm;

    public class FilmViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleFilmCard;
        TextView yearFilmCard;
        TextView ratingFilmCard;
        ImageView imageFilmCard;
        ImageView ratingStar;
        View mCardView;

        public FilmViewHolder(View view) {
            super(view);
            context = itemView.getContext();

            mCardView = (CardView) view.findViewById(R.id.cv);
            titleFilmCard = (TextView) view.findViewById(R.id.titleFilmCard);
            yearFilmCard = (TextView) view.findViewById(R.id.yearFilmCard);
            ratingFilmCard = (TextView) view.findViewById(R.id.ratingFilmCard);
            imageFilmCard = (ImageView) view.findViewById(R.id.imageFilmCard);
            ratingStar = (ImageView) view.findViewById(R.id.ratingStar);

            mCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = getLayoutPosition();

            Intent it = new Intent(v.getContext(), activity_film_detail.class);

            Film sendFilm = filmList.get(position);

            it.putExtra("jsonFilm", sendFilm);

            v.getContext().startActivity(it);
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
            holder.ratingFilmCard.setText(film.getRating());
            Picasso.with(context).load(film.getLinkCartaz()).into(holder.imageFilmCard);
            holder.ratingStar.setImageResource(R.drawable.star);
            holder.itemView.setTag(position);

        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
        }
    }

    @Override
    public int getItemCount(){
        return filmList.size();
    }

}

