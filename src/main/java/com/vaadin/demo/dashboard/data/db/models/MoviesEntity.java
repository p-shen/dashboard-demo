package com.vaadin.demo.dashboard.data.db.models;

import javax.persistence.*;

/**
 * Created by Peter on 2016-07-28.
 */
@Entity
@Table(name = "movies", schema = "vaadin", catalog = "")
public class MoviesEntity {
    private int id;
    private String title;
    private Integer year;
    private String mpaaRating;
    private Integer runtime;
    private String criticsConsensus;
    private String synopsis;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "mpaa_rating")
    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    @Basic
    @Column(name = "runtime")
    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    @Basic
    @Column(name = "critics_consensus")
    public String getCriticsConsensus() {
        return criticsConsensus;
    }

    public void setCriticsConsensus(String criticsConsensus) {
        this.criticsConsensus = criticsConsensus;
    }

    @Basic
    @Column(name = "synopsis")
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoviesEntity that = (MoviesEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (mpaaRating != null ? !mpaaRating.equals(that.mpaaRating) : that.mpaaRating != null) return false;
        if (runtime != null ? !runtime.equals(that.runtime) : that.runtime != null) return false;
        if (criticsConsensus != null ? !criticsConsensus.equals(that.criticsConsensus) : that.criticsConsensus != null)
            return false;
        if (synopsis != null ? !synopsis.equals(that.synopsis) : that.synopsis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (mpaaRating != null ? mpaaRating.hashCode() : 0);
        result = 31 * result + (runtime != null ? runtime.hashCode() : 0);
        result = 31 * result + (criticsConsensus != null ? criticsConsensus.hashCode() : 0);
        result = 31 * result + (synopsis != null ? synopsis.hashCode() : 0);
        return result;
    }
}
