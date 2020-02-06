package com.java.bootcamp.projects.annotations.test.di;

import com.java.bootcamp.projects.di.InjectableFactory;

public class ServiceFactory {

    @InjectableFactory
    public NameService createNameService() {
        return new NameService("Name1");
    }

    @InjectableFactory
    public DataService createDataService() {
        return new DataService("Data1");
    }

}
