package com.test.pau.moviedbfinalversion.provider.pelis;

import android.net.Uri;
import android.provider.BaseColumns;

import com.test.pau.moviedbfinalversion.provider.PeliProvider;
import com.test.pau.moviedbfinalversion.provider.pelis.PelisColumns;

/**
 * Una pelicula cuya información hay que almacenar
 */
public class PelisColumns implements BaseColumns {
    public static final String TABLE_NAME = "pelis";
    public static final Uri CONTENT_URI = Uri.parse(PeliProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String TITULO = "titulo";

    public static final String POPULARIDAD = "popularidad";

    public static final String VALORACION = "valoracion";

    public static final String LENGUA_ORG = "lengua_org";

    public static final String SINOPSIS = "sinopsis";

    public static final String POSTERPATH = "posterpath";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            TITULO,
            POPULARIDAD,
            VALORACION,
            LENGUA_ORG,
            SINOPSIS,
            POSTERPATH
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(TITULO) || c.contains("." + TITULO)) return true;
            if (c.equals(POPULARIDAD) || c.contains("." + POPULARIDAD)) return true;
            if (c.equals(VALORACION) || c.contains("." + VALORACION)) return true;
            if (c.equals(LENGUA_ORG) || c.contains("." + LENGUA_ORG)) return true;
            if (c.equals(SINOPSIS) || c.contains("." + SINOPSIS)) return true;
            if (c.equals(POSTERPATH) || c.contains("." + POSTERPATH)) return true;
        }
        return false;
    }

}
