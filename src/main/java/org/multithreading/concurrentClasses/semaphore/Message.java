package org.multithreading.concurrentClasses.semaphore;

import java.util.concurrent.Semaphore;

public class Message {
    private String message;

    Semaphore echo = new Semaphore(0);

    Semaphore player = new Semaphore(1);

    public Message(String str) {
        this.message = str;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String str) {
        this.message = str;
    }

    void reply() {

        try {
            echo.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Пoлyчeнo: " + this.getMsg());

        player.release();
    }

    void say(String message) {

        try {
            player.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.setMsg(message);
        System.out.println("Отправлено: " + this.getMsg());
        echo.release();
    }
}
