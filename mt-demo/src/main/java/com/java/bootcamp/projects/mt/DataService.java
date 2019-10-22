package com.java.bootcamp.projects.mt;

import com.java.bootcamp.projects.mt.dto.Request;
import com.java.bootcamp.projects.mt.dto.Response;

import java.util.concurrent.Future;

public interface DataService extends AutoCloseable {

    Future<Response> getData(Request request);

}
