package 知识点复习.线程的基本操作方法;

public class JoinTest {
    static class SleepThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " 进入睡眠");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " 运行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SleepThread thread1 = new SleepThread();
        System.out.println("启动thread1");
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("启动thread2");
        //启动第二个线程，并且进行限时合并，等待时间位1秒
        SleepThread thread2 = new SleepThread();
        thread2.start();
        try {
            thread2.join(1000);//限时合并，限时1秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程运行结束");
    }
}
