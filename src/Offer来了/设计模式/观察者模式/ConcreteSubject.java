package Offer来了.设计模式.观察者模式;
//定义具体的主题ConcreteSubject
public class ConcreteSubject extends Subject {

    @Override
    public void notifyObserver(String message) {
        for (Observer observer : observers) {
            System.out.println("notify observer "+message+" change...");
            ((Observer)observer).dataChange(message);
        }
    }
}
