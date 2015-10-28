package com.chooblarin.phaser;

import java.util.concurrent.Phaser;

public class TimingPhaser extends Phaser {

    final private int count = 4;

    public boolean onAdvance(int phase, int parties) {
        if (phase > count - 1 || parties == 0) {
            return true;
        }
        return false;
    }
}
