package com.java.bootcamp.projects.servicedemo;

import com.java.bootcamp.projects.javabean.UserData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserDataServiceImpl implements UserDataService {

    private final Map<Long, UserData> users;

    public UserDataServiceImpl() {
        users = new ConcurrentHashMap<>();
    }

    @Override
    public Optional<UserData> getUserById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public void addUser(UserData user) {
        users.put(user.getId(), user);
    }

    @Override
    public Optional<UserData> removeAndGetUser(Long id) {
        return Optional.ofNullable(users.remove(id));
    }

    @Override
    public Collection<UserData> getUsers() {
        return Collections.unmodifiableCollection(new ArrayList<>(users.values()));
    }

    @Override
    public int getSize() {
        return users.size();
    }

}
