package com.java.bootcamp.projects.servicedemo;

import java.text.ParseException;
import java.util.Date;

public interface StatelessService {

    String DATE_TIME_FORMAT_IN = "yyyy-MM-dd HH:mm:ss";

    Date getDate(String date) throws ParseException;

}
