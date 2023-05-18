package Offer来了.Java并发编程.Synchronized;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockDemo implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            lock.lock();    //加锁
            //lock.lock();   //可重入锁
            try {
                i++;
            }finally {
                lock.unlock();  //释放锁
//                lock.unlock();  //可重入锁
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockDemo reenterLockDemo = new ReenterLockDemo();
        Thread t1 = new Thread(reenterLockDemo);
        t1.start();
        t1.join();
        System.out.println(i);
    }
}
