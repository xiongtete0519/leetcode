package java程序员面试宝典.多线程.ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    private ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();

    public void read() {
        rw1.readLock().lock();
        int i = 0;
        while (i++ < 10) {
            System.out.println(Thread.currentThread().getName() + "正在进行读操作");
        }
        System.out.println(Thread.currentThread().getName() + "读操作完毕");
        rw1.readLock().unlock();
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
        DemoThread t1 = new DemoThread(demo);
        DemoThread t2 = new DemoThread(demo);
        t1.start();
        t2.start();
    }
}

class DemoThread extends Thread {
    private ReentrantReadWriteLockDemo demo;

    public DemoThread(ReentrantReadWriteLockDemo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.read();
    }
}
