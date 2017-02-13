package com.talipov;

/**
 * Created by Марсель on 13.02.2017.
 */
public class CounterThread extends Thread{
    private final Storage storage;
    private int timeout;

    public CounterThread(Storage s, int timeout) {
        this.storage = s;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()) {
                synchronized (this.storage) {
                    System.out.println("count = " + this.storage.getCount());
                }
            } else {
                return;
            }

            try {
                Thread.sleep(this.timeout);
            } catch (InterruptedException e) {
                System.out.println("Counter Thread interrupted on sleep");
                return;
            }
        }
    }
}
