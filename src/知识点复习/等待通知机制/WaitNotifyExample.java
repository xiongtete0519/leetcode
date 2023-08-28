package 知识点复习.等待通知机制;

public class WaitNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();//作为锁对象
        //线程A
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread A is waiting...");
                try {
                    lock.wait();//线程A等待并释放锁
                    System.out.println("Thread A is resumed.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread B is working");
                lock.notify();//唤醒一个等待的线程A
//                lock.notifyAll();//唤醒所有等待的线程
            }
        });
        threadA.start();
        Thread.sleep(1000);
        threadB.start();
    }
}
