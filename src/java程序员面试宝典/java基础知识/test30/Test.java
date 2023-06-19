package java程序员面试宝典.java基础知识.test30;

public class Test {
    public static void main(String[] args) {
        String s="abc";
        String s1="ab"+"c";
        System.out.println(s==s1);


        String s2="hello";
        String s3="hello";
        System.out.println(s2==s3);

        String s4="aaa";
        String s5=new String("aaa");
        System.out.println(s4==s5);
    }
}
