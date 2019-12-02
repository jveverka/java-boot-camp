package com.java.bootcamp.projects.spring.springjunit.service;

import java.util.Optional;

public interface CacheService {

    void put(String key, Object value);

    boolean remove(String key);

    <T> Optional<T> get(String key, Class<T> type);

    int getSize();

}
