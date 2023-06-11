package Offer来了.设计模式.建造者模式;
//定义ComputerDirector使用Builder接口实现产品的装配
public class ComputerDirector {
    public Computer constructComputer(ComputerBuilder computerBuilder){
        computerBuilder.buildMemory();;
        computerBuilder.buildCpu();
        computerBuilder.buildDisk();
        return computerBuilder.buildComputer();
    }


    public static void main(String[] args) {
        ComputerDirector computerDirector = new ComputerDirector();
        ComputerConcreteBuilder computerConcreteBuilder = new ComputerConcreteBuilder();
        Computer computer = computerDirector.constructComputer(computerConcreteBuilder);

        System.out.println(computer.getCpu());
        System.out.println(computer.getDisk());
        System.out.println(computer.getMemory());
    }
}
