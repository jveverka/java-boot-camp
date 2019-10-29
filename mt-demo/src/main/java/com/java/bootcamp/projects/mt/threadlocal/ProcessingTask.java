package com.java.bootcamp.projects.mt.threadlocal;

import com.java.bootcamp.projects.mt.threadlocal.dto.Request;
import com.java.bootcamp.projects.mt.threadlocal.dto.Response;
import com.java.bootcamp.projects.mt.threadlocal.dto.TaskContext;

import java.util.concurrent.CompletableFuture;

public class ProcessingTask implements Runnable {

    public static final ThreadLocal<TaskContext> localTaskContext = new ThreadLocal<>();

    private final Request request;
    private final ProcessingService processingService;
    private final TaskContext taskContext;
    private final CompletableFuture<Response> cfResponse;

    public ProcessingTask(Request request, TaskContext taskContext, CompletableFuture<Response> cfResponse) {
        this.request = request;
        this.taskContext = taskContext;
        this.processingService = new ProcessingService();
        this.cfResponse = cfResponse;
    }

    @Override
    public void run() {
        try {
            localTaskContext.set(taskContext);
            Thread.sleep(1000);
            Response response = processingService.getData(request);
            cfResponse.complete(response);
        } catch (Exception e) {
            cfResponse.completeExceptionally(e);
        }
    }
}
