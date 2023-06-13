package Offer来了.设计模式.迭代器模式;
//迭代器接口
public interface Iterator {
    //指着前移
    public Object previous();
    //指针后移
    public Object next();
    public boolean hasNext();
}
