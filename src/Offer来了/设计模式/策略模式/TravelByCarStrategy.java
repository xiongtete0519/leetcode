package Offer来了.设计模式.策略模式;

public class TravelByCarStrategy implements TravelStrategy {

    @Override
    public void travelMode() {
        System.out.println("travel by car");
    }
}
