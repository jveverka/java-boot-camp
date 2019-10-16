package com.java.bootcamp.projects.servicedemo;

import com.java.bootcamp.projects.javabean.UserData;

import java.util.Collection;
import java.util.Optional;

public interface UserDataService {

    Optional<UserData> getUserById(Long id);

    void addUser(UserData user);

    Optional<UserData> removeAndGetUser(Long id);

    Collection<UserData> getUsers();

    int getSize();

}
