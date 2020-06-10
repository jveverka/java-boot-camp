package com.java.bootcamp.projects.mt.threadlocal;

import com.java.bootcamp.projects.mt.threadlocal.dto.Request;
import com.java.bootcamp.projects.mt.threadlocal.dto.Response;
import com.java.bootcamp.projects.mt.threadlocal.dto.TaskContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class ProcessorImpl implements Processor {

    @Override
    public Future<Response> getData(Request request, TaskContext taskContext) {
        CompletableFuture<Response> response = new CompletableFuture<>();
        ProcessingTask task = new ProcessingTask(request, taskContext, response);
        new Thread(task).start();
        return response;
    }

}
