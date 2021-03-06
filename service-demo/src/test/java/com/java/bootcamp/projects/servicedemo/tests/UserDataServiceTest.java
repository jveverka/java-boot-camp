package com.java.bootcamp.projects.servicedemo.tests;

import com.java.bootcamp.projects.javabean.UserData;
import com.java.bootcamp.projects.javabean.UserDataImmutable;
import com.java.bootcamp.projects.servicedemo.UserDataService;
import com.java.bootcamp.projects.servicedemo.UserDataServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDataServiceTest {

    @Test
    public void testUserDataService() {
        UserDataService userDataService = new UserDataServiceImpl();
        UserData userData01 = new UserDataImmutable(10L,"Joe","ADMIN");
        UserData userData02 = new UserDataImmutable(11L,"Jane","USER");
        UserData userData03 = new UserDataImmutable(12L,"Jessie","DEALER");

        assertTrue(userDataService.getSize() == 0);
        assertFalse(userDataService.getUserById(10L).isPresent());
        assertFalse(userDataService.getUserById(11L).isPresent());
        assertFalse(userDataService.getUserById(12L).isPresent());

        userDataService.addUser(userData01);
        assertTrue(userDataService.getSize() == 1);
        assertTrue(userDataService.getUserById(10L).isPresent());
        assertFalse(userDataService.getUserById(11L).isPresent());
        assertFalse(userDataService.getUserById(12L).isPresent());

        userDataService.addUser(userData02);
        assertTrue(userDataService.getSize() == 2);
        assertTrue(userDataService.getUserById(10L).isPresent());
        assertTrue(userDataService.getUserById(11L).isPresent());
        assertFalse(userDataService.getUserById(12L).isPresent());

        userDataService.addUser(userData03);
        assertTrue(userDataService.getSize() == 3);
        assertTrue(userDataService.getUserById(10L).isPresent());
        assertTrue(userDataService.getUserById(11L).isPresent());
        assertTrue(userDataService.getUserById(12L).isPresent());

        assertTrue(userDataService.removeAndGetUser(10L).isPresent());
        assertTrue(userDataService.removeAndGetUser(11L).isPresent());
        assertTrue(userDataService.removeAndGetUser(12L).isPresent());

        assertFalse(userDataService.removeAndGetUser(10L).isPresent());
        assertFalse(userDataService.removeAndGetUser(11L).isPresent());
        assertFalse(userDataService.removeAndGetUser(12L).isPresent());

    }

}
