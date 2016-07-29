package com.vaadin.demo.dashboard.data.db.models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Peter on 2016-07-28.
 */
@Entity
@Table(name = "release_dates", schema = "vaadin", catalog = "")
public class ReleaseDatesEntity {
    private int id;
    private int movieId;
    private String venue;
    private Date startDate;

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
    @Column(name = "venue")
    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReleaseDatesEntity that = (ReleaseDatesEntity) o;

        if (id != that.id) return false;
        if (movieId != that.movieId) return false;
        if (venue != null ? !venue.equals(that.venue) : that.venue != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + movieId;
        result = 31 * result + (venue != null ? venue.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        return result;
    }
}
