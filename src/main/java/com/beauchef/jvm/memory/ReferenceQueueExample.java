package com.beauchef.jvm.memory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author beauchef on 2016-09-11.
 */
public class ReferenceQueueExample {

    final static class Person { }
    static class PersonCleaner {
        public void clean() {
            System.out.println("Cleaned!");
        }
    }
    static class PersonWeakReference extends WeakReference<Person> {
        PersonCleaner cleaner;
        public PersonWeakReference(Person ref, PersonCleaner cleaner, ReferenceQueue<? super Person> q) {
            super(ref, q);
            this.cleaner = cleaner;
        }
        public void clean() {
            cleaner.clean();
        }
    }
    public static void main(String[] args) throws IOException {
        Person p = new Person();
        ReferenceQueue<Person> queue = new ReferenceQueue<>();
        PersonCleaner cleaner = new PersonCleaner();
        PersonWeakReference weakRef = new PersonWeakReference(p, cleaner, queue);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                PersonWeakReference wr = (PersonWeakReference) queue.remove();
                wr.clean();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        p = null;
        System.gc();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Press any key to continue...");
        br.readLine();
        executorService.shutdown();
    }
}
