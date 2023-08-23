package 知识点复习.创建线程的几种方式;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//1、通过实现Callable接口创建MyCallable线程
public class MyCallable implements Callable<String> {

    private String name;

    //通过构造函数为线程传递参数，以定义线程的名称
    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //2、创建一个固定大小为5的线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //3、创建多个有返回值的任务列表list
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //4、创建一个有返回值的线程实例
            MyCallable c = new MyCallable(i + " ");
            //5、提交线程，获取Future对象并将其保存到Future List中
            Future<String> future = pool.submit(c);
            System.out.println("submit a callable thread:" + i);
            list.add(future);
        }
        //6、关闭线程池,等待线程执行结束
        pool.shutdown();
        //7、遍历所有线程的运行结果
        for (Future future : list) {
            //从Future对象上获取任务的返回值，并将结果输出到控制台
            System.out.println("get the result from callable thread:" + future.get().toString());
        }
    }
}
