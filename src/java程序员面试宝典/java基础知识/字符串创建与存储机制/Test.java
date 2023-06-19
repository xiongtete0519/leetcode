package java程序员面试宝典.java基础知识.字符串创建与存储机制;

public class Test {
    public static void main(String[] args) {
        String s1 = new String("a");
        s1.intern();
        String s2="a";
        System.out.println(s1==s2);

        String s3=new String("a")+new String("a");
        s3.intern();
        String s4="aa";
        System.out.println(s3==s4);
    }
}
