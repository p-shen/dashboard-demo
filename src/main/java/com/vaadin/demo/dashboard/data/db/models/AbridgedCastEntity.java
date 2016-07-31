package com.vaadin.demo.dashboard.data.db.models;

import com.vaadin.annotations.AutoGenerated;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Peter on 2016-07-29.
 */
@Entity
@Table(name = "abridged_cast", schema = "vaadin", catalog = "")
public class AbridgedCastEntity {

    private Long pid;
    private Long id;
    private String name;
    private List<String> characters;

    public AbridgedCastEntity() { }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pid", unique=true, nullable=false)
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ElementCollection
    @CollectionTable(name = "characters")
    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }
}