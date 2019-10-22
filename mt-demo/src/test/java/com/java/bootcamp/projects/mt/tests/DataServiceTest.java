package com.java.bootcamp.projects.mt.tests;

import com.java.bootcamp.projects.mt.DataService;
import com.java.bootcamp.projects.mt.DataServiceImpl;
import com.java.bootcamp.projects.mt.dto.Request;
import com.java.bootcamp.projects.mt.dto.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Future;

public class DataServiceTest {

    @Test
    public void testBackgroundDataProcessing() throws Exception {
        DataService dataService = new DataServiceImpl(8);
        Future<Response> data1 = dataService.getData(new Request(1L, 10, 1000));
        Future<Response> data2 = dataService.getData(new Request(2L, 1, 10000));
        Future<Response> data3 = dataService.getData(new Request(3L, 5, 2000));

        String thisThreadName = Thread.currentThread().getName();

        Assert.assertNotNull(data1.get());
        Assert.assertTrue(data1.get().getRequestId() == 1L);
        Assert.assertFalse(thisThreadName.equals(data1.get().getThreadName()));

        Assert.assertNotNull(data2.get());
        Assert.assertTrue(data2.get().getRequestId() == 2L);
        Assert.assertFalse(thisThreadName.equals(data2.get().getThreadName()));

        Assert.assertNotNull(data3.get());
        Assert.assertTrue(data3.get().getRequestId() == 3L);
        Assert.assertFalse(thisThreadName.equals(data3.get().getThreadName()));

        dataService.close();
    }

}
