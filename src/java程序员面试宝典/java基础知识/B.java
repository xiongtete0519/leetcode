package java程序员面试宝典.java基础知识;

class A{
    public static String c="C";
    static{
        System.out.println("A");
    }
}
public class B  extends A{
    static{
        System.out.println("B");
    }

    public static void main(String[] args) {
        System.out.println(B.c);
    }
}
