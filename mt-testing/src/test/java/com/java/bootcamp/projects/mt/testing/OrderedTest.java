package com.java.bootcamp.projects.mt.testing;

import com.java.bootcamp.projects.mt.StatefulService;
import com.java.bootcamp.projects.mt.StatefulServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.SAME_THREAD)
class OrderedTest {

    private static StatefulService statefulService;

    @BeforeAll
    public static void init() {
        statefulService = new StatefulServiceImpl();
    }

    @Test
    @Order(1)
    void test001() {
        assertEquals(0L, statefulService.get());
    }

    @Test
    @Order(2)
    void test002() {
        assertEquals(7L, statefulService.add(7L));
    }

    @Test
    @Order(3)
    void test003() {
        assertEquals(10L, statefulService.add(3L));
    }

}
