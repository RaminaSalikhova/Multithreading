package org.multithreading.interactionOfThreadsAndDeadlocks;

public class DeadLock {
    public static final Object anvil = new Object();
    public static final Object bugle = new Object();
    private static class PlayerOne extends Thread {
        @Override
        public void run() {
            synchronized (anvil) {
                System.out.println("Player one is using anvil!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Player one is waiting for bugle");

            }
            synchronized (bugle) {
                System.out.println("Player one is using anvil and bugle");
            }
        }
    }

    private static class PlayerTwo extends Thread {
        @Override
        public void run() {
            synchronized (bugle) {
                System.out.println("Player two is using bugle");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Player two is waiting for anvil");

            }
            synchronized (anvil) {
                System.out.println("Player two is using bugle and anvil");
            }
        }

    }

    public static void main(String[] args) {
        new PlayerOne().start();
        new PlayerTwo().start();
    }
}