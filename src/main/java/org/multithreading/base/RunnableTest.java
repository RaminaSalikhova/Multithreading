package org.multithreading.base;

public class RunnableTest{
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("New Thread started");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("New Thread finished");
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new MyRunnable());
        Thread t2=new Thread(new MyRunnable());

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main end");
    }
}
