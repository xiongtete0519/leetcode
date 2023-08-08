package 知识点复习.反射;

import java.lang.reflect.Field;

public class Person {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        System.out.println("原始值：" + student.getPrivateField());

        Field privateField = Student.class.getDeclaredField("privateField");
        //为反射对象设置可访问标志。true表示屏蔽Java语言的访问检查，使得对象的私有属性也可以被查询和设置
        privateField.setAccessible(true);
        privateField.set(student, "New Value");
        System.out.println("修改后的值：" + student.getPrivateField());
    }
}

class Student {
    private String privateField = "Original Value";

    public String getPrivateField() {
        return privateField;
    }
}
