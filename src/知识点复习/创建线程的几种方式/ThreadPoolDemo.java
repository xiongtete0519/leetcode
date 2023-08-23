package 知识点复习.创建线程的几种方式;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//线程池
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建大小为10的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        //提交多个线程任务并执行
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running");
                }
            });
        }
    }
}
