package com.java.bootcamp.projects.servicedemo.tests;

import com.java.bootcamp.projects.servicedemo.StatelessService;
import com.java.bootcamp.projects.servicedemo.StatelessServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class StatelessServiceTest {

    private static StatelessService statelessService;

    @BeforeAll
    public static void init() {
        statelessService = new StatelessServiceImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = { "2019-12-01 11:12:30", "2019-08-22 22:08:09" })
    public void testStatelessPositive(String dateTime) throws ParseException {
        Date date = statelessService.getDate(dateTime);
        assertNotNull(date);
        String result = statelessService.getDate(date);
        assertNotNull(result);
        assertEquals(dateTime, result);
    }

    @ParameterizedTest
    @ValueSource(strings = { "xxx", "zzz" })
    public void testStatelessNegative(String dateTime) {
        try {
            statelessService.getDate(dateTime);
            fail();
        } catch (ParseException e) {
        }
    }

}
