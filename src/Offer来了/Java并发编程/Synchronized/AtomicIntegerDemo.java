package Offer来了.Java并发编程.Synchronized;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo implements Runnable {
    //定义一个原子操作数
    static AtomicInteger safeCounter=new AtomicInteger(0);
    @Override
    public void run() {
        for (int m = 0; m <1000000 ; m++) {
            safeCounter.getAndIncrement();  //对原子操作数执行自增操作
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo mt = new AtomicIntegerDemo();
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        t1.start();
        t2.start();
        Thread.sleep(500);
        System.out.println(mt.safeCounter.get());
    }
}
