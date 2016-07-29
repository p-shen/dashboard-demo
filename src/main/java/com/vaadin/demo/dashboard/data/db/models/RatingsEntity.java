package com.vaadin.demo.dashboard.data.db.models;

import javax.persistence.*;

/**
 * Created by Peter on 2016-07-28.
 */
@Entity
@Table(name = "ratings", schema = "vaadin", catalog = "")
public class RatingsEntity {
    private int id;
    private int movieId;
    private String criticsRating;
    private Integer criticsScore;
    private String audienceRating;
    private Integer audienceScore;

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
    @Column(name = "critics_rating")
    public String getCriticsRating() {
        return criticsRating;
    }

    public void setCriticsRating(String criticsRating) {
        this.criticsRating = criticsRating;
    }

    @Basic
    @Column(name = "critics_score")
    public Integer getCriticsScore() {
        return criticsScore;
    }

    public void setCriticsScore(Integer criticsScore) {
        this.criticsScore = criticsScore;
    }

    @Basic
    @Column(name = "audience_rating")
    public String getAudienceRating() {
        return audienceRating;
    }

    public void setAudienceRating(String audienceRating) {
        this.audienceRating = audienceRating;
    }

    @Basic
    @Column(name = "audience_score")
    public Integer getAudienceScore() {
        return audienceScore;
    }

    public void setAudienceScore(Integer audienceScore) {
        this.audienceScore = audienceScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatingsEntity that = (RatingsEntity) o;

        if (id != that.id) return false;
        if (movieId != that.movieId) return false;
        if (criticsRating != null ? !criticsRating.equals(that.criticsRating) : that.criticsRating != null)
            return false;
        if (criticsScore != null ? !criticsScore.equals(that.criticsScore) : that.criticsScore != null) return false;
        if (audienceRating != null ? !audienceRating.equals(that.audienceRating) : that.audienceRating != null)
            return false;
        if (audienceScore != null ? !audienceScore.equals(that.audienceScore) : that.audienceScore != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + movieId;
        result = 31 * result + (criticsRating != null ? criticsRating.hashCode() : 0);
        result = 31 * result + (criticsScore != null ? criticsScore.hashCode() : 0);
        result = 31 * result + (audienceRating != null ? audienceRating.hashCode() : 0);
        result = 31 * result + (audienceScore != null ? audienceScore.hashCode() : 0);
        return result;
    }
}
