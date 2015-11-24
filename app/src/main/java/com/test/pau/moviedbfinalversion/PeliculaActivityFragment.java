package com.test.pau.moviedbfinalversion;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.pau.moviedbfinalversion.Json.Peli;

import java.text.DecimalFormat;


public class PeliculaActivityFragment extends Fragment {

    private Peli pelicula;
    //    private SimpleDateFormat data = new SimpleDateFormat("dd/MM/YY");
    DecimalFormat formato=new DecimalFormat("#00");
    DecimalFormat formato2=new DecimalFormat("#0.00");
    final private String posterUrl = "http://image.tmdb.org/t/p/";
    final private String posterSize = "w185";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_pelicula_detalls, container, false);

        // Creamos nuestro intent y recogemos los datos que enviamos desde fragment
        Intent intent = getActivity().getIntent();
        Bundle bd = intent.getExtras();

        if (bd != null) {   // Su hemos recibido algo lo asigna a pelocula
            pelicula = (Peli) intent.getSerializableExtra("pelicula");
        }


        TextView titulo=(TextView) view.findViewById(R.id.titulo);
        TextView fecha=(TextView) view.findViewById(R.id.fecha);
        TextView popularidad=(TextView) view.findViewById(R.id.popularidad);
        TextView valoracion=(TextView) view.findViewById(R.id.valoracion);
        TextView idioma=(TextView) view.findViewById(R.id.idioma);
        TextView catalogacion=(TextView) view.findViewById(R.id.catalogacion);
        TextView descripcion=(TextView) view.findViewById(R.id.descripcion);
        ImageView poster=(ImageView)view.findViewById(R.id.peliPoster);

        titulo.setText(pelicula.getTitle());
        fecha.setText("Estreno: "+pelicula.getReleaseDate());
        popularidad.setText("Popularidad "+formato.format(pelicula.getPopularity())+"%");
        valoracion.setText("Valoración "+formato2.format(pelicula.getVoteAverage()));
        idioma.setText("Lengua original: "+pelicula.getOriginalLanguage());
        catalogacion.setText(getCatalogacion());
        descripcion.setText(pelicula.getOverview());
        Picasso.with(getContext()).load(posterUrl + posterSize + pelicula.getPosterPath()).into(poster);//
        return view;

    }

    private String getCatalogacion(){
        if(pelicula.isAdult()){
            return "Película no apta para menores de edad";
        }else
            return "Película apta para todos los públicos";
    }


}
