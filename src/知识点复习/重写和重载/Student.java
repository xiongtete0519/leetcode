package 知识点复习.重写和重载;

/**
 * 如果子类在构造方法中没有显示调用父类的构造方法，那么会默认隐式调用父类的无参构造方法。
 * 如果子类的构造方法使用super关键字显示调用父类的构造方法，那么就不会再去调用父类的无参构造方法
 * <p>
 * 方法的重写发生在运行时，因为在编译时，编译器无法知道我们到底是调用的父类方法还是子类方法，
 * 只有在实际运行的时候才知道应该调用哪个方法，这也是Java运行时多态的体现。
 */
public class Student extends Person {
    private String str = "234";

    public Student(String str) {
//        super(str);
        this.str = str;
        System.out.println("子类的有参构造函数:" + str);
    }

    public Student() {
//        super();
        System.out.println("子类无参构造函数");
    }


    @Override
    public void fun() {
        System.out.println("子类的fun函数");
    }

    public static void main(String[] args) {
//        Student student = new Student();
//        student.fun();
//        Person person=new Student();
//        person.fun();
//        new Student("222").fun();
        Person person = new Student("222");
        person.fun();
    }
}

class Person {
    private String str = "123";

    public Person(String str) {
        this.str = str;
        System.out.println("父类有参构造函数：" + this.str);
    }

    public Person() {
        System.out.println("父类无参构造函数");
    }

    public void fun() {
        System.out.println("父类的fun函数:" + str);
    }
}
