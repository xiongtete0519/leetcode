package 笔试.海康威视;

public class Demo {
    static Demo demo = new Demo();
    static int a;
    static int b = 1;

    Demo() {
        a++;
        b++;
    }

    static Demo getInstance() {
        return demo;
    }

    public static void main(String[] args) {
        Demo demo = Demo.getInstance();
        System.out.println(a + " " + b);
    }
}
