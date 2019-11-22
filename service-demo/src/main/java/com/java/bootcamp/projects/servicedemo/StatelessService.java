package com.java.bootcamp.projects.servicedemo;

import java.text.ParseException;
import java.util.Date;

public interface StatelessService {

    Date getDate(String date) throws ParseException;

}
