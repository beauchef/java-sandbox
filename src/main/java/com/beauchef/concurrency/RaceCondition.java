package com.beauchef.concurrency;

/**
 * beauchef 9/8/2016.
 */
public class RaceCondition {

    public static class LongWrapper {
        private long l;
        public LongWrapper(long l) {
            this.l = l;
        }
        public long getValue() {
            return l;
        }
        public void incValue() {
            l++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        LongWrapper wrapper = new LongWrapper(0L);
        Runnable runnable = () -> {
            for (int i = 0; i < 1_000; i++) {
                wrapper.incValue();
            }
        };
        Thread[] threads = new Thread[1_000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("Value = " + wrapper.getValue());
    }

}
