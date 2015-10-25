package com.chooblarin.executor;

import java.util.concurrent.atomic.AtomicLong;

public class CounterRunnable implements Runnable {

    final private AtomicLong num = new AtomicLong(0);

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            increment();
        }
        System.out.println("Thread-" + Thread.currentThread().getName());
    }

    private void increment() {
        num.getAndIncrement();
    }
}
