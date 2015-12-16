package com.test.pau.moviedbfinalversion.provider.pelis;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.test.pau.moviedbfinalversion.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code pelis} table.
 */
public class PelisCursor extends AbstractCursor implements PelisModel {
    public PelisCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(PelisColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code titulo} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getTitulo() {
        String res = getStringOrNull(PelisColumns.TITULO);
        return res;
    }

    /**
     * Get the {@code popularidad} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPopularidad() {
        String res = getStringOrNull(PelisColumns.POPULARIDAD);
        return res;
    }

    /**
     * Get the {@code valoracion} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getValoracion() {
        String res = getStringOrNull(PelisColumns.VALORACION);
        return res;
    }

    /**
     * Get the {@code lengua_org} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getLenguaOrg() {
        String res = getStringOrNull(PelisColumns.LENGUA_ORG);
        return res;
    }

    /**
     * Get the {@code sinopsis} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getSinopsis() {
        String res = getStringOrNull(PelisColumns.SINOPSIS);
        return res;
    }

    /**
     * Get the {@code posterpath} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPosterpath() {
        String res = getStringOrNull(PelisColumns.POSTERPATH);
        return res;
    }
}
