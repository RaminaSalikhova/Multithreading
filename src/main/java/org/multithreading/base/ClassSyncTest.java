package org.multithreading.base;

public class ClassSyncTest {
    private static Integer count = 2;

    public static void main(String[] args) {
        Thread t1 = new Thread(ClassSyncTest::destroy);
        Thread t2 = new Thread(ClassSyncTest::destroy);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
    public static synchronized void destroy() { // синхронизация по классу
        count--;
    }
}
