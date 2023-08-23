package 知识点复习.线程池提交任务的两种方式;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;

//通过submit返回的Future对象获取结果
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        Future<String> future = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return UUID.randomUUID().toString();
            }
        });
        try {
            String result = future.get();
            System.out.println("异步执行的结果是：" + result);
        } catch (InterruptedException e) {
            System.out.println("异步调用过程被中断");
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println("异步调用过程中发生了异常");
            throw new RuntimeException(e);
        }
        //关闭线程池
        pool.shutdown();


    }
}
