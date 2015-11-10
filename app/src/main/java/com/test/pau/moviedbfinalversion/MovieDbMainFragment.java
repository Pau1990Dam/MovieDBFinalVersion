package com.test.pau.moviedbfinalversion;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDbMainFragment extends Fragment {

    //Objete adaptar, de caire temporal, creat per ajustar el GridView
    TestAdaptadorGraella testAdapter;
    //ArrayList d'objectes fets amedida del GridView per enviar-los al Adapter y que aquest els fiqui
    //dintre de les cel·les del GridView
    ArrayList<ItemGridTest> listaObjetes;

    public MovieDbMainFragment() {
    }

    //Indiquem que agregarem un nou  item (opció al menu)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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
        Toast t= Toast.makeText(getContext(),"Funciona!!!",Toast.LENGTH_LONG);
        t.show();
    }

}

//Objecte creat per omplir El ImageView i els TextViews del Grid
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

//Dibuixa els objectes pasats creant línies d'xml. Es com una plantilla.
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

