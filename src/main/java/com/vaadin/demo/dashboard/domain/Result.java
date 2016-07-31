package com.vaadin.demo.dashboard.domain;

/**
 * Created by Peter on 2016-07-30.
 */
public class Result {

    private String response;
    private int status;

    public Result(int status, String response) {
        this.status = status;
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
