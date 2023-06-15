package Offer来了.设计模式.中介者模式;
//房客
public class ColleagueTenant extends Colleague {

    @Override
    public boolean operation(String message) {
        System.out.println("tenant receive a message from mediator:"+message);
        return true;
    }
}
