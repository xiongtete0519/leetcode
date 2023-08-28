package 知识点复习.线程的基本操作方法;

public class InterruptThread extends Thread {
    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            try {
                //1.这里处理正常的线程业务逻辑
                sleep(10);
            } catch (InterruptedException e) {
                //重新设置中断标识
                Thread.currentThread().interrupt();
            }
        }
        if (Thread.currentThread().isInterrupted()) {
            //2.处理线程结束前必要的一些资源释放和清理工作，比如释放锁、
            //存储数据到持久化层、发出异常通知等，用于实现线程的安全退出。
            try {
                sleep(10);
            } catch (InterruptedException e) {
                System.out.println("线程结束了");
                return;
            }
        }
    }

    public static void main(String[] args) {
        //3.定义一个可以安全退出的线程
        InterruptThread thread = new InterruptThread();
        thread.start();
        //4.安全退出线程
        thread.interrupt();
    }
}
