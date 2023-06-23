package java程序员面试宝典.多线程.等待通知模型;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Buffer {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final int BUFFERSIZE = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>(BUFFERSIZE);

    public void put() {
        Random random = new Random();
        lock.lock();
        try {
            //对于生产者来说，如果队列满了，则需要被阻塞
            while (queue.size() == BUFFERSIZE) {
                System.out.println(Thread.currentThread().getName() + "队列已满，生产者被阻塞");
                notFull.await();    //阻塞生产线程
            }
            queue.add(random.nextInt());//继续生产
            Thread.sleep(1000);
            notEmpty.signalAll();//唤醒消费线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            //对于消费者来说，如果队列为空，则需要被阻塞
            while (queue.size() == 0) {
                System.out.println(Thread.currentThread().getName() + "队列为空，消费者被阻塞");
                notEmpty.await();   //阻塞消费线程
            }
            int d = queue.poll();
            System.out.println(Thread.currentThread().getName() + "消费的数字为:" + d);
            Thread.sleep(1000);

            //唤醒生产线程，如果生产者因为队列满了被阻塞，
            // 这个调用会唤醒生产者，从而生产者可以继续生产数字
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable{
    private Buffer buffer;
    public Producer(Buffer b){
        buffer=b;
    }

    @Override
    public void run() {
        while(true){
            buffer.put();
        }
    }
}
class Consumer implements Runnable{
    private Buffer buffer;
    public Consumer(Buffer b){
        buffer=b;
    }

    @Override
    public void run() {
        while(true){
            buffer.take();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        //创建2个生产者
        for (int i = 0; i < 2; i++) {
            new Thread(producer,"生产者-"+i).start();
        }
        //创建3个消费者
        for (int i = 0; i < 3; i++) {
            new Thread(consumer,"消费者-i").start();
        }
    }
}
