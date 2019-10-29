package com.java.bootcamp.projects.mt.threadlocal;

import com.java.bootcamp.projects.mt.threadlocal.dto.Request;
import com.java.bootcamp.projects.mt.threadlocal.dto.Response;
import com.java.bootcamp.projects.mt.threadlocal.dto.TaskContext;

import java.util.concurrent.Future;

public interface Processor {

    Future<Response> getData(Request request, TaskContext taskContext);

}
