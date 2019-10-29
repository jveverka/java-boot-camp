package com.java.bootcamp.projects.mt.threadlocal.dto;

public class Response {

    private final String request;
    private final String response;
    private final String userName;

    public Response(String request, String response, String userName) {
        this.request = request;
        this.response = response;
        this.userName = userName;
    }

    public String getRequest() {
        return request;
    }

    public String getResponse() {
        return response;
    }

    public String getUserName() {
        return userName;
    }
}
