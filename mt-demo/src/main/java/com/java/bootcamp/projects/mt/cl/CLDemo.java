package com.java.bootcamp.projects.mt.cl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CLDemo {

    private final CountDownLatch cl;
    private boolean clicked;

    public CLDemo() {
        this.cl = new CountDownLatch(1);
        this.clicked = false;
    }

    public void click() {
        this.clicked = true;
        this.cl.countDown();
    }

    public boolean await(long timeout, TimeUnit timeUnit) throws InterruptedException{
        return this.cl.await(timeout, timeUnit);
    }

    public boolean isClicked() {
        return clicked;
    }

}
