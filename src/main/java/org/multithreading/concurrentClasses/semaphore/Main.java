package org.multithreading.concurrentClasses.semaphore;

public class Main {
    public static void main(String[] args) {
        Message message=new Message("Hey!");

        new Thread(new Echo(message)).start();
        new Thread(new Player(message)).start();
    }
}
