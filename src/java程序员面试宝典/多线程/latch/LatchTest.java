package java程序员面试宝典.多线程.latch;

import java.util.concurrent.CountDownLatch;

public class LatchTest {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        new Thread((()->{
            System.out.println("第一个线程开始工作");
            try{
                Thread.sleep(2000);
            }catch ( Exception e){
                e.printStackTrace();
            }
            System.out.println("第一个线程工作结束");
            latch.countDown();
        })).start();

        new Thread((()->{
            System.out.println("第二个线程开始工作");
            try{
                Thread.sleep(3000);
            }catch ( Exception e){
                e.printStackTrace();
            }
            System.out.println("第二个线程工作结束");
            latch.countDown();
        })).start();

        try{
            latch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("所有子任务有已经完成");
    }
}
