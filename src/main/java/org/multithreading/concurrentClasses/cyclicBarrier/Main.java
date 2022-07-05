package org.multithreading.concurrentClasses.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new
                TeleportAction());
        System.out.println("Ждем группу!");
        new Thread(new Player(cyclicBarrier, "Player1")).start();
        new Thread(new Player(cyclicBarrier, "Player2")).start();
        new Thread(new Player(cyclicBarrier, "Player3")).start();
        new Thread(new Player(cyclicBarrier, "Player4")).start();
        new Thread(new Player(cyclicBarrier, "Player5")).start();

    }
}
