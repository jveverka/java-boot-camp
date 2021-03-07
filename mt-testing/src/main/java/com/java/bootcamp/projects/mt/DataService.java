package com.java.bootcamp.projects.mt;

import java.util.concurrent.TimeUnit;

public interface DataService {

    Long getLifeUniverseEverything(Long duration, TimeUnit unit) throws InterruptedException;

    Integer add(Integer a, Integer b, Long duration, TimeUnit unit) throws InterruptedException;

}
