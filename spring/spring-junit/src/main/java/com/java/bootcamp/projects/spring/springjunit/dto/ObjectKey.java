package com.java.bootcamp.projects.spring.springjunit.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

public class ObjectKey {

    private final String key;

    @JsonCreator
    public ObjectKey(@JsonProperty("key") String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectKey objectKey = (ObjectKey) o;
        return Objects.equals(key, objectKey.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    public static ObjectKey from(String key) {
        return new ObjectKey(key);
    }

    public static ObjectKey random() {
        return new ObjectKey(UUID.randomUUID().toString());
    }

}
