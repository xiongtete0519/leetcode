package 知识点复习.重写和重载;

/**
 * 方法的重载发生在编译时，在编译过程中，编译器必须根据参数类型以及长度来确定调用的哪个方法，
 * 这也是Java编译时多态的体现。
 */
public class Test {

    public int compute(int a, int b) {
        return a + b;
    }

    public int compute(int a, int b, int c) {
        return a + b + c;
    }

    public int compute(int a, String b) {
        return a;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.compute(1, 2));
        System.out.println(test.compute(1, 2, 3));
        System.out.println(test.compute(1, "23"));
    }

}
