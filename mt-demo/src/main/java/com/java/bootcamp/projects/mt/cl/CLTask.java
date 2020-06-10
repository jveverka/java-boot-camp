package com.java.bootcamp.projects.mt.cl;

public class CLTask implements Runnable {

    private final CLDemo clDemo;

    public CLTask(CLDemo clDemo) {
        this.clDemo = clDemo;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            clDemo.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
