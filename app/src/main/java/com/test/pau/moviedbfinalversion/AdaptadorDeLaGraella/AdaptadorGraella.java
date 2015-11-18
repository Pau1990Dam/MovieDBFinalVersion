package com.test.pau.moviedbfinalversion.AdaptadorDeLaGraella;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.pau.moviedbfinalversion.Json.Peli;
import com.test.pau.moviedbfinalversion.R;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by pau on 10/11/15.
 */
public class AdaptadorGraella extends ArrayAdapter<Peli> implements Serializable {

    final private String posterUrl = "http://image.tmdb.org/t/p/";
    final private String posterSize = "w185";
    List<Peli>pelis;
    DecimalFormat formato=new DecimalFormat("#0.00");
    DecimalFormat formato2=new DecimalFormat("#00");
    public AdaptadorGraella(Context context, int resource, List<Peli> pelis) {
        super(context, resource, pelis);
        this.pelis=pelis;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View item =inflater.inflate(R.layout.fila_graella, null);

        ImageView poster=(ImageView)item.findViewById(R.id.peliPoster);
        TextView titol=(TextView)item.findViewById(R.id.Titol);
        TextView popularitat=(TextView)item.findViewById(R.id.Popularitat);
        TextView valoracio=(TextView)item.findViewById(R.id.Valoracio);

       // poster.setImageResource(R.drawable.sample_6);//Provisional
        Picasso.with(getContext()).load(posterUrl + posterSize + pelis.get(position).
                getPosterPath()).into(poster);//
        titol.setText(pelis.get(position).getTitle());
        popularitat.setText("Popularidad "+formato2.format(pelis.get(position).getPopularity())+"%");
        valoracio.setText("Valoración " + formato.format(pelis.get(position).getVoteAverage()));
        return (item);
    }
}
