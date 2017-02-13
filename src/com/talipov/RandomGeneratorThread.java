package com.talipov;

import java.util.Random;

/**
 * Created by Марсель on 13.02.2017.
 */
public class RandomGeneratorThread extends Thread {
    private final Storage storage;
    private int count;
    private int timeout;

    public RandomGeneratorThread(Storage s, int count, int timeout) {
        this.storage = s;
        this.count = count;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            if (!Thread.interrupted()) {
                int num = random.nextInt(this.count);
                System.out.println("generated: " + num);
                if (!storage.putNum(num)) {
                    System.out.println("finish");
                    return;
                }
            } else {
                return;
            }

            try {
                Thread.sleep(this.timeout);
            } catch (InterruptedException e) {
                System.out.println("Random Generator Thread interrupted on sleep");
                return;
            }
        }
    }
}
