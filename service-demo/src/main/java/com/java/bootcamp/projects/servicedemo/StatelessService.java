package com.java.bootcamp.projects.servicedemo;

import java.text.ParseException;
import java.util.Date;

/**
 * Date formatting service.
 */
public interface StatelessService {

    String DATE_TIME_FORMAT_IN = "yyyy-MM-dd HH:mm:ss";

    /**
     * Create {@link Date} from input data {@link String}
     * @param date
     * @return
     * @throws ParseException
     */
    Date getDate(String date) throws ParseException;

    String getDate(Date date);

}
