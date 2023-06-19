package java程序员面试宝典.java基础知识.练习.test17;

public class Test {

    public static String fun1(){
        try{
            System.out.print("A");
            return fun2();
        }finally {
            System.out.print("B");
        }
    }
    public static String fun2(){
        System.out.print("C");
        return "D";
    }

    public static void main(String[] args) {
        System.out.print(fun1());
    }
}
