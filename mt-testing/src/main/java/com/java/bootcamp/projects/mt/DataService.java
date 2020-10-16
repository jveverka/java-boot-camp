package com.java.bootcamp.projects.mt;

import java.util.concurrent.TimeUnit;

public class DataService {

    public synchronized Long getLifeUniverseEverything(Long duration, TimeUnit unit) throws InterruptedException {
        wait(unit.toMillis(duration));
        return 42L;
    }

    public synchronized Integer add(Integer a, Integer b, Long duration, TimeUnit unit) throws InterruptedException {
        wait(unit.toMillis(duration));
        return a + b;
    }

}
