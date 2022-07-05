package org.multithreading.base;

public class SyncBlockTest {
    public static void main(String[] args) {
        Object monitor=new Object();

        Thread t1=new Thread(() -> {
            synchronized (monitor){
                System.out.println("T1 start");
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("T1 end");
            }
        });

        Thread t2=new Thread(() -> {
            synchronized (monitor){
                System.out.println("T2 start");
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("T2 end");
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
