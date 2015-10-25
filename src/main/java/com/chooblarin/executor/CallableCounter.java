package com.chooblarin.executor;

import java.util.concurrent.Callable;

public class CallableCounter implements Callable<Integer> {

    private Integer counter = 0;

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 20; i++) {
            counter++;
        }
        return counter;
    }
}
