package com.java.bootcamp.projects.javabean;

import java.util.Objects;

public class UserDataMutable {

    private long id;
    private String userName;
    private String role;

    public UserDataMutable() {
    }

    public UserDataMutable(long id, String userName, String role) {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDataMutable that = (UserDataMutable) o;
        return id == that.id &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, role);
    }

}
