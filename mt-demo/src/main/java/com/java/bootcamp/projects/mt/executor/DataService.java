package com.java.bootcamp.projects.mt.executor;

import com.java.bootcamp.projects.mt.executor.dto.Request;
import com.java.bootcamp.projects.mt.executor.dto.Response;

import java.util.concurrent.Future;

public interface DataService extends AutoCloseable {

    Future<Response> getData(Request request);

}
