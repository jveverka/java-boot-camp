package com.java.bootcamp.projects.servicedemo.tests;

import com.java.bootcamp.projects.javabean.UserData;
import com.java.bootcamp.projects.javabean.UserDataImmutable;
import com.java.bootcamp.projects.servicedemo.UserDataService;
import com.java.bootcamp.projects.servicedemo.UserDataServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class UserDataServiceTest {

    @Test
    public void testUserDataService() {
        UserDataService userDataService = new UserDataServiceImpl();
        UserData userData01 = new UserDataImmutable(10L,"Joe","ADMIN");
        UserData userData02 = new UserDataImmutable(11L,"Jane","USER");
        UserData userData03 = new UserDataImmutable(12L,"Jessie","DEALER");

        Assert.assertTrue(userDataService.getSize() == 0);
        Assert.assertFalse(userDataService.getUserById(10L).isPresent());
        Assert.assertFalse(userDataService.getUserById(11L).isPresent());
        Assert.assertFalse(userDataService.getUserById(12L).isPresent());

        userDataService.addUser(userData01);
        Assert.assertTrue(userDataService.getSize() == 1);
        Assert.assertTrue(userDataService.getUserById(10L).isPresent());
        Assert.assertFalse(userDataService.getUserById(11L).isPresent());
        Assert.assertFalse(userDataService.getUserById(12L).isPresent());

        userDataService.addUser(userData02);
        Assert.assertTrue(userDataService.getSize() == 2);
        Assert.assertTrue(userDataService.getUserById(10L).isPresent());
        Assert.assertTrue(userDataService.getUserById(11L).isPresent());
        Assert.assertFalse(userDataService.getUserById(12L).isPresent());

        userDataService.addUser(userData03);
        Assert.assertTrue(userDataService.getSize() == 3);
        Assert.assertTrue(userDataService.getUserById(10L).isPresent());
        Assert.assertTrue(userDataService.getUserById(11L).isPresent());
        Assert.assertTrue(userDataService.getUserById(12L).isPresent());

        Assert.assertTrue(userDataService.removeAndGetUser(10L).isPresent());
        Assert.assertTrue(userDataService.removeAndGetUser(11L).isPresent());
        Assert.assertTrue(userDataService.removeAndGetUser(12L).isPresent());

        Assert.assertFalse(userDataService.removeAndGetUser(10L).isPresent());
        Assert.assertFalse(userDataService.removeAndGetUser(11L).isPresent());
        Assert.assertFalse(userDataService.removeAndGetUser(12L).isPresent());

    }

}
