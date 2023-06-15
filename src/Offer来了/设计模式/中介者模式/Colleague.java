package Offer来了.设计模式.中介者模式;

public abstract class Colleague {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    //同事类的操作
    public abstract boolean operation(String message);
}
