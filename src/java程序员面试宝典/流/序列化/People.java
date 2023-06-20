package java程序员面试宝典.流.序列化;

import java.io.*;

public class People implements Serializable {
    private static final long serialVersionUID=1L;
    private String name;
    private int age;

    public People() {
        this.name="lili";
        this.age=20;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        People p = new People();
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        try{
            FileOutputStream fos = new FileOutputStream("people.out");
            oos=new ObjectOutputStream(fos);
            oos.writeObject(p);
            oos.close();
        }catch (Exception e){
        }
        People p1;
        try{
            FileInputStream fis = new FileInputStream("people.out");
            ois=new ObjectInputStream(fis);
            p1=(People)ois.readObject();
            System.out.println("name:"+p1.getName());
            System.out.println("age:"+p1.getAge());
            ois.close();
        }catch (Exception e){

        }
    }
}
