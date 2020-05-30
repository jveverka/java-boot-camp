package com.java.bootcamp.projects.spring.springjunit.service;

import com.java.bootcamp.projects.spring.springjunit.dto.ObjectKey;

import java.util.Collection;
import java.util.Optional;

/**
 * Generic IN-Memory Object cache service.
 */
public interface CacheService {

    /**
     * Add object into cache. In case cache contains object under object key, original object gets overwritten.
     * @param key - Unique key of the object.
     * @param value - Object instance.
     */
    void put(ObjectKey key, Object value);

    /**
     * Remove object form cache.
     * @param key - Unique key of the object.
     * @return true if object was present and removed from cache, false otherwise.
     */
    boolean remove(ObjectKey key);

    /**
     * Get object from cache by unique key.
     * @param key - Unique key of the object.
     * @param type - Class type of expected object.
     * @param <T>  - Type of expected object.
     * @return Object instance for provided unique object key or empty if such object id not in cache.
     */
    <T> Optional<T> get(ObjectKey key, Class<T> type);

    /**
     * Get objects from cache by type.
     * @param type - Class type of expected object.
     * @param <T> - Type of expected object.
     * @return Collection of objects of provided type present in the cache.
     */
    <T> Collection<T> get(Class<T> type);

    /**
     * Get number of objects in the cache.
     * @return Size of the object cache.
     */
    int getSize();

}
