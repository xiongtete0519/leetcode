package java程序员面试宝典.多线程.join方法;

public class JoinTest {
    public static void main(String[] args) {
        Thread t = new Thread(new ThreadImp());
        t.start();
        try{
            t.join(1000);//主线程等待t结束，只等1秒
            if(t.isAlive()){    //t是否已经结束
                System.out.println("t has not finished");
            }else{
                System.out.println("t has finished");
            }
            System.out.println("joinFinish");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class ThreadImp implements Runnable{
    @Override
    public void run() {
        try{
            System.out.println("begin threadimp");
            Thread.sleep(5000);
            System.out.println("end threadimp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
