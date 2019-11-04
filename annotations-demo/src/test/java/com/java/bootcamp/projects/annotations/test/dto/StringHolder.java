package com.java.bootcamp.projects.annotations.test.dto;

import java.util.ArrayList;
import java.util.List;

//@FunctionalInterface
@SuppressWarnings("deprecation")
@Deprecated
public class StringHolder {

    private final String data;
    private final List strings;

    public StringHolder(String data) {
        this.data = data;
        this.strings = new ArrayList();
    }

    public String getData() {
        return data;
    }

    @SuppressWarnings("unchecked")
    public void addString(String data) {
        this.strings.add(data);
    }

    @Override
    public String toString() {
        return data;
    }

}
