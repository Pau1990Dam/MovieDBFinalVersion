package com.test.pau.moviedbfinalversion.provider.pelis;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.test.pau.moviedbfinalversion.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code pelis} table.
 */
public class PelisContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PelisColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PelisSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PelisSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public PelisContentValues putTitulo(@Nullable String value) {
        mContentValues.put(PelisColumns.TITULO, value);
        return this;
    }

    public PelisContentValues putTituloNull() {
        mContentValues.putNull(PelisColumns.TITULO);
        return this;
    }

    public PelisContentValues putPopularidad(@Nullable String value) {
        mContentValues.put(PelisColumns.POPULARIDAD, value);
        return this;
    }

    public PelisContentValues putPopularidadNull() {
        mContentValues.putNull(PelisColumns.POPULARIDAD);
        return this;
    }

    public PelisContentValues putValoracion(@Nullable String value) {
        mContentValues.put(PelisColumns.VALORACION, value);
        return this;
    }

    public PelisContentValues putValoracionNull() {
        mContentValues.putNull(PelisColumns.VALORACION);
        return this;
    }

    public PelisContentValues putLenguaOrg(@Nullable String value) {
        mContentValues.put(PelisColumns.LENGUA_ORG, value);
        return this;
    }

    public PelisContentValues putLenguaOrgNull() {
        mContentValues.putNull(PelisColumns.LENGUA_ORG);
        return this;
    }

    public PelisContentValues putSinopsis(@Nullable String value) {
        mContentValues.put(PelisColumns.SINOPSIS, value);
        return this;
    }

    public PelisContentValues putSinopsisNull() {
        mContentValues.putNull(PelisColumns.SINOPSIS);
        return this;
    }

    public PelisContentValues putPosterpath(@Nullable String value) {
        mContentValues.put(PelisColumns.POSTERPATH, value);
        return this;
    }

    public PelisContentValues putPosterpathNull() {
        mContentValues.putNull(PelisColumns.POSTERPATH);
        return this;
    }
}
