package com.java.bootcamp.projects.annotations.test.di;

import com.java.bootcamp.projects.di.annotations.InjectHere;

public class NotManagedService {

    private final DataService dataService;

    public NotManagedService(@InjectHere DataService dataService) {
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }

}
