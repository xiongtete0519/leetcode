package java程序员面试宝典.多线程.线程池;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class MyThread3 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId()+" timestamp:"+System.currentTimeMillis());
    }
}
public class NewScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(2);
        //每隔一段时间执行一次
        exec.scheduleAtFixedRate(new MyThread3(),0,3000, TimeUnit.MILLISECONDS);
        exec.scheduleAtFixedRate(new MyThread3(),0,2000, TimeUnit.MILLISECONDS);
    }
}
