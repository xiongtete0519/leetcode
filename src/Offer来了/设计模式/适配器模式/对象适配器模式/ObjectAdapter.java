package Offer来了.设计模式.适配器模式.对象适配器模式;

import Offer来了.设计模式.适配器模式.类适配器模式.Source;
import Offer来了.设计模式.适配器模式.类适配器模式.Targetable;

public class ObjectAdapter implements Targetable {

    private Source source;

    public ObjectAdapter(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void editTextFile() {
        this.source.exitTextFile();
    }

    @Override
    public void editWordFile() {
        System.out.println("a word file editing");
    }

    //使用对象适配器模式
    public static void main(String[] args) {
        Source source = new Source();
        Targetable target = new ObjectAdapter(source);
        target.editWordFile();
        target.editTextFile();
    }
}
