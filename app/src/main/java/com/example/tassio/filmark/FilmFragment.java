package com.example.tassio.filmark;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tassi on 12/10/2017.
 */

public class FilmFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.film_fragment, null);

        TextView tv = (TextView) view.findViewById(R.id.textViewFragment);

        tv.setText("BLABLABLA");

        return view;
    }

    public void alterarTextoButton(String texto) {
        TextView tv = (TextView) getView().findViewById(R.id.textViewFragment);

        tv.setText("BLABLABLA");
    }

}
