package org.multithreading.concurrentClasses.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC {
    public  static Lock lock= new ReentrantLock();
    public static Condition condition= lock.newCondition();
    public static  char currentChar='A';

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (currentChar != 'A'){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("A");
                currentChar='B';
                condition.signal();
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (currentChar != 'B'){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("B");
                currentChar='C';
                condition.signal();
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (currentChar != 'C'){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("C");
                currentChar='A';
                condition.signal();
                lock.unlock();
            }
        }).start();
    }
}
