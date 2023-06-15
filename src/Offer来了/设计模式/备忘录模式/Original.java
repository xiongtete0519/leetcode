package Offer来了.设计模式.备忘录模式;
//原始数据
public class Original {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Original(String value) {
        this.value = value;
    }
    //创建备忘录
    public Memento createMemento(){
        return new Memento(value);
    }
    //从备忘录中恢复数据
    public void restoreMemento(Memento memento){
        this.value=memento.getValue();
    }
}
