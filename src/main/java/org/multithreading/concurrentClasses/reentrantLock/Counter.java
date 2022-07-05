package org.multithreading.concurrentClasses.reentrantLock;

import java.util.concurrent.locks.Lock;

public class Counter {
    private Integer counter=0;

    Lock lock;

    public Counter(Lock lock) {
        this.lock = lock;
    }

    public Integer getCount() {
        return counter;
    }

    public  void inc(){
        lock.lock();
        this.counter++;
        lock.unlock();
    }

    public  void dec(){
        lock.lock();
        this.counter--;
        lock.unlock();
    }

}
