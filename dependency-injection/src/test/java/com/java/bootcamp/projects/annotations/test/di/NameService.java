package com.java.bootcamp.projects.annotations.test.di;

public class NameService {

    private final String name;

    public NameService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
