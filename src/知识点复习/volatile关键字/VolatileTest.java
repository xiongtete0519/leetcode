package 知识点复习.volatile关键字;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//证明volatile不能保证原子性
public class VolatileTest {
    public volatile static int inc = 0;

    public void increase() {
        inc++;
    }

    //synchronized改进
    public synchronized void increase1() {
        inc++;
    }

    //ReentrantLock改进
    Lock lock = new ReentrantLock();

    public void increase2() {
        lock.lock();
        try {
            inc++;
        } finally {
            lock.unlock();
        }
    }

    //使用AtomicInteger改进
    public AtomicInteger testInc = new AtomicInteger();

    public void increase3() {
        testInc.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatileTest volatileTest = new VolatileTest();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    volatileTest.increase2();
                }
            });
        }
        //等待1.5秒，保证上面的程序执行完成
        Thread.sleep(1500);
        System.out.println(inc);
        threadPool.shutdown();
    }
}
