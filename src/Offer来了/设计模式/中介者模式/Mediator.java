package Offer来了.设计模式.中介者模式;
//抽象中介者
public abstract class Mediator {
    protected Colleague colleagueTenant;
    protected Colleague colleagueLandlord;

    public Mediator(Colleague colleagueTenant, Colleague colleagueLandlord) {
        this.colleagueTenant = colleagueTenant;
        this.colleagueLandlord = colleagueLandlord;
    }
    public abstract boolean notifyColleagueTenant(String message);
    public abstract boolean notifyColleagueLandlord(String message);
}
