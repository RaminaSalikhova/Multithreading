package org.multithreading.concurrentClasses.semaphore;

import org.multithreading.concurrentClasses.semaphore.Message;

public class Echo  implements Runnable{
    Message message;

    public Echo(Message message) {
        this.message = message;
        new Thread(this, "Echo").start();
    }

    @Override
    public void run() {
        while (true) {
            message.reply();
        }
    }
}