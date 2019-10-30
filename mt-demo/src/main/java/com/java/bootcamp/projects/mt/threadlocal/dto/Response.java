package com.java.bootcamp.projects.mt.threadlocal.dto;

public class Response {

    private final String request;
    private final String response;
    private final String threadLocalContext;
    private final String staticContext;

    public Response(String request, String response, String threadLocalContext, String staticContext) {
        this.request = request;
        this.response = response;
        this.threadLocalContext = threadLocalContext;
        this.staticContext = staticContext;
    }

    public String getRequest() {
        return request;
    }

    public String getResponse() {
        return response;
    }

    public String getThreadLocalContext() {
        return threadLocalContext;
    }

    public String getStaticContext() {
        return staticContext;
    }
    
}
