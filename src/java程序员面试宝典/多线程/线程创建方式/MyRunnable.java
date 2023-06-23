package java程序员面试宝典.多线程.线程创建方式;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread body");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
