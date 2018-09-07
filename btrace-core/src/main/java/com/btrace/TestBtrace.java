package com.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;


@BTrace
public class TestBtrace {

    @OnMethod(clazz = "com.grandstream.service.client.impl.ClientServiceImpl",
            method = "copyNetworkHandler",
            location = @Location(Kind.RETURN))
    public static void ClientServiceImpl(@Duration long duration) {
        BTraceUtils.println(BTraceUtils.strcat("ClientServiceImpl duration(ms): ", BTraceUtils.str(duration / 1000000)));
    }

    @OnMethod(clazz = "com.grandstream.service.network.impl.NetworkObserverForSystem",
            method = "copyNetworkHandler",
            location = @Location(Kind.RETURN))
    public static void NetworkObserverForSystem(@Duration long duration) {
        BTraceUtils.println(BTraceUtils.strcat("NetworkObserverForSystem duration(ms): ", BTraceUtils.str(duration / 1000000)));
    }

    @OnMethod(clazz = "com.grandstream.service.bandwidth.impl.BandwidthRulesServiceImpl",
            method = "copyNetworkHandler",
            location = @Location(Kind.RETURN))
    public static void BandwidthRulesServiceImpl(@Duration long duration) {
        BTraceUtils.println(BTraceUtils.strcat("BandwidthRulesServiceImpl duration(ms): ", BTraceUtils.str(duration / 1000000)));
    }

    @OnMethod(clazz = "com.grandstream.service.network.impl.NetworkObserver4ClientBanned",
            method = "copyNetworkHandler",
            location = @Location(Kind.RETURN))
    public static void NetworkObserver4ClientBanned(@Duration long duration) {
        BTraceUtils.println(BTraceUtils.strcat("NetworkObserver4ClientBanned duration(ms): ", BTraceUtils.str(duration / 1000000)));
    }

    @OnMethod(clazz = "com.grandstream.service.network.impl.NetworkObserverForPortal",
            method = "copyNetworkHandler",
            location = @Location(Kind.RETURN))
    public static void NetworkObserverForPortal(@Duration long duration) {
        BTraceUtils.println(BTraceUtils.strcat("NetworkObserverForPortal duration(ms): ", BTraceUtils.str(duration / 1000000)));
    }

    @OnMethod(clazz = "com.grandstream.service.policy.TimePolicyServiceImpl",
            method = "copyNetworkHandler",
            location = @Location(Kind.RETURN))
    public static void TimePolicyServiceImpl(@Duration long duration) {
        BTraceUtils.println(BTraceUtils.strcat("TimePolicyServiceImpl duration(ms): ", BTraceUtils.str(duration / 1000000)));
    }

    @OnMethod(clazz = "com.grandstream.service.role.BindAdminAccountNetworkImpl",
            method = "copyNetworkHandler",
            location = @Location(Kind.RETURN))
    public static void BindAdminAccountNetworkImpl(@Duration long duration) {
        BTraceUtils.println(BTraceUtils.strcat("BindAdminAccountNetworkImpl duration(ms): ", BTraceUtils.str(duration / 1000000)));
    }

    @OnMethod(clazz = "com.grandstream.service.access.AccessItemServiceImpl",
            method = "copyNetworkHandler",
            location = @Location(Kind.RETURN))
    public static void AccessItemServiceImpl(@Duration long duration) {
        BTraceUtils.println(BTraceUtils.strcat("AccessItemServiceImpl duration(ms): ", BTraceUtils.str(duration / 1000000)));
    }

    @OnMethod(clazz = "com.grandstream.service.ssid.impl.SsidServiceImpl",
            method = "copyNetworkHandler",
            location = @Location(Kind.RETURN))
    public static void SsidServiceImpl(@Duration long duration) {
        BTraceUtils.println(BTraceUtils.strcat("SsidServiceImpl duration(ms) ------------------------------- : ", BTraceUtils.str(duration / 1000000)));
    }

    @OnMethod(clazz = "com.grandstream.service.network.impl.NetworkObserver4Schedule",
            method = "copyNetworkHandler",
            location = @Location(Kind.RETURN))
    public static void NetworkObserver4Schedule(@Duration long duration) {
        BTraceUtils.println(BTraceUtils.strcat("NetworkObserver4Schedule duration(ms) ", BTraceUtils.str(duration / 1000000)));
    }

}
