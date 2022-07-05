package org.multithreading.concurrentClasses.stampedLock;

import org.multithreading.concurrentClasses.stampedLock.SafeDictionary;

public class WriterB implements Runnable {
    SafeDictionary safeDictionary;

    public WriterB(SafeDictionary safeDictionary) {
        this.safeDictionary = safeDictionary;
    }

    public void run() {
        while (true) {
            safeDictionary.clear();
            System.out.println("Cleared all values");
            try {
                Thread.sleep((long) Math.random() * 999 + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}