package 知识点复习.ReentrantLock复习;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();    //1:抢占锁
        try {
            //2:抢锁成功，执行临界区代码
        } finally {
            lock.unlock();//3:释放锁
        }
    }
}
