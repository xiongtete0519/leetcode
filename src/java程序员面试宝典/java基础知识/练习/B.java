package java程序员面试宝典.java基础知识.练习;

public class B extends Object {
    static{
        System.out.println("load B1");
    }
    public B(){
        System.out.println("create B");
    }
    static{
        System.out.println("Load B2");
    }
}
class A extends B{
    static{
        System.out.println("Load A");
    }
    public A(){
        System.out.println("create A");
    }

    public static void main(String[] args) {
        new A();
    }
}
