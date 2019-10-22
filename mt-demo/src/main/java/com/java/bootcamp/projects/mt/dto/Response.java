package com.java.bootcamp.projects.mt.dto;

public class Response {

    private final long requestId;
    private final String threadName;

    public Response(long requestId, String threadName) {
        this.requestId = requestId;
        this.threadName = threadName;
    }

    public long getRequestId() {
        return requestId;
    }

    public String getThreadName() {
        return threadName;
    }
}
