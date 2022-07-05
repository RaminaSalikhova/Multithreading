package org.multithreading.concurrentClasses.readWriteLock;

import java.util.Map;
import java.util.Set;

class Reader implements Runnable {
    private SafeDictionary safeDictionary;

    public Reader(SafeDictionary safeDictionary) {
        this.safeDictionary = safeDictionary;
    }

    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is reading values");

            String[] result= safeDictionary.allKeys();
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }

            try {
                Thread.sleep((long) Math.random() * (999) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
