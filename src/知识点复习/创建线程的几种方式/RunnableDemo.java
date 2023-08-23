package 知识点复习.创建线程的几种方式;

public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("create by implements Runnable");
    }

    public static void main(String[] args) {
//        RunnableDemo runnableDemo = new RunnableDemo();
//        Thread thread = new Thread(runnableDemo);
//        thread.start();
//
        new Thread(() -> {
            System.out.println("create by implements Runnable");
        }).start();
    }
}
