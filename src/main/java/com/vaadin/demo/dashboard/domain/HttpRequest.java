package com.vaadin.demo.dashboard.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Peter on 2016-07-30.
 */
public class HttpRequest {

    public enum TYPE {
        GET,
        POST
    }

    private TYPE type;
    private Map<String, String> header = new HashMap<>();
    private String url;
    private String body;

    public HttpRequest(TYPE type, Map<String, String> header, String url, String body) {
        this.type = type;
        this.header = header;
        this.url = url;
        this.body = body;
    }

    public HttpRequest(TYPE type, Map header, String url) {
        this.type = type;
        this.header = header;
        this.url = url;
        this.body = "";
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
