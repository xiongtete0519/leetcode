package java程序员面试宝典.多线程.CAS;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABATest {
    private static AtomicInteger atomicInt=new AtomicInteger(1);
    private static AtomicStampedReference<Integer> asRef=new AtomicStampedReference<>(100,0);

    public static void testABA() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInt.compareAndSet(1, 2);
                atomicInt.compareAndSet(2, 1);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean c3 = atomicInt.compareAndSet(1, 2);
            System.out.println(c3);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public static void testFixABA() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            asRef.compareAndSet(1, 2, asRef.getStamp(), asRef.getStamp() + 1);
            asRef.compareAndSet(2, 1, asRef.getStamp(), asRef.getStamp() + 1);
        });
        Thread t2 = new Thread(() -> {
            int stamp = asRef.getStamp();
            System.out.println("Before sleep:stamp=" + stamp);//stamp=0
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("After sleep:stamp=" + asRef.getStamp());  //stamp=1
            boolean c3 = asRef.compareAndSet(1, 2, stamp, stamp + 1);
            System.out.println(c3);     //false
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public static void main(String[] args) throws InterruptedException {
        testABA();
        testFixABA();
    }
}
