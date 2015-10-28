package com.chooblarin.synchro_example;

import com.sun.istack.internal.NotNull;

import java.util.LinkedList;

public class EventList {

    final private int maxEventSize = 5;

    private LinkedList<String> events;

    public EventList() {
        events = new LinkedList<String>();
    }

    public synchronized void set(@NotNull String event) {
        while (events.size() == maxEventSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        events.offer(event);
        System.out.printf("Set: %d\n", events.size());
        notifyAll();
    }

    @NotNull
    public synchronized String get() {
        while (events.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String event = events.poll();
        System.out.printf("Get: %s\n", event);
        notifyAll();

        return event;
    }
}
