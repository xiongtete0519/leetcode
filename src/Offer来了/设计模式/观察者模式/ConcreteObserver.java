package Offer来了.设计模式.观察者模式;
//定义具体的观察者
public class ConcreteObserver implements Observer{
    @Override
    public void dataChange(String message) {
        System.out.println("receive message:"+message);
    }

    //使用观察者模式
    public static void main(String[] args) {
        Subject subject=new ConcreteSubject();
        Observer observer=new ConcreteObserver();
        subject.add(observer);
        subject.notifyObserver("data1");
    }
}
