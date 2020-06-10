package com.java.bootcamp.projects.mt.executor.dto;

public class Response {

    private final long requestId;
    private final String threadName;
    private final float durationMs;

    public Response(long requestId, String threadName, float durationMs) {
        this.requestId = requestId;
        this.threadName = threadName;
        this.durationMs = durationMs;
    }

    public long getRequestId() {
        return requestId;
    }

    public String getThreadName() {
        return threadName;
    }

    public float getDurationMs() {
        return durationMs;
    }

}
