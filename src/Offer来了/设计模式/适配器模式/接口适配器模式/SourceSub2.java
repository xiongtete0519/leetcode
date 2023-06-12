package Offer来了.设计模式.适配器模式.接口适配器模式;

public class SourceSub2 extends AbstarctAdapter {
    @Override
    public void editWordFile() {
        System.out.println("a word file editing");
    }

    //使用接口适配器
    public static void main(String[] args) {
        SourceSub1 source1 = new SourceSub1();
        SourceSub2 source2 = new SourceSub2();
        source1.editTextFile();
        source2.editWordFile();
    }
}
