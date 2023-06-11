package Offer来了.设计模式.单例模式;
//懒汉模式(线程安全)
public class LazySingleton {
    private  static LazySingleton instance;
    private LazySingleton(){}
    public static synchronized LazySingleton getInstance(){
        if(instance==null){
            instance=new LazySingleton();
        }
        return instance;
    }
}
