package com.java.bootcamp.projects.spring.springjunit.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheServiceImpl implements CacheService {

    private final Map<String, Object> data;

    public CacheServiceImpl() {
        this.data = new ConcurrentHashMap<>();
    }

    @Override
    public void put(String key, Object value) {
        this.data.put(key, value);
    }

    @Override
    public boolean remove(String key) {
        Object removed = this.data.remove(key);
        return (removed != null);
    }

    @Override
    public <T> Optional<T> get(String key, Class<T> type) {
        try {
            Object value = this.data.get(key);
            if (value != null) {
                return Optional.of(type.cast(value));
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public int getSize() {
        return this.data.size();
    }

}
