package com.vaadin.demo.dashboard.data.db.models;

import javax.persistence.*;

/**
 * Created by Peter on 2016-07-28.
 */
@Entity
@Table(name = "alternate_ids", schema = "vaadin", catalog = "")
public class AlternateIdsEntity {
    private int id;
    private int movieId;
    private String site;
    private String siteId;

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
    @Column(name = "site")
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Basic
    @Column(name = "site_id")
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlternateIdsEntity that = (AlternateIdsEntity) o;

        if (id != that.id) return false;
        if (movieId != that.movieId) return false;
        if (site != null ? !site.equals(that.site) : that.site != null) return false;
        if (siteId != null ? !siteId.equals(that.siteId) : that.siteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + movieId;
        result = 31 * result + (site != null ? site.hashCode() : 0);
        result = 31 * result + (siteId != null ? siteId.hashCode() : 0);
        return result;
    }
}
