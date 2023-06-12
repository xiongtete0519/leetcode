package Offer来了.设计模式.原型模式;
//浅拷贝
public class Computer implements Cloneable {
    private String cpu;
    private String memory;
    private String disk;

    public Computer(String cpu, String memory, String disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {    //浅拷贝
        return super.clone();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                '}';
    }
}
