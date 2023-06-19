package java程序员面试宝典.java基础知识.反射;

import java.lang.reflect.Field;

public class ReadOnlyClass {
    private Integer age=20;
    public Integer getAge(){
        return this.age;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ReadOnlyClass readOnlyClass = new ReadOnlyClass();
        Class<ReadOnlyClass> aClass = ReadOnlyClass.class;
        Field field = aClass.getDeclaredField("age");
        field.setAccessible(true);
        field.set(readOnlyClass,30);
        System.out.println(readOnlyClass.getAge());
    }
}
