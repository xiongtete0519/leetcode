package java程序员面试宝典.java基础知识.练习;

public class Test {
    static{
        System.out.print("A");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("java程序员面试宝典.java基础知识.练习.Test");
        System.out.print("Test");
        clazz.forName("java程序员面试宝典.java基础知识.练习.Test");
    }
}
