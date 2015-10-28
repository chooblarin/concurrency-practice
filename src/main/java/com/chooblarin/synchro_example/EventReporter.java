package com.chooblarin.synchro_example;

public class EventReporter {

    public static void main(String... args) {

        final EventList eventList = new EventList();

        Thread writeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    eventList.set(String.valueOf(i));
                }
            }
        });

        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    eventList.get();
                }
            }
        });

        writeThread.start();
        readThread.start();

        try {
            writeThread.join();
            readThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
