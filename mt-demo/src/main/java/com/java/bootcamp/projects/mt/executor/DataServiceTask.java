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
        long timeStamp = System.nanoTime();
        LOG.info("DataServiceTask: {} started ...", request.getId());
        for (int i=0; i<request.getIterations(); i++) {
            LOG.info("  counting {}/{}", Thread.currentThread().getName(), i);
            Thread.sleep(request.getTimeUnit().toMillis(request.getDelay()));
        }
        float duration = (System.nanoTime() - timeStamp)/1_000_000F;
        LOG.info("DataServiceTask: {} done in {}ms.", request.getId(), duration);
        return new Response(request.getId(), Thread.currentThread().getName(), duration);
    }

}
