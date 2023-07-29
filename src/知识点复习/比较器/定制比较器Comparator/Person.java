package 知识点复习.比较器.定制比较器Comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Person {
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

    public static void main(String[] args) {
        Person[] pers={
                new Person("john",12),
                new Person("lily",23),
                new Person("lucy",5),
                new Person("jack",18),
        };
        List<Person> people = Arrays.asList(pers);
        //按照年龄排序
        // people.stream().sorted((o1, o2) -> o1.getAge()-o2.getAge()).forEach(System.out::println);
        people.stream().sorted(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        }).forEach(System.out::println);
    }
}
