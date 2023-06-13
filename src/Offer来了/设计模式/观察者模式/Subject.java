package Offer来了.设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;
//定义抽象主题
public abstract class Subject {
    protected List<Observer> observers=new ArrayList<>();
    //增加观察者
    public void add(Observer observer){
        observers.add(observer);
    }
    //删除观察者
    public void remove(Observer observer){
        observers.remove(observer);
    }
    public abstract void notifyObserver(String message);    //通知观察者的抽象方法
}
