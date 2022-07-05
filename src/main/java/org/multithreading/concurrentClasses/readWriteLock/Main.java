package org.multithreading.concurrentClasses.readWriteLock;


public class Main {
    public static final SafeDictionary safeDictionary = new SafeDictionary();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Reader(safeDictionary), "Reader 1");
        Thread t11 = new Thread(new Reader(safeDictionary), "Reader 2");
        Thread t12 = new Thread(new Reader(safeDictionary), "Reader 3");
        Thread t13 = new Thread(new Reader(safeDictionary), "Reader 4");
        Thread t14 = new Thread(new Reader(safeDictionary), "Reader 5");
        Thread t15 = new Thread(new Reader(safeDictionary), "Reader 6");
        Thread t2 = new Thread(new WriterA( safeDictionary));
        Thread t3 = new Thread(new WriterB(safeDictionary));
        t1.start();
        t11.start();
        t12.start();
        t13.start();
        t14.start();
        t15.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t11.join();
            t12.join();
            t13.join();
            t14.join();
            t15.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
