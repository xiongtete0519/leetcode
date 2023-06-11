package Offer来了.设计模式.抽象工厂模式;

public class ComputerFactory extends AbstractFactory {
    @Override
    public Phone createPhone(String brand) {
        return null;
    }

    @Override
    public Computer createComputer(String brand) {
        if("HuaWei".equals(brand)){
            return new ComputerHuaWei();
        }else if("Apple".equals(brand)){
            return new ComputerApple();
        }else{
            return null;
        }
    }
}
