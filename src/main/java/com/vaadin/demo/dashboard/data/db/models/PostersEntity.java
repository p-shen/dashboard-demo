package com.vaadin.demo.dashboard.data.db.models;

import com.vaadin.annotations.AutoGenerated;

import javax.persistence.*;

/**
 * Created by Peter on 2016-07-28.
 */
@Entity
@Table(name = "posters", schema = "vaadin", catalog = "")
public class PostersEntity {
    private Long id;
    private String thumbnail;
    private String profile;
    private String detailed;
    private String original;

    public PostersEntity() { }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique=true, nullable=false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Basic
    @Column(name = "profile")
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Basic
    @Column(name = "detailed")
    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    @Basic
    @Column(name = "original")
    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostersEntity that = (PostersEntity) o;

        if (id != that.id) return false;
        if (thumbnail != null ? !thumbnail.equals(that.thumbnail) : that.thumbnail != null) return false;
        if (profile != null ? !profile.equals(that.profile) : that.profile != null) return false;
        if (detailed != null ? !detailed.equals(that.detailed) : that.detailed != null) return false;
        return original != null ? original.equals(that.original) : that.original == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (detailed != null ? detailed.hashCode() : 0);
        result = 31 * result + (original != null ? original.hashCode() : 0);
        return result;
    }
}
