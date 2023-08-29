package 笔试.海康威视.反射.使用Constructor类的newInstance方法;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MyClass {
    public MyClass() {
        System.out.println("Constructor called");
    }
}

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<MyClass> clazz = MyClass.class;
        Constructor<MyClass> constructor = clazz.getDeclaredConstructor();
        MyClass obj = constructor.newInstance();
    }
}
