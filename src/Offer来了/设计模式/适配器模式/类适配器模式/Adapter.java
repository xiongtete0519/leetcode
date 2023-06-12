package Offer来了.设计模式.适配器模式.类适配器模式;

public class Adapter extends Source implements Targetable {
    @Override
    public void editTextFile() {
        super.exitTextFile();
    }

    @Override
    public void editWordFile() {
        System.out.println("a word file editing");
    }

    public static void main(String[] args) {
        Targetable target=new Adapter();
        target.editTextFile();
        target.editWordFile();
    }
}
