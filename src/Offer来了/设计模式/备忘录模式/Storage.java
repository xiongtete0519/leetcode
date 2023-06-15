package Offer来了.设计模式.备忘录模式;
//备忘录管理者
public class Storage {
    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }
    //获取一个备忘录数据
    public Memento getMemento() {
        return memento;
    }
    //设置备忘录数据
    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    //使用备忘录
    public static void main(String[] args) {
        //创建原始类
        Original original = new Original("张三");
        //创建备忘录
        Storage storage = new Storage(original.createMemento());
        //修改原始类的状态
        System.out.println("original value: "+original.getValue());
        original.setValue("李四");
        System.out.println("update value: "+original.getValue());
        //恢复原始类的状态
        original.restoreMemento(storage.getMemento());
        System.out.println("restore value: "+original.getValue());
    }
}
