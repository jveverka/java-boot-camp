package com.java.bootcamp.projects.javabean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UserDataImmutable {

    private final long id;
    private final String userName;
    private final String role;

    @JsonCreator
    public UserDataImmutable(@JsonProperty("id") long id,
                             @JsonProperty("userName") String userName,
                             @JsonProperty("role") String role) {
        this.id = id;
        this.userName = userName;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDataImmutable that = (UserDataImmutable) o;
        return id == that.id &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, role);
    }

}
