package org.multithreading.concurrentClasses.exchanger;

import java.util.concurrent.Exchanger;

public class Producer implements Runnable {
    Exchanger<DataBuffer> ex;
    DataBuffer producerBuffer;
    Producer(Exchanger ex){
        this.ex = ex;
    }
    @Override
    public void run() {
        DataBuffer producerBuffer = new DataBuffer();
        for(int i = 0; i < 3; i ++){
            producerBuffer.addToBuffer("Producer" + i);
            try {
                if (producerBuffer.isFull()) {
                    // exchange
                    producerBuffer = ex.exchange(producerBuffer);
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}