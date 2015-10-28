package com.chooblarin.latch;

import java.util.concurrent.CountDownLatch;

public class DiscussionService {

    public static void main(String... args) {
        CountDownLatch latch = new CountDownLatch(10);
        DiscussionRoom room = new DiscussionRoom(latch);

        new Thread(room).start();

        Thread[] empThread = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Employee employee = new Employee(i, latch);
            empThread[i] = new Thread(employee);
        }
        for (int i = 0; i < 5; i++) {
            empThread[i].start();
        }
    }
}
