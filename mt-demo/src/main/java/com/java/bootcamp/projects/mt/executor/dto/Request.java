package com.java.bootcamp.projects.mt.executor.dto;

import java.util.concurrent.TimeUnit;

public class Request {

    private final long id;
    private final int iterations;
    private final long delay;
    private final TimeUnit timeUnit;

    public Request(long id, int iterations, long delay, TimeUnit timeUnit) {
        this.id = id;
        this.iterations = iterations;
        this.delay = delay;
        this.timeUnit = timeUnit;
    }

    public int getIterations() {
        return iterations;
    }

    public long getDelay() {
        return delay;
    }

    public long getId() {
        return id;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

}
