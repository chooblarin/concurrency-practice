package com.chooblarin.barrier;

public class SettlementReport extends Report {

    private Account account;

    public SettlementReport(Account account) {
        this.account = account;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        generateReport();
    }

    @Override
    public void generateReport() {
        System.out.printf("Settled Balance: %s, Thread-%s\n",
                account.getBalance(),
                Thread.currentThread().getName());
    }
}
