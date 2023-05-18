package Offer来了.Java并发编程.Synchronized;

public class SynchronizedDemo {
    public static void main(String[] args) {
       final SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
       new Thread(new Runnable() {
           @Override
           public void run() {
               synchronizedDemo.generalMethod1();
           }
       }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedDemo.generalMethod2();
            }
        }).start();
    }
    //synchronized作用于普通的同步方法时，锁住的时当前对象的实例
    public synchronized void generalMethod1(){
        try {
            for (int i = 1; i < 3; i++) {
                System.out.println("generalMethod1 execute "+i+" time");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //synchronized作用于普通的同步方法时，锁住的时当前对象的实例
    public synchronized void generalMethod2(){
        try {
            for (int i = 1; i < 3; i++) {
                System.out.println("generalMethod2 execute "+i+" time");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
