package com.java.bootcamp.projects.mt.threadlocal;

import com.java.bootcamp.projects.mt.threadlocal.dto.Request;
import com.java.bootcamp.projects.mt.threadlocal.dto.Response;
import com.java.bootcamp.projects.mt.threadlocal.dto.TaskContext;

public class ProcessingService {

    public Response getData(Request request) {
        TaskContext taskContext = ProcessingTask.localTaskContext.get();
        return new Response(request.getRequest(), "response", taskContext.getUserName());
    }

}
