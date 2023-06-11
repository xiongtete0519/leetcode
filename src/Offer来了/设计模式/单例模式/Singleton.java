package Offer来了.设计模式.单例模式;


//静态内部类
public class Singleton {
    private static class SingletonHolder{
        private static final Singleton INSTANCE=new Singleton();
    }
    private Singleton(){}
    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
