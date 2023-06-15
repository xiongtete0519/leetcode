package Offer来了.设计模式.状态模式;

public class HolidayState extends AbstractState {
    @Override
    public void action(Context context) {
        System.out.println("state change to holiday state");
        System.out.println("holiday state actions is travel,shopping,watch television...");
    }
}
