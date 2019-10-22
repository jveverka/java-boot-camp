package com.java.bootcamp.projects.mt.dto;

public class Request {

    private final long id;
    private final int iterations;
    private final int delay;

    public Request(long id, int iterations, int delay) {
        this.id = id;
        this.iterations = iterations;
        this.delay = delay;
    }

    public int getIterations() {
        return iterations;
    }

    public int getDelay() {
        return delay;
    }

    public long getId() {
        return id;
    }
}
