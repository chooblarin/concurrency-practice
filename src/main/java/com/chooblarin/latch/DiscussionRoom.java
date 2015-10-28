package com.chooblarin.latch;

import java.util.concurrent.CountDownLatch;

public class DiscussionRoom implements Runnable {

    private CountDownLatch latch;

    public DiscussionRoom(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Room: all the speakers arrived. Now starting.");
    }
}
