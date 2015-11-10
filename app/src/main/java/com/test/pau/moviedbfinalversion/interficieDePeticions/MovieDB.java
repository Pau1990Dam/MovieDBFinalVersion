package com.test.pau.moviedbfinalversion.interficieDePeticions;

import com.test.pau.moviedbfinalversion.Json.PelisPopulares;
import com.test.pau.moviedbfinalversion.Json.Posters;
import com.test.pau.moviedbfinalversion.Json.TopPelis;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by pau on 10/11/15.
 */
public interface MovieDB {
    @GET("top_rated")
    Call<TopPelis> top_pelis(
            @Query("api_key")String api_key,
            @Query("country") String pais);

    @GET("popular")
    Call<PelisPopulares> pelis_populares(
            @Query("api_key")String api_key);

    @GET("images")
    Call<Posters> posters(
            @Query("api_key")String api_key);
}