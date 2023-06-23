package java程序员面试宝典.多线程.捕获线程抛出的异常;

class ThreadException extends Thread{
    @Override
    public void run() {
        int i=1/0;
    }
    public void simulateCleanup(){
        System.out.println("Simulate clean up");
    }
}
class ErrHandler implements Thread.UncaughtExceptionHandler{

    //这里可以做异常处理，例如可以释放系统资源
    //或者通过日志记录错误或者唤醒其他线程等
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("this is:"+t.getName()+",Message:"+e.getMessage());
        e.printStackTrace();
        ((ThreadException)t).simulateCleanup();
    }
}
public class Test {
    public static void main(String[] args) {
        ThreadException thread = new ThreadException();
        try{
            Thread.UncaughtExceptionHandler handler = new ErrHandler();
            thread.setUncaughtExceptionHandler(handler);//加入定义的ErrHandler
            thread.start();
        }catch (Exception e){
            System.out.println("there is exception:"+e.getMessage());
        }
    }
}
