package com.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class ChangeLogBtrace {

    @OnMethod(clazz = "com.grandstream.service.userlog.impl.UserOperationServiceImpl",
            method = "listUserOperation",
            location = @Location(Kind.RETURN))
    public static void changeLogDuration(@Duration long duration) {
        BTraceUtils.println(BTraceUtils.strcat("listUserOperation duration(ms): ", BTraceUtils.str(duration / 1000000)));
    }


    @OnMethod(clazz = "com.grandstream.mappers.useroperation.extra.OperationMapperExtra",
            method = "listOperationWithBLOBsByEnterpriseId",
            location = @Location(Kind.RETURN))
    public static void listOperationWithBLOBsByEnterpriseId(@Duration long duration) {
        BTraceUtils.println(BTraceUtils.strcat("listOperationWithBLOBsByEnterpriseId duration(ms): ", BTraceUtils.str(duration / 1000000)));
    }


    @OnMethod(clazz = "com.grandstream.service.userlog.impl.UserOperationServiceImpl",
            method = "resolverDiff",
            location = @Location(Kind.RETURN))
    public static void resolverDiff(@Duration long duration,@Self Object param) {
        BTraceUtils.println(BTraceUtils.strcat("ClientServiceImpl duration(ms): ", BTraceUtils.str(duration / 1000000)));
    }

}
