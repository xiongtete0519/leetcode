package java程序员面试宝典.多线程.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private Lock lock=new ReentrantLock();

    public void method1(){
        lock.lock();
        System.out.println("method1 is called");
        method2();
        lock.unlock();
    }

    public void method2(){
        lock.lock();
        System.out.println("method2 is called");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        demo.method1();
    }
}
