package com.test.pau.moviedbfinalversion.provider.pelis;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.test.pau.moviedbfinalversion.provider.base.AbstractSelection;

/**
 * Selection for the {@code pelis} table.
 */
public class PelisSelection extends AbstractSelection<PelisSelection> {
    @Override
    protected Uri baseUri() {
        return PelisColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PelisCursor} object, which is positioned before the first entry, or null.
     */
    public PelisCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PelisCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PelisCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PelisCursor} object, which is positioned before the first entry, or null.
     */
    public PelisCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PelisCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PelisCursor query(Context context) {
        return query(context, null);
    }


    public PelisSelection id(long... value) {
        addEquals("pelis." + PelisColumns._ID, toObjectArray(value));
        return this;
    }

    public PelisSelection idNot(long... value) {
        addNotEquals("pelis." + PelisColumns._ID, toObjectArray(value));
        return this;
    }

    public PelisSelection orderById(boolean desc) {
        orderBy("pelis." + PelisColumns._ID, desc);
        return this;
    }

    public PelisSelection orderById() {
        return orderById(false);
    }

    public PelisSelection titulo(String... value) {
        addEquals(PelisColumns.TITULO, value);
        return this;
    }

    public PelisSelection tituloNot(String... value) {
        addNotEquals(PelisColumns.TITULO, value);
        return this;
    }

    public PelisSelection tituloLike(String... value) {
        addLike(PelisColumns.TITULO, value);
        return this;
    }

    public PelisSelection tituloContains(String... value) {
        addContains(PelisColumns.TITULO, value);
        return this;
    }

    public PelisSelection tituloStartsWith(String... value) {
        addStartsWith(PelisColumns.TITULO, value);
        return this;
    }

    public PelisSelection tituloEndsWith(String... value) {
        addEndsWith(PelisColumns.TITULO, value);
        return this;
    }

    public PelisSelection orderByTitulo(boolean desc) {
        orderBy(PelisColumns.TITULO, desc);
        return this;
    }

    public PelisSelection orderByTitulo() {
        orderBy(PelisColumns.TITULO, false);
        return this;
    }

    public PelisSelection popularidad(String... value) {
        addEquals(PelisColumns.POPULARIDAD, value);
        return this;
    }

    public PelisSelection popularidadNot(String... value) {
        addNotEquals(PelisColumns.POPULARIDAD, value);
        return this;
    }

    public PelisSelection popularidadLike(String... value) {
        addLike(PelisColumns.POPULARIDAD, value);
        return this;
    }

    public PelisSelection popularidadContains(String... value) {
        addContains(PelisColumns.POPULARIDAD, value);
        return this;
    }

    public PelisSelection popularidadStartsWith(String... value) {
        addStartsWith(PelisColumns.POPULARIDAD, value);
        return this;
    }

    public PelisSelection popularidadEndsWith(String... value) {
        addEndsWith(PelisColumns.POPULARIDAD, value);
        return this;
    }

    public PelisSelection orderByPopularidad(boolean desc) {
        orderBy(PelisColumns.POPULARIDAD, desc);
        return this;
    }

    public PelisSelection orderByPopularidad() {
        orderBy(PelisColumns.POPULARIDAD, false);
        return this;
    }

    public PelisSelection valoracion(String... value) {
        addEquals(PelisColumns.VALORACION, value);
        return this;
    }

    public PelisSelection valoracionNot(String... value) {
        addNotEquals(PelisColumns.VALORACION, value);
        return this;
    }

    public PelisSelection valoracionLike(String... value) {
        addLike(PelisColumns.VALORACION, value);
        return this;
    }

    public PelisSelection valoracionContains(String... value) {
        addContains(PelisColumns.VALORACION, value);
        return this;
    }

    public PelisSelection valoracionStartsWith(String... value) {
        addStartsWith(PelisColumns.VALORACION, value);
        return this;
    }

    public PelisSelection valoracionEndsWith(String... value) {
        addEndsWith(PelisColumns.VALORACION, value);
        return this;
    }

    public PelisSelection orderByValoracion(boolean desc) {
        orderBy(PelisColumns.VALORACION, desc);
        return this;
    }

    public PelisSelection orderByValoracion() {
        orderBy(PelisColumns.VALORACION, false);
        return this;
    }

    public PelisSelection lenguaOrg(String... value) {
        addEquals(PelisColumns.LENGUA_ORG, value);
        return this;
    }

    public PelisSelection lenguaOrgNot(String... value) {
        addNotEquals(PelisColumns.LENGUA_ORG, value);
        return this;
    }

    public PelisSelection lenguaOrgLike(String... value) {
        addLike(PelisColumns.LENGUA_ORG, value);
        return this;
    }

    public PelisSelection lenguaOrgContains(String... value) {
        addContains(PelisColumns.LENGUA_ORG, value);
        return this;
    }

    public PelisSelection lenguaOrgStartsWith(String... value) {
        addStartsWith(PelisColumns.LENGUA_ORG, value);
        return this;
    }

    public PelisSelection lenguaOrgEndsWith(String... value) {
        addEndsWith(PelisColumns.LENGUA_ORG, value);
        return this;
    }

    public PelisSelection orderByLenguaOrg(boolean desc) {
        orderBy(PelisColumns.LENGUA_ORG, desc);
        return this;
    }

    public PelisSelection orderByLenguaOrg() {
        orderBy(PelisColumns.LENGUA_ORG, false);
        return this;
    }

    public PelisSelection sinopsis(String... value) {
        addEquals(PelisColumns.SINOPSIS, value);
        return this;
    }

    public PelisSelection sinopsisNot(String... value) {
        addNotEquals(PelisColumns.SINOPSIS, value);
        return this;
    }

    public PelisSelection sinopsisLike(String... value) {
        addLike(PelisColumns.SINOPSIS, value);
        return this;
    }

    public PelisSelection sinopsisContains(String... value) {
        addContains(PelisColumns.SINOPSIS, value);
        return this;
    }

    public PelisSelection sinopsisStartsWith(String... value) {
        addStartsWith(PelisColumns.SINOPSIS, value);
        return this;
    }

    public PelisSelection sinopsisEndsWith(String... value) {
        addEndsWith(PelisColumns.SINOPSIS, value);
        return this;
    }

    public PelisSelection orderBySinopsis(boolean desc) {
        orderBy(PelisColumns.SINOPSIS, desc);
        return this;
    }

    public PelisSelection orderBySinopsis() {
        orderBy(PelisColumns.SINOPSIS, false);
        return this;
    }

    public PelisSelection posterpath(String... value) {
        addEquals(PelisColumns.POSTERPATH, value);
        return this;
    }

    public PelisSelection posterpathNot(String... value) {
        addNotEquals(PelisColumns.POSTERPATH, value);
        return this;
    }

    public PelisSelection posterpathLike(String... value) {
        addLike(PelisColumns.POSTERPATH, value);
        return this;
    }

    public PelisSelection posterpathContains(String... value) {
        addContains(PelisColumns.POSTERPATH, value);
        return this;
    }

    public PelisSelection posterpathStartsWith(String... value) {
        addStartsWith(PelisColumns.POSTERPATH, value);
        return this;
    }

    public PelisSelection posterpathEndsWith(String... value) {
        addEndsWith(PelisColumns.POSTERPATH, value);
        return this;
    }

    public PelisSelection orderByPosterpath(boolean desc) {
        orderBy(PelisColumns.POSTERPATH, desc);
        return this;
    }

    public PelisSelection orderByPosterpath() {
        orderBy(PelisColumns.POSTERPATH, false);
        return this;
    }
}
