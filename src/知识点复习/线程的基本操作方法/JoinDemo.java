package 知识点复习.线程的基本操作方法;

public class JoinDemo {
    static class ChildThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public static void main(String[] args) throws InterruptedException {
            System.out.println("子线程开始");
            ChildThread childThread = new ChildThread();
            childThread.start();
            childThread.join();
            System.out.println("子线程join()结束，开始运行主线程");
        }
    }
}
