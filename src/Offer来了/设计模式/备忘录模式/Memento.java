package Offer来了.设计模式.备忘录模式;
//备忘录
public class Memento {
    //备忘录具体的数据内容
    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
