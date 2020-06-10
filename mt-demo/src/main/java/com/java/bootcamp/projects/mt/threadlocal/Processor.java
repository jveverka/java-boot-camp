package com.java.bootcamp.projects.mt.threadlocal;

import com.java.bootcamp.projects.mt.threadlocal.dto.Request;
import com.java.bootcamp.projects.mt.threadlocal.dto.Response;
import com.java.bootcamp.projects.mt.threadlocal.dto.TaskContext;

import java.util.concurrent.Future;

/**
 * Asynchronous data-processing service.
 */
public interface Processor {

    /**
     * Dispatch data processing request.
     * @param request - {@link com.java.bootcamp.projects.mt.executor.dto.Request} for data processing asynchronous task.
     * @param taskContext - task context to pass.
     * @return {@link Future} upcoming result.
     */
    Future<Response> getData(Request request, TaskContext taskContext);

}
