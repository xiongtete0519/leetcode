package Offer来了.设计模式.装饰者模式;

public class Source implements Sourceable {

    @Override
    public void createComputer() {
        System.out.println("create computer by source");
    }
}
