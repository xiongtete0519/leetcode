package java程序员面试宝典.java基础知识.值传递与引用传递;

public class Test {
    public static void changeStringBuffer(StringBuffer ss1,StringBuffer ss2){
        ss1.append("world");
        ss2=ss1;
    }

    public static void main(String[] args) {
        Integer a=1;
        Integer b=a;
        b++;
        System.out.println(a);
        System.out.println(b);
        StringBuffer s1 = new StringBuffer("hello");
        StringBuffer s2 = new StringBuffer("hello");
        changeStringBuffer(s1,s2);
        System.out.println(s1);
        System.out.println(s2);
    }
}
