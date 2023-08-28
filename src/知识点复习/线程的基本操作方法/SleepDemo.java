package 知识点复习.线程的基本操作方法;

public class SleepDemo {
    public static final int SLEEP_GAP = 5000;
    public static final int MAX_TURN = 50;

    static class SleepThread extends Thread {
        static int threadSeqNumber = 1;

        public SleepThread() {
            super("sleep-" + threadSeqNumber);
            threadSeqNumber++;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i < MAX_TURN; i++) {
                    System.out.println(Thread.currentThread().getName() + ",睡眠轮次：" + i);
                    //线程睡眠一会儿
                    Thread.sleep(SLEEP_GAP);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "发生异常中断");
            }
            System.out.println(currentThread().getName() + "运行结束");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SleepThread thread = new SleepThread();
            thread.start();
        }
        System.out.println(Thread.currentThread().getName() + " 运行结束");
    }
}
