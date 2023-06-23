package java程序员面试宝典.多线程.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {
    public static final int THRESHOLD=3;    //Fork任务的阈值
    private int start;  //加法运算的起始值
    private int end;    //加法运算的结束值

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum=0;
        boolean smallEnough = (end - start) <= THRESHOLD;
        //如果小于等于阈值，则直接计算结果
        if(smallEnough){
            System.out.println("计算加法区间为："+start+"~"+end);
            for (int i = start; i <=end ; i++) {
                sum+=i;
            }
        }else{
            //如果任务大于阈值，就分裂成多个子任务计算(这里以2为例)
            int mid=(start+end)>>1;
            SumTask task1 = new SumTask(start, mid);
            SumTask task2 = new SumTask(mid + 1, end);

            //分别执行子任务
            task1.fork();
            task2.fork();

            //判断task1在执行过程中是否碰到异常
            if(task1.isCompletedAbnormally()){
                System.out.println(task1.getException());
            }
            //判断task2在执行过程中是否碰到异常
            if(task2.isCompletedAbnormally()){
                System.out.println(task2.getException());
            }
            //等待子任务执行完并得到执行结果
            int task1Result=(int)task1.join();
            int task2Result = task2.join();
            //合并子任务的结果
            sum=task1Result+task2Result;
        }
        return sum;
    }
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算资格，负责计算1+2+3+4+..+10
        SumTask task = new SumTask(1, 10);
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        try{
            System.out.println(result.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
