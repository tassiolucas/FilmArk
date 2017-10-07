package com.example.tassio.filmark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import org.w3c.dom.Text;

public class activity_film_detail extends AppCompatActivity {

    private TextView filmeTextView;
    private TextView filmeTextInfo;
    private TextView notaTextView;
    private TextView notaTextInfo;
    private TextView anoTextView;
    private TextView anoTextInfo;
    private TextView generoTextView;
    private TextView generoTextInfo;
    private TextView estrelasTextView;
    private TextView estrelasTextInfo;
    private TextView plotTextView;
    private TextView plotTextInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);

        filmeTextView = (TextView) findViewById(R.id.filmeTextView);
        filmeTextInfo = (TextView) findViewById(R.id.filmeTextInfo);
        notaTextView = (TextView) findViewById(R.id.notaTextView);
        notaTextInfo = (TextView) findViewById(R.id.notaTextInfo);
        anoTextView = (TextView) findViewById(R.id.anoTextView);
        anoTextInfo = (TextView) findViewById(R.id.anoTextInfo);
        generoTextView = (TextView) findViewById(R.id.generoTextView);
        generoTextInfo = (TextView) findViewById(R.id.generoTextInfo);
        estrelasTextView = (TextView) findViewById(R.id.estrelasTextView);
        estrelasTextInfo = (TextView) findViewById(R.id.estrelasTextInfo);
        plotTextView = (TextView) findViewById(R.id.plotTextView);
        plotTextInfo = (TextView) findViewById(R.id.plotTextInfo);

        Bundle bundle = getIntent().getExtras();

        filmeTextInfo.setText(bundle.getString("VALOR"));

    }
}
