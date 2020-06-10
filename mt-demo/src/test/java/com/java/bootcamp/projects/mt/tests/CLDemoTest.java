package com.java.bootcamp.projects.mt.tests;

import com.java.bootcamp.projects.mt.cl.CLDemo;
import com.java.bootcamp.projects.mt.cl.CLTask;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CLDemoTest {

    private static final Logger LOG = LoggerFactory.getLogger(CLDemoTest.class);
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Test
    public void testCountDownLatchDemo() throws InterruptedException {
        LOG.info("TEST TEST");
        CLDemo clDemo = new CLDemo();
        CLTask clTask = new CLTask(clDemo);
        assertNotNull(executorService);
        executorService.submit(clTask);
        clDemo.await(10, TimeUnit.SECONDS);
        assertTrue(clDemo.isClicked());
    }

}
