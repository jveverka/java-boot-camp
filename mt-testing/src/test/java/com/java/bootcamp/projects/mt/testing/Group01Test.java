package com.java.bootcamp.projects.mt.testing;

import com.java.bootcamp.projects.mt.DataService;
import com.java.bootcamp.projects.mt.DataServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.SAME_THREAD)
class Group01Test {

    private static DataService dataService = new DataServiceImpl();;

    @BeforeAll
    public static void init() {
        //dataService = new DataService();
    }

    @Test
    @DisplayName("G1 Test001")
    void test001() throws InterruptedException {
        Long result = dataService.getLifeUniverseEverything(5L, TimeUnit.SECONDS);
        assertEquals(42L, result);
    }

    @Test
    @DisplayName("G1 Test002")
    void test002() throws InterruptedException {
        Long result = dataService.getLifeUniverseEverything(5L, TimeUnit.SECONDS);
        assertEquals(42L, result);
    }

    @Test
    @DisplayName("G1 Test003")
    void test003() throws InterruptedException {
        Long result = dataService.getLifeUniverseEverything(5L, TimeUnit.SECONDS);
        assertEquals(42L, result);
    }

}
