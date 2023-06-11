package Offer来了.设计模式.单例模式;
//饿汉式
public class HungrySingleton {
    private static HungrySingleton instance=new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return instance;
    }
}
