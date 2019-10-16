package com.java.bootcamp.projects.servicedemo;

import com.java.bootcamp.projects.javabean.UserData;

import java.util.Collection;
import java.util.Optional;

/**
 * UserData service acting as data store
 */
public interface UserDataService {

    /**
     * Get {@link UserData} by user ID.
     * @param id valid user ID.
     * @return {@link UserData} {@link Optional} or empty if ID is invalid.
     */
    Optional<UserData> getUserById(Long id);

    /**
     * Insert {@link UserData} into data store.
     * @param user {@link UserData} to insert.
     */
    void addUser(UserData user);

    /**
     * Remove {@link UserData} id present in data store.
     * @param id of {@link UserData} to be removed;
     * @return removed {@link UserData} {@link Optional} or empty if ID is invalid.
     */
    Optional<UserData> removeAndGetUser(Long id);

    /**
     * Get content of the data store.
     * @return immutable copy of userdata list.
     */
    Collection<UserData> getUsers();

    /**
     * Get number of {@link UserData} records in this data store.
     * @return
     */
    int getSize();

}
