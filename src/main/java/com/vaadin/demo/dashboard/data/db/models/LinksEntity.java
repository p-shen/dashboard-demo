package com.vaadin.demo.dashboard.data.db.models;

import javax.persistence.*;

/**
 * Created by Peter on 2016-07-28.
 */
@Entity
@Table(name = "links", schema = "vaadin", catalog = "")
public class LinksEntity {
    private int id;
    private int movieId;
    private String self;
    private String alternate;
    private String cast;
    private String review;
    private String similar;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "movieId")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "self")
    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    @Basic
    @Column(name = "alternate")
    public String getAlternate() {
        return alternate;
    }

    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }

    @Basic
    @Column(name = "cast")
    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    @Basic
    @Column(name = "review")
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Basic
    @Column(name = "similar")
    public String getSimilar() {
        return similar;
    }

    public void setSimilar(String similar) {
        this.similar = similar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinksEntity that = (LinksEntity) o;

        if (id != that.id) return false;
        if (movieId != that.movieId) return false;
        if (self != null ? !self.equals(that.self) : that.self != null) return false;
        if (alternate != null ? !alternate.equals(that.alternate) : that.alternate != null) return false;
        if (cast != null ? !cast.equals(that.cast) : that.cast != null) return false;
        if (review != null ? !review.equals(that.review) : that.review != null) return false;
        if (similar != null ? !similar.equals(that.similar) : that.similar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + movieId;
        result = 31 * result + (self != null ? self.hashCode() : 0);
        result = 31 * result + (alternate != null ? alternate.hashCode() : 0);
        result = 31 * result + (cast != null ? cast.hashCode() : 0);
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + (similar != null ? similar.hashCode() : 0);
        return result;
    }
}
