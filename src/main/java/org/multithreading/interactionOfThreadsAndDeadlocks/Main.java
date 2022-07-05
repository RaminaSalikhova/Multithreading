package org.multithreading.interactionOfThreadsAndDeadlocks;

public class Main {
    public static void main(String[] args) {
        Message message=new Message("Hey!", false);
        new Echo(message);
        new Player(message);
    }
}
