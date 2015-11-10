package com.test.pau.moviedbfinalversion.Json;

/**
 * Created by pau on 3/11/15.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Posters {

    private int id;
    private List<Fondo> backdrops = new ArrayList<Fondo>();
    private List<Poster> posters = new ArrayList<Poster>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The backdrops
     */
    public List<Fondo> getBackdrops() {
        return backdrops;
    }

    /**
     *
     * @param backdrops
     * The backdrops
     */
    public void setBackdrops(List<Fondo> backdrops) {
        this.backdrops = backdrops;
    }

    /**
     *
     * @return
     * The posters
     */
    public List<Poster> getPosters() {
        return posters;
    }

    /**
     *
     * @param posters
     * The posters
     */
    public void setPosters(List<Poster> posters) {
        this.posters = posters;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}