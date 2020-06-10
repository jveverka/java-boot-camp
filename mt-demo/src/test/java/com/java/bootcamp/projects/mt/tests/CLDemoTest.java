package com.java.bootcamp.projects.mt.tests;

import com.java.bootcamp.projects.mt.cl.CLDemo;
import com.java.bootcamp.projects.mt.cl.CLTask;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CLDemoTest {

    private static ExecutorService executorService;

    @BeforeAll
    public static void init() {
        executorService = Executors.newSingleThreadExecutor();
    }

    @Test
    public void testCountDownLatchDemo() throws InterruptedException {
        CLDemo clDemo = new CLDemo();
        CLTask clTask = new CLTask(clDemo);
        executorService.submit(clTask);
        clDemo.await(10, TimeUnit.SECONDS);
        assertTrue(clDemo.isClicked());
    }

    @AfterAll
    public static void shutdown() throws InterruptedException {
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }

}
