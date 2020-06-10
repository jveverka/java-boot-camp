package com.java.bootcamp.projects.mt.tests;

import com.java.bootcamp.projects.mt.executor.DataService;
import com.java.bootcamp.projects.mt.executor.DataServiceImpl;
import com.java.bootcamp.projects.mt.executor.dto.Request;
import com.java.bootcamp.projects.mt.executor.dto.Response;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class DataServiceTest {

    @Test
    public void testBackgroundDataProcessing() throws Exception {
        DataService dataService = new DataServiceImpl(8);
        Future<Response> data1 = dataService.getData(new Request(1L, 10, 1, TimeUnit.SECONDS));
        Future<Response> data2 = dataService.getData(new Request(2L, 2, 3, TimeUnit.SECONDS));
        Future<Response> data3 = dataService.getData(new Request(3L, 5, 2, TimeUnit.SECONDS));

        String thisThreadName = Thread.currentThread().getName();

        assertNotNull(data1.get());
        assertEquals(1L, data1.get().getRequestId());
        assertFalse(thisThreadName.equals(data1.get().getThreadName()));

        assertNotNull(data2.get());
        assertEquals(2L, data2.get().getRequestId());
        assertFalse(thisThreadName.equals(data2.get().getThreadName()));

        assertNotNull(data3.get());
        assertEquals(3L,  data3.get().getRequestId());
        assertFalse(thisThreadName.equals(data3.get().getThreadName()));

        dataService.close();
    }

}
