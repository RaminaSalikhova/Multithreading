package org.multithreading.base;

public class ThreadTest {

    static Counter counter=new Counter(0);

    static class IncThread extends Thread {
        @Override
        public void run() {
            System.out.println("New thread 1");
            for (int i = 0; i < 1000; i++) {
                counter.inc();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class DecThread extends Thread {
        @Override
        public void run() {
            System.out.println("New thread 2");
            for (int i = 0; i < 1000; i++) {
                counter.dec();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new DecThread());
        Thread t2=new Thread(new IncThread());

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Counter: " +counter.getCounter());
        System.out.println("Main end");
    }
}
