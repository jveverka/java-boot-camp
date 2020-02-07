package com.java.bootcamp.projects.annotations.test.di;

import com.java.bootcamp.projects.di.annotations.InjectHere;
import com.java.bootcamp.projects.di.annotations.ManagedService;

@ManagedService
public class NameServiceUser {

    private final NameService nameService;

    public NameServiceUser(@InjectHere NameService nameService) {
        this.nameService = nameService;
    }

    public NameService getNameService() {
        return nameService;
    }

}
