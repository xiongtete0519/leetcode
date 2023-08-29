package 知识点复习.Atomic原子类;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    private static final int THREAD_COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < THREAD_COUNT; i++) {
            pool.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicInteger.getAndIncrement();
                }
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("累加之和：" + atomicInteger.get());
        pool.shutdown();
    }
}
