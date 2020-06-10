package com.java.bootcamp.projects.mt.executor;

import com.java.bootcamp.projects.mt.executor.dto.Request;
import com.java.bootcamp.projects.mt.executor.dto.Response;

import java.util.concurrent.Future;

/**
 * Asynchronous data-processing service.
 */
public interface DataService extends AutoCloseable {

    /**
     * Dispatch data processing request.
     * @param request - {@link Request} for data processing asynchronous task.
     * @return {@link Future} upcoming result.
     */
    Future<Response> getData(Request request);

}
