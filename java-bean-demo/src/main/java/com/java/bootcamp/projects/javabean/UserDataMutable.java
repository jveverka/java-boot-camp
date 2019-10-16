package com.java.bootcamp.projects.javabean;

import java.util.Objects;

public class UserDataMutable implements UserData {

    private Long id;
    private String userName;
    private String role;

    public UserDataMutable() {
    }

    public UserDataMutable(Long id, String userName, String role) {
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

    public void setId(Long id) {
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
        return "UserDataMutable{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
