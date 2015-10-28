package com.chooblarin.latch;

import java.util.concurrent.CountDownLatch;

public class Employee implements Runnable {

    private CountDownLatch latch;
    private int employeeID;

    public Employee(int employeeID, CountDownLatch latch) {
        this.latch = latch;
        this.employeeID = employeeID;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(200);
                System.out.println("Employee ID# =" + employeeID + " just came in");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }
}
