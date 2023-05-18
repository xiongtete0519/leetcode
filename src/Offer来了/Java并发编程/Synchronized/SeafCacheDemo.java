package Offer来了.Java并发编程.Synchronized;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SeafCacheDemo {
    private final Map<String,Object> cache=new HashMap<>();
    private final ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock();
    //定义读锁

    //在读数据时加读锁
    public Object get(String key){
        rwlock.readLock().lock();
        try{
            return cache.get(key);
        }finally {
            rwlock.readLock().unlock();
        }
    }

    //在写数据时加写锁
    public Object put(String key,Object value){
        rwlock.writeLock().lock();
        try{
            return cache.put(key,value);
        }finally {
            rwlock.writeLock().unlock();
        }
    }
}
