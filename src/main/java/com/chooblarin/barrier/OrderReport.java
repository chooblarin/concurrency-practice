package com.chooblarin.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class OrderReport extends Report {

    private Account account;
    private CyclicBarrier barrier;

    public OrderReport(Account account, CyclicBarrier barrier) {
        this.account = account;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                account.receiveCash(100);
                Thread.sleep(200);
                this.barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            generateReport();
        }
    }

    @Override
    public void generateReport() {
        System.out.printf("Balance after order: %s, Thread-%s\n",
                account.getBalance(),
                Thread.currentThread().getName()
        );
    }
}
