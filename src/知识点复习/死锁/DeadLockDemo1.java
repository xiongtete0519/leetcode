package 知识点复习.死锁;
//避免死锁
public class DeadLockDemo1 {
    private static Object resource1=new Object();
    private static Object resource2=new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread()+"get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("waiting get resource2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread()+"get resource2");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread()+"get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("waiting get resource2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread()+"get resource2");
                }
            }
        }).start();
    }
}
