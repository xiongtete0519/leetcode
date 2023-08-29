package 知识点复习.ReentrantLock复习;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo1 {
    public static void main(String[] args) {
        //创建锁对象
        ReentrantLock lock = new ReentrantLock();
        if (lock.tryLock()) {//1:尝试抢占锁
            try {
                //2：抢锁成功，执行临界区代码
            } finally {
                lock.unlock();  //3:释放锁
            }
        } else {
            //4:抢锁失败，执行后备动作
        }
    }
}
