package org.multithreading.concurrentClasses.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        int keyAmount = 5;
        CountDownLatch door = new CountDownLatch(keyAmount);
        new Thread(new KeyBringer(door, keyAmount)).start();
        try {
            door.await();//Основной метод - замок, пока счетчик объекта countDownLutch не будет равен нулю,
                         // ни один поток не пройдет дальше.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Door has been opened!");
    }
}
