package 知识点复习.CyclicBarrier复习;

import java.util.concurrent.*;

public class CyclicBarrierTest {
    private static final int threadCount = 10;//请求的数量
    //需要同步的线程数量
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(() -> {
                System.out.println("threadNum:" + threadNum + " is ready");
                try {
                    //等待其他线程也成为Barrier状态,超时时间设置30秒
                    cyclicBarrier.await(30, TimeUnit.SECONDS);
                } catch (Exception e) {
                    System.out.println("CyclicBarrierException");
                }
                System.out.println("threadNum:" + threadNum + " is finished");
            });
        }
    }
}
