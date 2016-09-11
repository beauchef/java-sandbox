package com.beauchef.jvm.memory;

import java.lang.ref.WeakReference;

/**
 * @author beauchef 9/11/2016.
 */
public class WeakReferenceExample {

    public static class Person { }

    public static void main(String[] args) {
        Person person = new Person();
        WeakReference<Person> wr = new WeakReference<>(person);

        Person p1 = wr.get();
        System.out.println(p1);

        person = null;
        p1 = null;

        Person p2 = wr.get();
        System.out.println(p2);

        p2 = null;
        System.gc();
        Person p3 = wr.get();
        System.out.println(p3);
    }
}
