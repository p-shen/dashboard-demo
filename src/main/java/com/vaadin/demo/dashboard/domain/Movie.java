package com.vaadin.demo.dashboard.domain;

import com.vaadin.demo.dashboard.data.db.models.MoviesEntity;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.Date;

@Entity
@Table(name="movie_processed_data", schema = "vaadin", catalog = "")
public final class Movie {

    @Id
    @Column(name="id")
    private Long id;

    @Basic
    @Column(name="title")
    private String title;

    @Basic
    @Column(name="synopsis", columnDefinition = "TEXT")
    private String synopsis;

    @Basic
    @Column(name="thumbUrl")
    private String thumbUrl;

    @Basic
    @Column(name="posterUrl")
    private String posterUrl;

    @Basic
    @Column(name="duration")
    private Integer duration;

    @Basic
    @Column(name="releaseDate")
    private Date releaseDate;

    @Basic
    @Column(name="score")
    private Integer score;

    @OneToOne(fetch = FetchType.LAZY) //MovieEntity is not needed here
    @JoinColumn(name = "fk_movie_entity")
    private MoviesEntity movieEntity;

    public void setId(final Long id) {
        this.id = id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setSynopsis(final String synopsis) {
        this.synopsis = synopsis;
    }

    public void setThumbUrl(final String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public void setPosterUrl(final String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public void setDuration(final Integer duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(final Integer score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public Integer getDuration() {
        return duration;
    }

    public Long getId() {
        return id;
    }

    public MoviesEntity getMovieEntity() {
        return movieEntity;
    }

    public void setMovieEntity(MoviesEntity movieEntity) {
        this.movieEntity = movieEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (duration != movie.duration) return false;
        if (score != movie.score) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (synopsis != null ? !synopsis.equals(movie.synopsis) : movie.synopsis != null) return false;
        if (thumbUrl != null ? !thumbUrl.equals(movie.thumbUrl) : movie.thumbUrl != null) return false;
        if (posterUrl != null ? !posterUrl.equals(movie.posterUrl) : movie.posterUrl != null) return false;
        if (releaseDate != null ? !releaseDate.equals(movie.releaseDate) : movie.releaseDate != null) return false;
        return movieEntity != null ? movieEntity.equals(movie.movieEntity) : movie.movieEntity == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (synopsis != null ? synopsis.hashCode() : 0);
        result = 31 * result + (thumbUrl != null ? thumbUrl.hashCode() : 0);
        result = 31 * result + (posterUrl != null ? posterUrl.hashCode() : 0);
        result = 31 * result + duration;
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + score;
        result = 31 * result + (movieEntity != null ? movieEntity.hashCode() : 0);
        return result;
    }
}
