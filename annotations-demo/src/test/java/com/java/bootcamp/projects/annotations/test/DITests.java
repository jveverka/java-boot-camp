package com.java.bootcamp.projects.annotations.test;

import com.java.bootcamp.projects.annotations.test.di.DataAndNameServiceUser;
import com.java.bootcamp.projects.annotations.test.di.DataServiceUser;
import com.java.bootcamp.projects.annotations.test.di.NameServiceUser;
import com.java.bootcamp.projects.annotations.test.di.SimpleService;
import com.java.bootcamp.projects.di.DependencyInjector;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DITests {

    @Test
    public void testDI() throws IOException, ClassNotFoundException {
        Map<Class<?>, Object> classObjectMap = DependencyInjector.scanClassPath("com.java.bootcamp.projects.annotations.test.di");
        assertNotNull(classObjectMap);
        assertTrue(classObjectMap.size() == 4);
        DataAndNameServiceUser dataAndNameServiceUser = (DataAndNameServiceUser)classObjectMap.get(DataAndNameServiceUser.class);
        assertNotNull(dataAndNameServiceUser.getDataService());
        assertNotNull(dataAndNameServiceUser.getNameService());
        DataServiceUser dataServiceUser = (DataServiceUser)classObjectMap.get(DataServiceUser.class);
        assertNotNull(dataServiceUser.getDataService());
        NameServiceUser nameServiceUser = (NameServiceUser)classObjectMap.get(NameServiceUser.class);
        assertNotNull(nameServiceUser.getNameService());
        SimpleService simpleService = (SimpleService)classObjectMap.get(SimpleService.class);
        assertNotNull(simpleService);
    }

}
