package org.multithreading.base;

public class Counter {
    int counter;

    public Counter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public synchronized void inc(){
      this.counter++;
    }

    public synchronized void dec(){
        this.counter--;
    }
}
