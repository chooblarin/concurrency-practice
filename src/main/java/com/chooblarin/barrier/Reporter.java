package com.chooblarin.barrier;

import java.util.concurrent.CyclicBarrier;

public class Reporter {

    public static void main(String... args) {

        Account account = new Account(1000);
        SettlementReport settlementReport = new SettlementReport(account);
        CyclicBarrier barrier = new CyclicBarrier(4, settlementReport);

        OrderReport orderReport = new OrderReport(account, barrier);

        Thread[] orderThread = new Thread[4];
        for (int i = 0; i < 4; i++) {
            orderThread[i] = new Thread(orderReport);
        }

        for (int i = 0; i < 4; i++) {
            orderThread[i].start();
        }

        for (int i = 0; i < 4; i++) {
            try {
                orderThread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
