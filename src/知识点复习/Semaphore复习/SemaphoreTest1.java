package 知识点复习.Semaphore复习;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class SemaphoreTest1 {
    public static void main(String[] args) {
        int printNumber = 5;//设置线程数，即员工数量
        Semaphore semaphore = new Semaphore(2);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < printNumber; i++) {
            threadPool.execute(new Worker(i, semaphore));
        }
    }

    static class Worker implements Runnable {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();//线程申请资源，即员工申请打印机
                System.out.println("员工:" + this.num + "占用一个打印机...");
                Thread.sleep(2000);
                System.out.println("员工：" + this.num + "打印完成，释放打印机");
                semaphore.release();    //线程释放资源，即员工在使用完毕后”释放打印机“
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
