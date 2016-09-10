package com.beauchef.concurrency;

/**
 * beauchef 9/8/2016.
 */
public class Deadlock {

    private Object key1 = new Object();
    private Object key2 = new Object();

    public void a() {
        synchronized (key1) {
            System.out.println(String.format("[%s] I am in a()", Thread.currentThread().getName()));
            b();
        }
    }

    public void b() {
        synchronized (key2) {
            System.out.println(String.format("[%s] I am in b()", Thread.currentThread().getName()));
            c();
        }
    }

    public void c() {
        synchronized (key1) {
            System.out.println(String.format("[%s] I am in c()", Thread.currentThread().getName()));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Deadlock d = new Deadlock();
        Runnable r1 = () -> d.a();
        Runnable r2 = () -> d.b();

        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();

        t1.join();
        t2.join();
    }
}
