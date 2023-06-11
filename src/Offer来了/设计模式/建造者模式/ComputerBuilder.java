package Offer来了.设计模式.建造者模式;
//定义抽象接口ComputerBuilder来描述产品构造和装配的过程
public interface ComputerBuilder {
    void buildCpu();
    void buildMemory();
    void buildDisk();
    Computer buildComputer();
}
