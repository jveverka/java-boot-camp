package com.java.bootcamp.projects.annotations.test.di;

import com.java.bootcamp.projects.di.annotations.InjectHere;
import com.java.bootcamp.projects.di.annotations.ManagedService;

@ManagedService
public class DataAndNameServiceUser {

    private final DataService dataService;
    private final NameService nameService;

    public DataAndNameServiceUser(@InjectHere DataService dataService,
                                  @InjectHere NameService nameService) {
        this.dataService = dataService;
        this.nameService = nameService;
    }

    public DataService getDataService() {
        return dataService;
    }

    public NameService getNameService() {
        return nameService;
    }

}
