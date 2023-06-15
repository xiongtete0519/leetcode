package Offer来了.设计模式.中介者模式;
//房东
public class ColleagueLandlord extends Colleague {

    @Override
    public boolean operation(String message) {
        System.out.println("landlord receive a message from mediator:"+message);
        return true;
    }
}
