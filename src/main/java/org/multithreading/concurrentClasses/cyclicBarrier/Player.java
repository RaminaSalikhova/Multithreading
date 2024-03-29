package org.multithreading.concurrentClasses.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Player implements Runnable{

    CyclicBarrier cyclicBarrier;
    String classRole;

    public Player(CyclicBarrier cyclicBarrier, String classRole) {
        this.cyclicBarrier = cyclicBarrier;
        this.classRole = classRole;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 + (int) Math.random() * 500);
            System.out.println("Player: "+ classRole);
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }
}
