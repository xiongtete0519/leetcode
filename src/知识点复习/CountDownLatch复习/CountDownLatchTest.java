package 知识点复习.CountDownLatch复习;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println("子线程1正在执行");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("子线程1执行完毕");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("子线程2正在执行");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("子线程2执行完毕");
            latch.countDown();
        }).start();
        System.out.println("等待两个子线程执行完毕...");
        //在CountDownLatch上等待子线程执行完毕
        latch.await();
        System.out.println("两个子线程都已经执行完毕，继续执行主线程");
    }
}
