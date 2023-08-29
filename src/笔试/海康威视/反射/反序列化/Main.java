package 笔试.海康威视.反射.反序列化;

import java.io.*;

class MyClass implements Serializable {
    public MyClass() {
        System.out.println("Constructor called");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        MyClass obj;

        System.out.println("序列化");
        // Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("F:\\IDEA_test\\LeetCode\\src\\笔试\\海康威视\\反射\\反序列化\\object.ser"))) {
            obj = new MyClass();
            out.writeObject(obj);
        }
        System.out.println("反序列化");
        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("F:\\IDEA_test\\LeetCode\\src\\笔试\\海康威视\\反射\\反序列化\\object.ser"))) {
            obj = (MyClass) in.readObject();
        }
    }
}
