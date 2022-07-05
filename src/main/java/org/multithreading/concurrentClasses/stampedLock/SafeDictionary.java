package org.multithreading.concurrentClasses.stampedLock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.StampedLock;

public class SafeDictionary {
    private final Map<String, String> map=new TreeMap<>();
    private final StampedLock stampedLock= new StampedLock();

    public  String get(String key){
        long stamp= stampedLock.readLock();
        try {
            return map.get(key);
        }finally {
            stampedLock.unlock(stamp);
        }
    }

    public String put(String key, String value){
        long stamp= stampedLock.readLock();
        try{
            return map.put(key, value);
        }finally {
            stampedLock.unlock(stamp);
        }
    }

    public void clear(){
        long stamp= stampedLock.readLock();
        try {
            map.clear();
        }finally {
            stampedLock.unlock(stamp);
        }
    }

    public String[] allKeys(){
        long stamp= stampedLock.readLock();
        try {
            return map.keySet().toArray(new String[0]);
        }finally {
            stampedLock.unlock(stamp);
        }
    }
}
