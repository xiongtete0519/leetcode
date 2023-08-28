package 知识点复习.线程的基本操作方法;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("线程启动了");
            while (true) {    //一直循环
                System.out.println(Thread.currentThread().isInterrupted());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("线程中断了");
                }
                //如果线程被中断，就退出死循环
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程结束了");
                    return;
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
