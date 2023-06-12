package Offer来了.设计模式.原型模式;

public class ComputerDetail implements Cloneable {
    private String cpu;
    private String memory;
    private Disk disk;

    public ComputerDetail(String cpu, String memory, Disk disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ComputerDetail computerDetail = (ComputerDetail) super.clone();
        computerDetail.disk = (Disk) this.disk.clone();
        return computerDetail;
    }

    @Override
    public String toString() {
        return "ComputerDetail{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk=" + disk +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        //浅拷贝
        Computer computer = new Computer("8core", "16G", "1TB");
        System.out.println("brfore simple clone:"+computer.toString());
        Computer computerClone = (Computer) computer.clone();
        System.out.println("after simple clone:"+computerClone.toString());

        //深拷贝
        Disk disk = new Disk("208G", "2TB");
        ComputerDetail computerDetail = new ComputerDetail("12core", "64G", disk);
        System.out.println("before deep clone:"+computerDetail.toString());
        ComputerDetail computerDetailClone = (ComputerDetail) computerDetail.clone();
        System.out.println("after deep clone:"+computerDetailClone.toString());
    }
}
class Disk implements Cloneable{
    private String ssd;
    private String hhd;

    public Disk(String ssd, String hhd) {
        this.ssd = ssd;
        this.hhd = hhd;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Disk{" +
                "ssd='" + ssd + '\'' +
                ", hhd='" + hhd + '\'' +
                '}';
    }
}
