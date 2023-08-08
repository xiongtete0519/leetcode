package 知识点复习.ThreadLocal复习;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 从输出中可以看出，虽然 Thread-0 已经改变了 formatter 的值
 * 但 Thread-1 默认格式化值与初始化值相同，其他线程也一样。
 */
public class ThreadLocalExample implements Runnable {
    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    @Override
    public void run() {
        System.out.println("Thread Name=" + Thread.currentThread().getName() + "default formatter=" + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        formatter.set(new SimpleDateFormat());
        System.out.println("Thread Name=" + Thread.currentThread().getName() + "formatter=" + formatter.get().toPattern());
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadLocalExample obj = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }
}
