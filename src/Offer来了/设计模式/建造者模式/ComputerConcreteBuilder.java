package Offer来了.设计模式.建造者模式;

public class ComputerConcreteBuilder implements ComputerBuilder {

    Computer computer;

    public ComputerConcreteBuilder(){
        computer=new Computer();
    }
    @Override
    public void buildCpu() {
        System.out.println("buildCpu...");
        computer.setCpu("8core");
    }

    @Override
    public void buildMemory() {
        System.out.println("buildMemory...");
        computer.setMemory("16G");
    }

    @Override
    public void buildDisk() {
        System.out.println("buildDisk...");
        computer.setDisk("1TB");
    }

    @Override
    public Computer buildComputer() {
        return computer;
    }
}
