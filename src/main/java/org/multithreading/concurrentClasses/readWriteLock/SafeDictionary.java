package org.multithreading.concurrentClasses.readWriteLock;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SafeDictionary {
    private final Map<String, String> map=new TreeMap<>();
    private final ReentrantReadWriteLock readWriteLock= new ReentrantReadWriteLock();
    private final Lock readLock= readWriteLock.readLock();
    private final Lock writeLock=readWriteLock.writeLock();


    public  String get(String key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public String put(String key, String value){
        writeLock.lock();
        try{
            return map.put(key, value);
        }finally {
            writeLock.unlock();
        }
    }

    public void clear(){
        writeLock.lock();
        try {
            map.clear();
        }finally {
            writeLock.unlock();
        }
    }

    public String[] allKeys(){
        readLock.lock();
        try {
            return map.keySet().toArray(new String[0]);
        }finally {
            readLock.unlock();
        }
    }

}
