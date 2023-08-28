package 知识点复习.线程的基本操作方法;

public class JoinTest1 {
    static class JoinThread implements Runnable {
        @Override
        public void run() {
            System.out.println("begin...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end...");
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new JoinThread());
        t.start();
        try {
            t.join();
//            t.join(1000);//主线程等待t结束，只等1s
            if (t.isAlive()) {
                System.out.println("t has not finished");
            } else {
                System.out.println("t has finished");
            }
            System.out.println("joinFinish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
