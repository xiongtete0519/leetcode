package 知识点复习.比较器.比较器Comparable;

import java.util.Arrays;

public class Person implements Comparable<Person>{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.getAge()-o.getAge();
    }

    public static void main(String[] args) {
       Person[] pers={
                new Person("john",12),
                new Person("lily",23),
                new Person("lucy",5),
                new Person("jack",18),
        };
       //按照年龄字段排序
       Arrays.sort(pers);
       Arrays.stream(pers).forEach(System.out::println);
    }

}
