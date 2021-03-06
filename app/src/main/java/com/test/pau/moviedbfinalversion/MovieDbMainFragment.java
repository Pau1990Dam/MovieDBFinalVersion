package com.test.pau.moviedbfinalversion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


import com.test.pau.moviedbfinalversion.AdaptadorDeLaGraella.AdaptadorGraella;
import com.test.pau.moviedbfinalversion.Json.Peli;
import com.test.pau.moviedbfinalversion.SolicitadorRetrofit.RetrofitRequester;
import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDbMainFragment extends Fragment {
     AdaptadorGraella adptador;
     ArrayList<Peli>inicialitzador;

    public MovieDbMainFragment() {
    }

    //Indiquem que agregarem un nou  item (opció al menu)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_movie_db_main, container, false);

        inicialitzador=new ArrayList<>();
        final Peli p= new Peli();
        p.setTitle("Sin datos");
        p.setPopularity(0);
        p.setVoteAverage(0);
        for(int i=0;i<=10;i++)inicialitzador.add(p);
        GridView graellaPelis= (GridView)rootView.findViewById(R.id.graellaPelis);
        adptador=new AdaptadorGraella(getContext(),R.layout.fila_graella,inicialitzador);
        graellaPelis.setAdapter(adptador);

        graellaPelis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Peli peliSeleccionada = (Peli)parent.getItemAtPosition(position);
                Intent invocaPeliActivity = new Intent(getContext(), PeliculaActivity.class);
                invocaPeliActivity.putExtra("pelicula", peliSeleccionada);
                startActivity(invocaPeliActivity);
            }

        });

        return rootView;
    }

    //Indiquem quin es el xml corresponent al dibuix del menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_refresh, menu);
    }

    //Indiquem que executi el métode void refresh() si es clica l'item del menu refresh.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void refresh() {
        String llengua="es";

        RetrofitRequester apiSolicitadora = new RetrofitRequester();


        SharedPreferences preferencias= PreferenceManager.getDefaultSharedPreferences(getContext());
        if(preferencias.getString("idioma_peliculas","es").equals("es")){
            llengua="es";
        }else
            llengua="en";

        if(preferencias.getString("lista_peliculas","populars").equals("populars")){
            apiSolicitadora.getPeliculesPopulars(adptador,llengua);
        }if(preferencias.getString("lista_peliculas","top_rated").equals("top_rated")) {
            apiSolicitadora.getPeliculesMillorValorades(adptador, llengua);
        }

    }
}




