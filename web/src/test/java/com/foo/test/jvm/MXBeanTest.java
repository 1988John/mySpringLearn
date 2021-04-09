package com.foo.test.jvm;

import static java.lang.management.ManagementFactory.getRuntimeMXBean;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

/**
 * @author jiangwang
 * @date 2021-04-07 14:53
 */
public class MXBeanTest {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        System.out.println(runtimeMXBean.getSystemProperties());
        System.out.println(runtimeMXBean.getVmVendor());
        System.out.println(runtimeMXBean.getVmName());
        System.out.println(runtimeMXBean.getStartTime());

        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        System.out.println();
        System.out.println(garbageCollectorMXBeans.get(0).getName());
        System.out.println(garbageCollectorMXBeans.get(1).getName());

    }
}
