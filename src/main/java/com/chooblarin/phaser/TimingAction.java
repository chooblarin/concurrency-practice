package com.chooblarin.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class TimingAction implements Runnable {

    private Phaser phaser;
    private String name;
    private static Random random = new Random();

    public TimingAction(String name, TimingPhaser phaser) {
        this.phaser = phaser;
        this.name = name;
    }

    @Override
    public void run() {
        while (!phaser.isTerminated()) {
            int num = random.nextInt(10) + 1;
            try {
                TimeUnit.MICROSECONDS.sleep(num * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ": Action is completed.");
            phaser.arriveAndAwaitAdvance();
        }
    }
}
