package Offer来了.设计模式.迭代器模式;
//迭代器接口实现类
public class ConcreteIterator implements Iterator {
    private Collection collection;
    private int pos=-1;//当前迭代器遍历到的元素位置

    public ConcreteIterator(Collection collection){
        this.collection=collection;
    }

    @Override
    public Object previous() {
        if(pos>0){
            pos--;
        }
        return collection.get(pos);
    }

    @Override
    public Object next() {
        if(pos<collection.size()-1){
            pos++;
        }
        return collection.get(pos);
    }

    @Override
    public boolean hasNext() {
        if(pos<collection.size()-1){
            return true;
        }else{
            return false;
        }
    }

    //使用迭代器
    public static void main(String[] args) {
        //定义集合
        Collection collection=new ListCollection();
        //向集合中添加数据
        collection.add("object1");
        collection.add("object2");
        //使用迭代器遍历集合
        Iterator it = collection.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
