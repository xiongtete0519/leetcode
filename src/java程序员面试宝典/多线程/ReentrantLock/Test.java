package java程序员面试宝典.多线程.ReentrantLock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Demo{
    private Lock lock=new ReentrantLock();

    public void method1(){
        try{
            lock.lock();
            System.out.println("method1 is called,timestamp="+ LocalDateTime.now().toString());
            Thread.sleep(5000);
            System.out.println("method1 is called,timestamp="+LocalDateTime.now().toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void method2(){
        lock.lock();
        System.out.println("method2 is called,timestamp="+LocalDateTime.now().toString());
        System.out.println("method2 is called,timestamp="+LocalDateTime.now().toString());
        lock.unlock();
    }
}

class Thread1 extends Thread{
    private Demo td;

    public Thread1(Demo td){
        this.td=td;
    }

    @Override
    public void run() {
        td.method1();
    }
}
class Thread2 extends Thread{
    private Demo td;

    public Thread2(Demo td){
        this.td=td;
    }
    @Override
    public void run() {
       td.method2();
    }
}
public class Test {
    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread1 thread1 = new Thread1(demo);
        Thread2 thread2 = new Thread2(demo);
        thread1.start();
        try{
            Thread.sleep(2000);
        }catch (Exception e){

        }
        thread2.start();
    }
}
