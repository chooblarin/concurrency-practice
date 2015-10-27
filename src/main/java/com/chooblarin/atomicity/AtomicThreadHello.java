package com.chooblarin.atomicity;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicThreadHello implements Runnable {

    private AtomicInteger counter;

    public AtomicThreadHello(int count) {
        this.counter = new AtomicInteger(count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter.getAndIncrement();

            System.out.printf("%s: %d\n", Thread.currentThread().getName(), counter.intValue());
        }
    }
}
