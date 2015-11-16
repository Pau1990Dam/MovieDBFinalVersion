package com.test.pau.moviedbfinalversion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.pau.moviedbfinalversion.Json.Peli;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Created by pau on 16/11/15.
 */
public class PeliculaActivity extends AppCompatActivity {


    private Peli pelicula;
//    private SimpleDateFormat data = new SimpleDateFormat("dd/MM/YY");
    DecimalFormat formato=new DecimalFormat("#00");
    DecimalFormat formato2=new DecimalFormat("#0.00");
    final private String posterUrl = "http://image.tmdb.org/t/p/";
    final private String posterSize = "w185";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula_detalls);


        // Creamos nuestro intent y recogemos los datos que enviamos desde fragment
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();

        if (bd != null) {   // Su hemos recibido algo lo asigna a pelocula
            pelicula = (Peli) intent.getSerializableExtra("pelicula");
        }

        TextView titulo=(TextView) findViewById(R.id.titulo);
        TextView fecha=(TextView) findViewById(R.id.fecha);
        TextView popularidad=(TextView) findViewById(R.id.popularidad);
        TextView valoracion=(TextView) findViewById(R.id.valoracion);
        TextView idioma=(TextView) findViewById(R.id.idioma);
        TextView catalogacion=(TextView) findViewById(R.id.catalogacion);
        TextView descripcion=(TextView) findViewById(R.id.descripcion);
        ImageView poster=(ImageView)findViewById(R.id.peliPoster);

        titulo.setText(pelicula.getTitle());
        fecha.setText("Estreno: "+pelicula.getReleaseDate());
        popularidad.setText("Popularidad"+formato.format(pelicula.getPopularity())+"%");
        valoracion.setText("Valoración"+formato2.format(pelicula.getVoteAverage()));
        idioma.setText("Lengua original: "+pelicula.getOriginalLanguage());
        catalogacion.setText(getCatalogacion());
        descripcion.setText(pelicula.getOverview());
        Picasso.with(this).load(posterUrl + posterSize + pelicula.getPosterPath()).into(poster);//
    }

    private String getCatalogacion(){
        if(pelicula.isAdult()){
            return "Película no apta para menores de edad";
        }else
            return "Película apta para todos los públicos";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalles_pelicula, menu);

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
