package org.multithreading.concurrentClasses.exchanger;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger ex = new Exchanger();

        new Thread(new Producer(ex)).start();
        new Thread(new Consumer(ex)).start();
    }
}


