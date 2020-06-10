package com.java.bootcamp.projects.mt.tests;

import com.java.bootcamp.projects.mt.threadlocal.Processor;
import com.java.bootcamp.projects.mt.threadlocal.ProcessorImpl;
import com.java.bootcamp.projects.mt.threadlocal.dto.Request;
import com.java.bootcamp.projects.mt.threadlocal.dto.Response;
import com.java.bootcamp.projects.mt.threadlocal.dto.TaskContext;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ThreadLocalTest {

    @Test
    public void testThreadLocal() throws Exception {
        Processor processor = new ProcessorImpl();

        Request request1 = new Request("r1");
        TaskContext tc1 = new TaskContext("joe", "user");
        Request request2 = new Request("r2");
        TaskContext tc2 = new TaskContext("jane", "admin");

        Future<Response> f1 = processor.getData(request1, tc1);
        Future<Response> f2 = processor.getData(request2, tc2);

        assertNotNull(f1.get());
        assertEquals("r1", f1.get().getRequest());
        assertEquals("response", f1.get().getResponse());
        assertEquals("joe", f1.get().getThreadLocalContext());
        assertEquals("jane", f1.get().getStaticContext());

        assertNotNull(f2.get());
        assertEquals("r2", f2.get().getRequest());
        assertEquals("response", f2.get().getResponse());
        assertEquals("jane", f2.get().getThreadLocalContext());
        assertEquals("jane", f1.get().getStaticContext());

    }

}
