package com.java.bootcamp.projects.mt;

import java.util.concurrent.atomic.AtomicLong;

public class StatefulServiceImpl implements StatefulService {

    private final AtomicLong value;

    public StatefulServiceImpl() {
        this.value = new AtomicLong(0);
    }

    @Override
    public Long add(Long value) {
        return this.value.addAndGet(value);
    }

    @Override
    public Long reset() {
        return this.value.getAndSet(0);
    }

    @Override
    public Long get() {
        return this.value.get();
    }

}
