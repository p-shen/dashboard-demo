package com.vaadin.demo.dashboard.domain.Flickr;

import java.util.List;

/**
 * Created by Peter on 2016-07-31.
 */
public class Flickr {

    private String title;
    private String link;
    private String description;
    private String modified;
    private String generator;
    private List<FlickrItem> items;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public List<FlickrItem> getItems() {
        return items;
    }

    public void setItems(List<FlickrItem> items) {
        this.items = items;
    }
}
