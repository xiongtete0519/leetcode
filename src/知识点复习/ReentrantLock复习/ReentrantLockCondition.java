package 知识点复习.ReentrantLock复习;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCondition {
    //创建一个显示锁
    static Lock lock = new ReentrantLock();
    //获取一个显示锁绑定的Condition对象
    static private Condition condition = lock.newCondition();

    //等待线程执行异步目标任务
    static class WaitTarget implements Runnable {
        @Override
        public void run() {
            lock.lock();//1：抢占锁
            try {
                System.out.println("我是等待方");
                condition.await();//2：开始等待，并且释放锁
                System.out.println("收到通知，等待方继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();//释放锁
            }

        }
    }

    //通知线程的异步目标任务
    static class NotifyTarget implements Runnable {
        @Override
        public void run() {
            lock.lock(); //3:抢锁
            try {
                System.out.println("我是通知方");
                condition.signal(); //4:发送通知
                System.out.println("发出通知了，但是线程还没有立马释放锁");
            } finally {
                lock.unlock();  //5:释放锁之后，等待线程才能获得锁
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建等待线程
        Thread waitThread = new Thread(new WaitTarget(), "WaitThread");
        //启动等待线程
        waitThread.start();
        Thread.sleep(2000);//等待一会

        //创建通知线程
        Thread notifyThread = new Thread(new NotifyTarget(), "NotifyThread");
        //启动通知线程
        notifyThread.start();
    }
}
