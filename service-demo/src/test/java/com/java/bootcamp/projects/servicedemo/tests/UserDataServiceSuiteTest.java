package com.java.bootcamp.projects.servicedemo.tests;

import com.java.bootcamp.projects.javabean.UserData;
import com.java.bootcamp.projects.javabean.UserDataImmutable;
import com.java.bootcamp.projects.servicedemo.UserDataService;
import com.java.bootcamp.projects.servicedemo.UserDataServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDataServiceSuiteTest {

    private static UserDataService userDataService;
    private static UserData userData01;
    private static UserData userData02;
    private static UserData userData03;

    @BeforeAll
    public static void init() {
        userDataService = new UserDataServiceImpl();
        userData01 = new UserDataImmutable(10L,"Joe","ADMIN");
        userData02 = new UserDataImmutable(11L,"Jane","USER");
        userData03 = new UserDataImmutable(12L,"Jessie","DEALER");
    }

    @Test
    @Order(1)
    public void testEmptyUserDataService() {
        assertTrue(userDataService.getSize() == 0);
        assertFalse(userDataService.getUserById(10L).isPresent());
        assertFalse(userDataService.getUserById(11L).isPresent());
        assertFalse(userDataService.getUserById(12L).isPresent());
    }

    @Test
    @Order(2)
    public void testAddFirstUserDataService() {
        userDataService.addUser(userData01);
        assertTrue(userDataService.getSize() == 1);
        assertTrue(userDataService.getUserById(10L).isPresent());
        assertFalse(userDataService.getUserById(11L).isPresent());
        assertFalse(userDataService.getUserById(12L).isPresent());
    }

    @Test
    @Order(3)
    public void testAddSecondUserDataService() {
        userDataService.addUser(userData02);
        assertTrue(userDataService.getSize() == 2);
        assertTrue(userDataService.getUserById(10L).isPresent());
        assertTrue(userDataService.getUserById(11L).isPresent());
        assertFalse(userDataService.getUserById(12L).isPresent());
    }

    @Test
    @Order(4)
    public void testAddThirdUserDataService() {
        userDataService.addUser(userData03);
        assertTrue(userDataService.getSize() == 3);
        assertTrue(userDataService.getUserById(10L).isPresent());
        assertTrue(userDataService.getUserById(11L).isPresent());
        assertTrue(userDataService.getUserById(12L).isPresent());
    }

    @Test
    @Order(5)
    public void testRemoveUserDataService() {
        assertTrue(userDataService.removeAndGetUser(10L).isPresent());
        assertTrue(userDataService.removeAndGetUser(11L).isPresent());
        assertTrue(userDataService.removeAndGetUser(12L).isPresent());
    }

    @Test
    @Order(6)
    public void testRemoveNegativeUserDataService() {
        assertFalse(userDataService.removeAndGetUser(10L).isPresent());
        assertFalse(userDataService.removeAndGetUser(11L).isPresent());
        assertFalse(userDataService.removeAndGetUser(12L).isPresent());
    }

}
