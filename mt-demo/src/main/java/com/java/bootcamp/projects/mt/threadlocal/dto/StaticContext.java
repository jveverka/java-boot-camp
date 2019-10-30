package com.java.bootcamp.projects.mt.threadlocal.dto;

public class StaticContext <T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
