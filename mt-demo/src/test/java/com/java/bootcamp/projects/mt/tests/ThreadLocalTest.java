package com.java.bootcamp.projects.mt.tests;

import com.java.bootcamp.projects.mt.threadlocal.Processor;
import com.java.bootcamp.projects.mt.threadlocal.ProcessorImpl;
import com.java.bootcamp.projects.mt.threadlocal.dto.Request;
import com.java.bootcamp.projects.mt.threadlocal.dto.Response;
import com.java.bootcamp.projects.mt.threadlocal.dto.TaskContext;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Future;

public class ThreadLocalTest {

    @Test
    public void testThreadLocal() throws Exception {
        Processor processor = new ProcessorImpl(8);

        Request request1 = new Request("r1");
        TaskContext tc1 = new TaskContext("joe", "user");
        Request request2 = new Request("r2");
        TaskContext tc2 = new TaskContext("jane", "admin");

        Future<Response> f1 = processor.getData(request1, tc1);
        Future<Response> f2 = processor.getData(request2, tc2);

        Assert.assertNotNull(f1.get());
        Assert.assertEquals(f1.get().getRequest(), "r1");
        Assert.assertEquals(f1.get().getResponse(), "response");
        Assert.assertEquals(f1.get().getThreadLocalContext(), "joe");
        Assert.assertEquals(f1.get().getStaticContext(), "jane");

        Assert.assertNotNull(f2.get());
        Assert.assertEquals(f2.get().getRequest(), "r2");
        Assert.assertEquals(f2.get().getResponse(), "response");
        Assert.assertEquals(f2.get().getThreadLocalContext(), "jane");
        Assert.assertEquals(f1.get().getStaticContext(), "jane");

    }

}
