package com.chooblarin.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UseCounterRejectHandler {

    public static void main(String[] args) {
        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("Thread-" + Thread.currentThread().getName()
                + ": Job rejected. ActiveCounts: " + executor.getActiveCount());
                executor.getQueue().add(r);
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                3,
                0L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1),
                handler);
        for (int i = 0; i < 10; i++) {
            executor.execute(new CounterRunnable());
        }
        executor.shutdown();
    }
}
