package com.java.bootcamp.projects.javabean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UserDataImmutable implements UserData {

    private final Long id;
    private final String userName;
    private final String role;

    @JsonCreator
    public UserDataImmutable(@JsonProperty("id") Long id,
                             @JsonProperty("userName") String userName,
                             @JsonProperty("role") String role) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(userName);
        Objects.requireNonNull(role);
        this.id = id;
        this.userName = userName;
        this.role = role;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDataImmutable that = (UserDataImmutable) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, role);
    }

    @Override
    public String toString() {
        return "UserDataImmutable{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
