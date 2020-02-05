package com.java.bootcamp.projects.servicedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StatelessServiceImpl implements StatelessService {

    @Override
    public Date getDate(String dateTime) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_IN);
        return dateFormat.parse(dateTime);
    }

    @Override
    public String getDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_IN);
        return dateFormat.format(date);
    }

}
