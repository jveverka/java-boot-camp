package com.java.bootcamp.projects.mt.executor;

import com.java.bootcamp.projects.mt.executor.dto.Request;
import com.java.bootcamp.projects.mt.executor.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class DataServiceImpl implements DataService {

    private static final Logger LOG = LoggerFactory.getLogger(DataServiceImpl.class);

    private final ExecutorService executorService;

    public DataServiceImpl(int threadPoolSize) {
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    @Override
    public Future<Response> getData(Request request) {
        LOG.info("getData: {} {}/{}", request.getId(), request.getDelay(), request.getIterations());
        return this.executorService.submit(new DataServiceTask(request));
    }

    @Override
    public void close() throws Exception {
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }

}
