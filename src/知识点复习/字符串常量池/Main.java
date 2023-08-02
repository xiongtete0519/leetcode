package 知识点复习.字符串常量池;

public class Main {
    public static void main(String[] args) {
        String s1 = "java";
        String s2 = s1.intern();
        String s3 = new String("java");
        String s4 = s3.intern();

        System.out.println(s1 == s2);//true
        System.out.println(s3 == s4);//false
        System.out.println(s1 == s4);//true
    }
}
