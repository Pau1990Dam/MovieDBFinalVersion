package com.test.pau.moviedbfinalversion;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDbMainFragment extends Fragment {

    TestAdaptadorGraella testAdapter;
    ArrayList<ItemGridTest> listaObjetes;
    public MovieDbMainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_movie_db_main, container, false);

        GridView graellaPelis= (GridView)rootView.findViewById(R.id.graellaPelis);
        listaObjetes=new ArrayList<>();
        for(int i=0;i<10;i++)listaObjetes.add(new ItemGridTest());

        testAdapter= new TestAdaptadorGraella(getContext(),listaObjetes);
        graellaPelis.setAdapter(testAdapter);

        return rootView;
    }

}

class ItemGridTest{
    private Integer poster=R.drawable.sample_6;
    private String titol="Peli guay";
    private String popularitat="Molta";
    private String valoracio="Bona";

    public Integer getPoster(){
        return poster;
    }
    public String getTitol(){
        return titol;
    }
    public String getPopularitat(){
        return popularitat;
    }

    public String getValoracio(){
        return valoracio;
    }
}
class TestAdaptadorGraella extends ArrayAdapter<ItemGridTest>{
    ArrayList<ItemGridTest>dades;

    public TestAdaptadorGraella(Context context, ArrayList<ItemGridTest> dades) {
        super(context, R.layout.fila_graella, dades);
        this.dades=dades;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View item =inflater.inflate(R.layout.fila_graella, null);
        ImageView poster=(ImageView)item.findViewById(R.id.poster);
        TextView titol=(TextView)item.findViewById(R.id.Titol);
        TextView popularitat=(TextView)item.findViewById(R.id.Popularitat);
        TextView valoracio=(TextView)item.findViewById(R.id.Valoracio);
        poster.setImageResource(dades.get(position).getPoster());
        titol.setText(dades.get(position).getTitol());
        popularitat.setText(dades.get(position).getPopularitat());
        valoracio.setText(dades.get(position).getValoracio());
        return(item);
    }
}

