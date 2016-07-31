package com.vaadin.demo.dashboard.data.http;

import com.vaadin.demo.dashboard.domain.HttpRequest;
import com.vaadin.demo.dashboard.domain.Result;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Peter on 2016-07-30.
 */
public class HttpRequestService {

    private static OkHttpClient httpClient = new OkHttpClient();
    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static Result request(HttpRequest httpRequest){
        switch (httpRequest.getType()){
            case GET:
                return getRequest(httpRequest);
            case POST:
                return postRequest(httpRequest);
            default:
                return new Result(400, "No HTTP request type specified");
        }

    }

    private static Result getRequest(HttpRequest httpRequest) {
        Request.Builder builder = new Request.Builder()
                .url(httpRequest.getUrl());

        for (Map.Entry<String, String> entry : httpRequest.getHeader().entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }

        Request request = builder.build();

        try (Response response = httpClient.newCall(request).execute()) {
            return new Result(response.code(), response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Result postRequest(HttpRequest httpRequest) {
        RequestBody body = RequestBody.create(JSON, httpRequest.getBody());
        Request.Builder builder = new Request.Builder()
                .url(httpRequest.getUrl())
                .post(body);

        for (Map.Entry<String, String> entry : httpRequest.getHeader().entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }

        Request request = builder.build();

        try {
            Response response = httpClient.newCall(request).execute();
            return new Result(response.code(), response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


}
