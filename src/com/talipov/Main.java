package com.talipov;

public class Main {

    public static void main(String[] args) {
        // Условия задачи
//        int count = 100;
//        int genTimeout = 1000;
//        int counterTimeout = 5000;

        // Тестовые данные
        int count = 10;
        int genTimeout = 100;
        int counterTimeout = 500;


        Storage storage = new Storage(count);

	    Thread t1 = new RandomGeneratorThread(storage, count, genTimeout);
        Thread t2 = new CounterThread(storage, counterTimeout);

        t1.start();
        t2.start();

        while (t1.isAlive()) {}
        t2.interrupt();

        System.out.println("Result:" + storage.getCount());
    }
}
