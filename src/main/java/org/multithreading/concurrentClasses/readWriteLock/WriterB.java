package org.multithreading.concurrentClasses.readWriteLock;

public class WriterB implements Runnable {
    private SafeDictionary safeDictionary;

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
