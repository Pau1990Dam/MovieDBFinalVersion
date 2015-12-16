package com.test.pau.moviedbfinalversion.provider.pelis;

import com.test.pau.moviedbfinalversion.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Una pelicula cuya información hay que almacenar
 */
public interface PelisModel extends BaseModel {

    /**
     * Get the {@code titulo} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTitulo();

    /**
     * Get the {@code popularidad} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPopularidad();

    /**
     * Get the {@code valoracion} value.
     * Can be {@code null}.
     */
    @Nullable
    String getValoracion();

    /**
     * Get the {@code lengua_org} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLenguaOrg();

    /**
     * Get the {@code sinopsis} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSinopsis();

    /**
     * Get the {@code posterpath} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPosterpath();
}
