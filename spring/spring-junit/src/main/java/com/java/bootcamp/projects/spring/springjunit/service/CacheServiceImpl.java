package com.java.bootcamp.projects.spring.springjunit.service;

import com.java.bootcamp.projects.spring.springjunit.dto.ObjectKey;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class CacheServiceImpl implements CacheService {

    private final Map<ObjectKey, Object> data;

    public CacheServiceImpl() {
        this.data = new ConcurrentHashMap<>();
    }

    @Override
    public void put(ObjectKey key, Object value) {
        this.data.put(key, value);
    }

    @Override
    public boolean remove(ObjectKey key) {
        Object removed = this.data.remove(key);
        return (removed != null);
    }

    @Override
    public <T> Optional<T> get(ObjectKey key, Class<T> type) {
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
    public <T> Collection<T> get(Class<T> type) {
        return data.values()
                .stream()
                .filter(o -> o.getClass().equals(type))
                .map(o -> type.cast(o))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public int getSize() {
        return this.data.size();
    }

}
