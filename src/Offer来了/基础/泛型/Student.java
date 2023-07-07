package Offer来了.基础.泛型;

//这里T只能为Number或其子类
public class Student<T extends Number>{
    private String name;
    private T score;
}
