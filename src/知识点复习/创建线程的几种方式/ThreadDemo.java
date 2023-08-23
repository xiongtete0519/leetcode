package 知识点复习.创建线程的几种方式;

public class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println("create a thread:" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadDemo thread = new ThreadDemo();
        thread.start();
    }
}
