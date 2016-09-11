package com.beauchef.jvm.memory;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.List;

/**
 * @author beauchef 9/11/2016.
 */
public class MXBeanUsage {

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean : beans) {
            System.out.println("Name: " + bean.getName());
            System.out.println("Number of collections: " + bean.getCollectionCount());
            System.out.println("Collection time: " + bean.getCollectionTime() + " ms");
            System.out.println("Pool names: ");
            Arrays.asList(bean.getMemoryPoolNames()).stream().forEach(name -> System.out.println("\t" + name));
            System.out.println();
        }
    }
}
