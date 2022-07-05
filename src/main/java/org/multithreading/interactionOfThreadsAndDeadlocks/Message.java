package org.multithreading.interactionOfThreadsAndDeadlocks;

public class Message {
    private String message;
    private boolean sent;

    public Message(String str, boolean sent) {
        this.message = str;
        this.sent = sent;
    }
    public String getMsg() {
        return message;
    }
    public void setMsg(String str) {
        this.message = str;
    }
    public boolean isSent() {
        return sent;
    }
    public void setSent(boolean sent) {
        this.sent = sent;
    }

    synchronized void reply() {
        while (!isSent()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Пoлyчeнo: " + this.getMsg());
        this.setSent(false);
        notify();
    }

    synchronized void say(String message) {
        while (isSent()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setMsg(message);
        this.setSent(true);
        System.out.println("Отправлено: " + this.getMsg());
        notify();
    }
}
