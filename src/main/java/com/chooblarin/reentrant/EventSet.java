package com.chooblarin.reentrant;

public class EventSet implements Runnable {

    private EventList eventList;

    public EventSet(EventList eventList) {
        this.eventList = eventList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            eventList.set(String.valueOf(i));
        }
    }
}
