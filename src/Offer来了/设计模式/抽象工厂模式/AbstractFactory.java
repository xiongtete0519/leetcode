package Offer来了.设计模式.抽象工厂模式;


//抽象工厂
public abstract class AbstractFactory {
    public abstract Phone createPhone(String brand);
    public abstract Computer createComputer(String brand);

    //使用抽象工厂
    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory();
        Phone huaWei = phoneFactory.createPhone("HuaWei");
        Phone apple = phoneFactory.createPhone("Apple");
        System.out.println(huaWei.call());
        System.out.println(apple.call());

        ComputerFactory computerFactory = new ComputerFactory();
        Computer computerHuaWei = computerFactory.createComputer("HuaWei");
        Computer computerApple = computerFactory.createComputer("Apple");
        System.out.println(computerHuaWei.internet());
        System.out.println(computerApple.internet());
    }
}
