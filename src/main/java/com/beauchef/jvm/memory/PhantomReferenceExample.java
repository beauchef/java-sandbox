package com.beauchef.jvm.memory;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * @author beauchef on 2016-09-11.
 */
public class PhantomReferenceExample {

    static class Person { }

    static class FinalizePerson extends PhantomReference<Person> {
        public FinalizePerson(Person ref, ReferenceQueue<? super Person> q) {
            super(ref, q);
        }
        public void cleanup() {
            System.out.println("Person is finalizing resources...");
        }
    }

    public static void main(String[] args) {
        ReferenceQueue<Person> queue = new ReferenceQueue<>();
        List<FinalizePerson> finalizers = new ArrayList<>();
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            people.add(p);
            finalizers.add(new FinalizePerson(p, queue));
        }

        people = null;
        System.gc();

        for (PhantomReference<Person> ref : finalizers) {
            System.out.println(ref.isEnqueued());
        }

        Reference<? extends Person> refFromQueue;
        while ((refFromQueue = queue.poll()) != null) {
            ((FinalizePerson)refFromQueue).cleanup();
            refFromQueue.clear();
        }
    }
}
