package com.chooblarin.reentrant;

import com.sun.istack.internal.NotNull;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReentrantLock;

public class EventList {

    final private int maxEventSize = 5;

    private BlockingDeque<String> events;

    private ReentrantLock lock;

    public EventList() {
        events = new LinkedBlockingDeque<String>();
        lock = new ReentrantLock();
    }

    public void set(@NotNull String event) {
        try {
            while (events.size() == maxEventSize || !lock.tryLock()) {
                Thread.sleep(200L);
            }
            events.offer(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
        System.out.printf("%s Set: %d\n", Thread.currentThread().getName(), events.size());
    }

    @NotNull
    public String get() {
        String event = null;
        try {
            while (events.size() == 0 || !lock.tryLock()) {
                Thread.sleep(200L);
            }
            event = events.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
        System.out.printf("%s Get: %s\n", Thread.currentThread().getName(), event);
        return event;
    }
}
