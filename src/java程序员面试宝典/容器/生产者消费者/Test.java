package java程序员面试宝典.容器.生产者消费者;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//生产者
class Producer implements Runnable{
    private BlockingQueue<String> bq;
    private int period=1000;
    private Random r=new Random();
    private String name;

    public Producer(BlockingQueue<String> bq, int period, String name) {
        this.bq = bq;
        this.period = period;
        this.name = name;
    }

    @Override
    public void run() {
        try{
            while(true){
                Thread.sleep(period);
                String product = String.valueOf(r.nextInt(100));
                //如果队列满了就等待
                bq.put(product);
                System.out.println("生产者["+this.name+"]生产"+product+"，当前队列中产品为："+bq);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
//消费者
class Customer implements  Runnable{
    private BlockingQueue<String> bq;
    private int period=1000;
    private String name;

    public Customer(BlockingQueue<String> bq, int period, String name) {
        this.bq = bq;
        this.period = period;
        this.name = name;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(period);
            String value=bq.take();//获取队列头部元素，如果队列为空则阻塞
            System.out.println("消费者["+this.name+"]消费"+value+",当前队列中产品为："+bq.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class Test {
    public static void main(String[] args) {
        BlockingQueue<String> abq=new ArrayBlockingQueue<>(5);
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(new Producer(abq,1000,"生产者"));
        pool.execute(new Customer(abq,5000,"消费者1"));
        pool.execute(new Customer(abq,5000,"消费者2"));
        pool.shutdown();
    }
}
