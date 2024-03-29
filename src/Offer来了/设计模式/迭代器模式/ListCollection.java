package Offer来了.设计模式.迭代器模式;

import java.util.ArrayList;
import java.util.List;

public class ListCollection implements Collection {

    public List list=new ArrayList();   //list用于存储数据

    @Override
    public Iterator iterator() {
        return  new ConcreteIterator(this);
    }

    @Override
    public Object get(int i) {
        return list.get(i);
    }

    @Override
    public boolean add(Object object) {
        list.add(object);
        return true;
    }

    @Override
    public int size() {
        return list.size();
    }
}
