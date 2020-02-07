package com.java.bootcamp.projects.annotations.test;

import com.java.bootcamp.projects.annotations.test.di.DataAndNameServiceUser;
import com.java.bootcamp.projects.annotations.test.di.DataServiceUser;
import com.java.bootcamp.projects.annotations.test.di.NameServiceUser;
import com.java.bootcamp.projects.annotations.test.di.NotManagedService;
import com.java.bootcamp.projects.annotations.test.di.SimpleService;
import com.java.bootcamp.projects.di.DependencyInjector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DITests {

    private static DependencyInjector dependencyInjector;

    @BeforeAll
    public static void init() throws IOException, ClassNotFoundException {
        dependencyInjector = new DependencyInjector();
        dependencyInjector.scanClassPath("com.java.bootcamp.projects.annotations.test.di");
    }


    @Test
    public void testDataAndNameServiceInjection() {
        DataAndNameServiceUser dataAndNameServiceUser = dependencyInjector.getManagedService(DataAndNameServiceUser.class).get();
        assertNotNull(dataAndNameServiceUser.getDataService());
        assertNotNull(dataAndNameServiceUser.getNameService());
    }

    @Test
    public void testDataServiceUserInjection() {
        DataServiceUser dataServiceUser = dependencyInjector.getManagedService(DataServiceUser.class).get();
        assertNotNull(dataServiceUser.getDataService());
    }

    @Test
    public void testNameServiceUserInjection() {
        NameServiceUser nameServiceUser = dependencyInjector.getManagedService(NameServiceUser.class).get();
        assertNotNull(nameServiceUser.getNameService());
    }

    @Test
    public void testSimpleServiceInjection() {
        SimpleService simpleService = dependencyInjector.getManagedService(SimpleService.class).get();
        assertNotNull(simpleService);
    }

    @Test
    public void testNotManagedServiceInjection() {
        Optional<NotManagedService> managedService = dependencyInjector.getManagedService(NotManagedService.class);
        assertTrue(managedService.isEmpty());
    }

}