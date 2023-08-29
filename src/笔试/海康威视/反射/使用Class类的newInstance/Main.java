package 笔试.海康威视.反射.使用Class类的newInstance;

class MyClass {
    public MyClass() {
        System.out.println("Constructor called");
    }
}

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<MyClass> clazz = MyClass.class;
        MyClass obj = clazz.newInstance();
    }
}
