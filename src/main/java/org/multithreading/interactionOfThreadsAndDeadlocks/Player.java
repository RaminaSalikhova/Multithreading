package org.multithreading.interactionOfThreadsAndDeadlocks;

import java.util.Arrays;
import java.util.List;

public class Player implements Runnable {
    Message message;
    List<String> phrases = Arrays.asList("Hey", "You are beautiful!", "Java is easy!", "Hail to the king!", "For the alliance!");

    public Player(Message message) {
        this.message = message;
        new Thread(this, "Player").start();
    }

    @Override
    public void run() {
        while (true) {
            Double random = Math.random() * phrases.size();
            message.say(phrases.get(random.intValue()));
        }

    }
}
