package java程序员面试宝典.多线程.线程创建方式;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread body");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
