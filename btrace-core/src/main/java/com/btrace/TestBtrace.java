package com.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;


@BTrace
public class TestBtrace {

    @OnMethod(clazz = "com.grandstream.gwn.web.controller.ApController",
            method = "listMonitorAp",
    location = @Location(Kind.RETURN))
    public static void testBtrace(@Duration long duration) {
        BTraceUtils.println(BTraceUtils.strcat("ap duration(ms): ", BTraceUtils.str(duration / 1000000)));
    }

}
