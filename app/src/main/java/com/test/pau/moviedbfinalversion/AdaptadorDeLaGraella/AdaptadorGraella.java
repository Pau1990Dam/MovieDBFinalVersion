package com.test.pau.moviedbfinalversion.AdaptadorDeLaGraella;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.pau.moviedbfinalversion.Json.Peli;
import com.test.pau.moviedbfinalversion.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pau on 10/11/15.
 */
public class AdaptadorGraella extends ArrayAdapter<Peli> {
    List<Peli>pelis;
    DecimalFormat formato=new DecimalFormat("#0.00");
    public AdaptadorGraella(Context context, int resource, List<Peli> pelis) {
        super(context, resource, pelis);
        this.pelis=pelis;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View item =inflater.inflate(R.layout.fila_graella, null);

        ImageView poster=(ImageView)item.findViewById(R.id.poster);
        TextView titol=(TextView)item.findViewById(R.id.Titol);
        TextView popularitat=(TextView)item.findViewById(R.id.Popularitat);
        TextView valoracio=(TextView)item.findViewById(R.id.Valoracio);

        poster.setImageResource(R.drawable.sample_6);//Provisional
        titol.setText(pelis.get(position).getTitle());
        popularitat.setText("Popularidad "+formato.format(pelis.get(position).getPopularity()));
        valoracio.setText("Valoración " + formato.format(pelis.get(position).getVoteAverage()));
        return (item);
    }
}
