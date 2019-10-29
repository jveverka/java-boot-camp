package com.java.bootcamp.projects.mt.threadlocal.dto;

public class TaskContext {

    private final String userName;
    private final String role;

    public TaskContext(String userName, String role) {
        this.userName = userName;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

}
