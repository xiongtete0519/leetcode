package Offer来了.设计模式.装饰者模式;

public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }

    @Override
    public void createComputer() {
        source.createComputer();
        //在创建完电脑后给电脑装上系统
        System.out.println("make system.");
    }

    public static void main(String[] args) {
        Source source = new Source();
        Decorator obj = new Decorator(source);
        obj.createComputer();
    }
}
