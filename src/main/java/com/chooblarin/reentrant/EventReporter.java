package com.chooblarin.reentrant;

public class EventReporter {

    public static void main(String... args) {

        final Thread[] getThread = new Thread[3];
        final Thread[] setThread = new Thread[3];

        final EventList eventList = new EventList();
        final EventGet eventGet = new EventGet(eventList);
        final EventSet eventSet = new EventSet(eventList);

        for (int i = 0; i < 3; i++) {
            getThread[i] = new Thread(eventGet);
            setThread[i] = new Thread(eventSet);
        }

        for (int i = 0; i < 3; i++) {
            getThread[i].start();
            setThread[i].start();
        }


        try {
            for (int i = 0; i < 3; i++) {
                getThread[i].join();
                setThread[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
