package 知识点复习.ReentrantLock复习;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo2 {
    public static void main(String[] args) {
        //创建锁对象
        ReentrantLock lock = new ReentrantLock();
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {//1:尝试抢占锁
                try {
                    //2：抢锁成功，执行临界区代码
                } finally {
                    lock.unlock();  //3:释放锁
                }
            } else {
                //4:限时抢锁失败，执行后备动作
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
