package org.multithreading.base;

public class ThreadTest {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("New thread");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
    }
}
