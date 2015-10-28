package com.chooblarin.barrier;

public class Account {

    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public synchronized void receiveCash(int amount) {
        balance += amount;
    }

    public synchronized void payExpenses(int amount) {
        balance -= amount;
    }
}
