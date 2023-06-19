package java程序员面试宝典.java基础知识.test28线程安全;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo implements Runnable {

    private static AtomicInteger num=new AtomicInteger(0);
    private static int num1=0;

    @Override
    public void run() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" "+getAutoIncrease()+","+getIncrease());
    }
    public int getAutoIncrease(){
        return num.getAndIncrement();
    }
    public int getIncrease(){
        return num1++;
    }

    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(ad).start();
        }
    }
}
