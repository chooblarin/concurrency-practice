package com.chooblarin.phaser;

public class TimingSimulator {

    private static final int COUNT = 3;

    public static void main(String[] args) {
        TimingPhaser phaser = new TimingPhaser();

        Thread[] timingThread = new Thread[10];

        phaser.bulkRegister(COUNT + 1);
        for (int i = 1; i <= COUNT; i++) {
            String name = "Thread-" + i;
            TimingAction task = new TimingAction(name, phaser);
            timingThread[i] = new Thread(task);
            timingThread[i].start();
        }
        while (!phaser.isTerminated()) {
            System.out.println("Thread- + "
                    + Thread.currentThread().getName()
                    + ": Phase: " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
        }
    }
}
