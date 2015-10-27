package com.chooblarin.atomicity;

public class HelloThread {

    public static void main(String[] args) {
        AtomicThreadHello hello = new AtomicThreadHello(5);
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(hello);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
