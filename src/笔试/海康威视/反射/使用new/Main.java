package 笔试.海康威视.反射.使用new;

class MyClass {
    public MyClass() {
        System.out.println("Constructor called");
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
    }
}
