package java程序员面试宝典.java基础知识.练习.test11;
class A{
    void f(){
        System.out.println("A.f() is called");
    }
}
class B extends A{
    void f(){
        System.out.println("B.f() is called");
    }
    void g(){
        System.out.println("B.g() is called");
    }
}
public class Test {
    public static void main(String[] args) {
        A a=new B();
//        a.g();    //编译错误
    }
}
