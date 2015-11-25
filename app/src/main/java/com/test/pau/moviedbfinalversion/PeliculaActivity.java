package com.test.pau.moviedbfinalversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.test.pau.moviedbfinalversion.Json.Peli;

/**
 * Created by pau on 16/11/15.
 */
public class PeliculaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula_detalls);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Peli pelicula = (Peli) getIntent().getExtras().get("pelicula");
        toolbar.setTitle(pelicula.getTitle() + " - (" + pelicula.getReleaseDate().substring(0, 4) + ")");

    }
}

/*
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        myToolbar.setTitle("Peli");
 */
