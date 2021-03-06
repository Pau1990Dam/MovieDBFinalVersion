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
    public AdaptadorGraella(Context context, int resource, List<Peli> pelis) {
        super(context, resource, pelis);
        this.pelis=pelis;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        Peli pelicula=getItem(position);
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView =inflater.inflate(R.layout.fila_graella, parent, false);
        }

        ImageView poster=(ImageView)convertView.findViewById(R.id.peliPoster);
        TextView titol=(TextView)convertView.findViewById(R.id.Titol);

        Picasso.with(getContext()).load(posterUrl + posterSize + pelis.get(position).
                getPosterPath()).fit().into(poster);//
        titol.setText(pelis.get(position).getTitle());

        return (convertView);
    }
}
