package 知识点复习.线程池提交任务的两种方式;

import java.util.UUID;
import java.util.concurrent.*;

//通过submit()返回的Future对象捕获异常
public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        Future<?> future = pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "正在执行");
                throw new RuntimeException("Error from " + Thread.currentThread().getName());
            }
        });
        try {
            //如果异常抛出，就会在Future.get()时传递给调用者
            if (future.get() == null) {
                //如果Future的返回值为null,那么任务完成
                System.out.println("任务完成");
            }
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
        }
        //关闭线程池
        pool.shutdown();


    }
}
