package com.test.pau.moviedbfinalversion.SolicitadorRetrofit;

import android.widget.Toast;

import com.test.pau.moviedbfinalversion.AdaptadorDeLaGraella.AdaptadorGraella;
import com.test.pau.moviedbfinalversion.Json.Peli;
import com.test.pau.moviedbfinalversion.Json.PelisPopulares;
import com.test.pau.moviedbfinalversion.Json.TopPelis;
import com.test.pau.moviedbfinalversion.interficieDePeticions.MovieDB;

import java.util.Objects;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by pau on 10/11/15.
 */
public class RetrofitRequester {
    private final String BASE_URL ="https://api.themoviedb.org/3/movie/";
    private final String apikey="3abc6154c470ac598df9e7d97700f8cd";
    private String pag="1";
    private MovieDB servei;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public RetrofitRequester(){
        super();
    }

    public void getPeliculesPopulars(final AdaptadorGraella adaptador, String llengua){
        servei=retrofit.create(MovieDB.class);

            Call<PelisPopulares> llamada = (Call<PelisPopulares>) servei.pelis_populares(apikey, llengua);
            llamada.enqueue(new Callback<PelisPopulares>() {
                @Override
                public void onResponse(Response<PelisPopulares> response, Retrofit retrofit) {
                    int i=1;
                    if (response.isSuccess()) {
                        PelisPopulares resultado = response.body();
                        i = resultado.getTotalPages();
                        adaptador.clear();
                        for (Peli lista : resultado.getResults()) {
                            adaptador.add(lista);
                        }
                        Toast.makeText(adaptador.getContext(), "Páginas Totales= " + i, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(adaptador.getContext(), "ERROR", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    t.printStackTrace();
                }

            });
    }

    public void getPeliculesMillorValorades(final AdaptadorGraella adaptador, String llengua){
        servei=retrofit.create(MovieDB.class);
        Call<TopPelis> llamada = (Call<TopPelis>) servei.top_pelis(apikey,llengua);

        llamada.enqueue(new Callback<TopPelis>() {
            @Override
            public void onResponse(Response<TopPelis> response, Retrofit retrofit) {
                int i;
                if (response.isSuccess()) {
                    TopPelis resultado = response.body();
                    i=resultado.getTotalPages();
                    adaptador.clear();
                    for (Peli lista : resultado.getResults()) {
                        adaptador.add(lista);
                    }
                    Toast.makeText(adaptador.getContext(), "Páginas Totales="+i, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(adaptador.getContext(), "ERROR", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }

}

