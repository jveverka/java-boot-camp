package com.java.bootcamp.projects.annotations.test.di;

public class DataService {

    private final String data;

    public DataService(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

}
