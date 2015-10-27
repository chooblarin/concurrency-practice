package com.chooblarin.thread;

public class ThreadedHello implements Runnable {

    private int counter;

    public ThreadedHello(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;

            System.out.printf("%s: %d\n", Thread.currentThread().getName(), counter);
        }
    }
}
