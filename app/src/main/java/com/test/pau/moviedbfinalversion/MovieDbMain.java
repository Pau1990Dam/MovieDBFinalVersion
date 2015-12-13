package com.test.pau.moviedbfinalversion;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MovieDbMain extends AppCompatActivity {

   // private android.support.v7.app.ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(this);   // necesario para referenciar y leer la configuración del programa

        // Según como esté configurado el programa lee de las preferncias y muestra un titulo en el Toolbar u otro
        /* IMPORTANTE: SOLO funcionará mientras la gestión de categorías pase por las preferencias.*/

        if(preferencias.getString("lista_peliculas","populars").equals("populars")){
            toolbar.setTitle("MovieDB - Populares");
        }
        else if (preferencias.getString("lista_peliculas","top_rated").equals("top_rated")){
            toolbar.setTitle("MovieDB - Mejor Valoradas");
        }
        else{
            toolbar.setTitle("MovieDB");
        }
        setSupportActionBar(toolbar);
    }
/*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Peli pelicula = (Peli) getIntent().getExtras().get("pelicula");
        toolbar.setTitle(pelicula.getTitle() + " - (" + pelicula.getReleaseDate().substring(0, 4) + ")");
 */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_db_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void setActionBarTitle(String title){

    }
}
