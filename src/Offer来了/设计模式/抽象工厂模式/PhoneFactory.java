package Offer来了.设计模式.抽象工厂模式;

public class PhoneFactory extends AbstractFactory{
    @Override
    public Phone createPhone(String brand) {
        if("HuaWei".equals(brand)){
            return new PhoneHuaWei();
        }else if("Apple".equals(brand)){
            return new PhoneApple();
        }else{
            return null;
        }
    }

    @Override
    public Computer createComputer(String brand) {
        return null;
    }
}
