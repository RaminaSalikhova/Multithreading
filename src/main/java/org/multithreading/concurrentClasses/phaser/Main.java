package org.multithreading.concurrentClasses.phaser;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser();

        new Thread(new CookingThread(phaser, "pot")).start();
        new Thread(new CookingThread(phaser, "knife")).start();
        new Thread(new CookingThread(phaser, "rope")).start();

        phaser.register();

        // ждем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();

        if(phaser.isTerminated()) {
            System.out.println("Синхронизатор фаз завершен");
        }
    }
}
