package org.multithreading.concurrentClasses.exchanger;

import java.util.concurrent.Exchanger;

public class Consumer  implements Runnable {
    Exchanger<DataBuffer> ex;
    DataBuffer consumerBuffer;
    Consumer(Exchanger ex){
        this.ex = ex;
    }
    @Override
    public void run() {
        DataBuffer consumerBuffer = new DataBuffer();
        for(int i = 0; i < 3; i ++){
            try {
                System.out.println("waiting...");
                consumerBuffer = ex.exchange(consumerBuffer);
                System.out.println("Received- " + consumerBuffer.getData());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
