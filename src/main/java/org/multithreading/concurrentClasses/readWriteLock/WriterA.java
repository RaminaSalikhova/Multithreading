package org.multithreading.concurrentClasses.readWriteLock;

import java.util.HashMap;
import java.util.Random;

public class WriterA implements Runnable {
    private SafeDictionary safeDictionary;
    public static HashMap<String, String> map = new HashMap<>();

    public WriterA( SafeDictionary safeDictionary) {
        initMap();
        this.safeDictionary = safeDictionary;
    }

    static void initMap() {
        map.put("Java", "The best programming language");
        map.put("Hello, World!", "The most used phrase in the programming world");
        map.put("Deploy on prod", "The reason of most stressful situations");
        map.put("It is simple!", "A several sprints task");
    }

    public void run() {
        Random random = new Random();
        String[] values = map.keySet().toArray(new String[0]);

        while (true) {
            if(values.length > 0) {
                String randomKey = (String)
                        values[random.nextInt(values.length)];
                safeDictionary.put(randomKey, map.get(randomKey));
                System.out.println("Added value: " + randomKey + " " +
                        map.get(randomKey));
            }
            try {
                Thread.sleep((long)Math.random() * 999 + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}