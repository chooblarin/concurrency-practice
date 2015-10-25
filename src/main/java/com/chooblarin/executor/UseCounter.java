package com.chooblarin.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class UseCounter {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 5; i++) {
            CallableCounter callableCounter = new CallableCounter();
            Future<Integer> result = executor.submit(callableCounter);
            list.add(result);
        }

        for (int i = 0; i < list.size(); i++) {
            Future<Integer> tmp = list.get(i);
            Integer num = null;
            try {
                num = tmp.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("Thread-" + Thread.currentThread().getName() + ": counter=" + num);
        }
        executor.shutdown();
    }

/*
    public static void main(String[] args) {

        ThreadPoolExecutor.CallerRunsPolicy policy = new ThreadPoolExecutor.CallerRunsPolicy() {

            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                System.out.println("Thread-" + Thread.currentThread().getName() + ": Job rejected. ActiveCounts: " + e.getActiveCount());
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // core pool size
                3, // maximum pool size
                0L, // keep alive time
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), // work queue
                policy // handler
        );

        for (int i = 0; i < 10; i++) {
            executor.execute(new CounterRunnable());
        }
        executor.shutdown();
    }
*/
}
