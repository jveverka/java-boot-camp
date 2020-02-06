package com.java.bootcamp.projects.annotations.test.di;

import com.java.bootcamp.projects.di.InjectHere;
import com.java.bootcamp.projects.di.ManagedService;

@ManagedService
public class DataServiceUser {

    private final DataService dataService;

    public DataServiceUser(@InjectHere DataService dataService) {
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }

}
