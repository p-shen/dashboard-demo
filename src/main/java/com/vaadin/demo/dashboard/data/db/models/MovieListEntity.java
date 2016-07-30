package com.vaadin.demo.dashboard.data.db.models;

import java.util.List;

/**
 * Created by Peter on 2016-07-29.
 */
public class MovieListEntity {

    private List<MoviesEntity> movies;
    private int total;

    public List<MoviesEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MoviesEntity> movies) {
        this.movies = movies;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
