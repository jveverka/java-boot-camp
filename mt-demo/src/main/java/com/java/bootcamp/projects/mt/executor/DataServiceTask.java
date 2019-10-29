package com.java.bootcamp.projects.mt.executor;

import com.java.bootcamp.projects.mt.executor.dto.Request;
import com.java.bootcamp.projects.mt.executor.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class DataServiceTask implements Callable<Response> {

    private static final Logger LOG = LoggerFactory.getLogger(DataServiceTask.class);

    private final Request request;

    public DataServiceTask(Request request) {
        this.request = request;
    }

    @Override
    public Response call() throws Exception {
        LOG.info("DataServiceTask: {} started ...", request.getId());
        for (int i=0; i<request.getIterations(); i++) {
            Thread.sleep(request.getDelay());
        }
        LOG.info("DataServiceTask: {} done.", request.getId());
        return new Response(request.getId(), Thread.currentThread().getName());
    }

}
