package 知识点复习.创建线程的几种方式;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        //通过ThreadPoolExecutor构造函数自定义参数创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,   //核心线程数
                20,                             //最大线程数
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            //执行Runnable
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
            });
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
