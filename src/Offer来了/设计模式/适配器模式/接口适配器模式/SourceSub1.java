package Offer来了.设计模式.适配器模式.接口适配器模式;

public class SourceSub1 extends AbstarctAdapter {
    @Override
    public void editTextFile() {
        System.out.println("a text file editing");
    }
}
