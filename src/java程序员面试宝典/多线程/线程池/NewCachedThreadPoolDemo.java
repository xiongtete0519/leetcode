package java程序员面试宝典.多线程.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread2 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId()+" run");
    }
}
public class NewCachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        //将线程放入池中执行
        pool.execute(new MyThread2());
        pool.execute(new MyThread2());
        pool.execute(new MyThread2());
        pool.execute(new MyThread2());
        //关闭线程池
        pool.shutdown();
    }
}
