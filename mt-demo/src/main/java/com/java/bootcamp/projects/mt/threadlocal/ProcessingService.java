package com.java.bootcamp.projects.mt.threadlocal;

import com.java.bootcamp.projects.mt.threadlocal.dto.Request;
import com.java.bootcamp.projects.mt.threadlocal.dto.Response;
import com.java.bootcamp.projects.mt.threadlocal.dto.TaskContext;

public class ProcessingService {

    public Response getData(Request request) {
        TaskContext tlTaskContext = ProcessingTask.threadLocalContext.get();
        TaskContext staticTaskContext = ProcessingTask.staticContext.getData();
        return new Response(request.getRequest(), "response",
                tlTaskContext.getUserName(), staticTaskContext.getUserName());
    }

}
