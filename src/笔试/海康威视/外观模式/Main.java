package 笔试.海康威视.外观模式;

// CPU 类
class CPU {
    public void start() {
        System.out.println("启动 CPU");
    }
}

// Memory 类
class Memory {
    public void start() {
        System.out.println("启动内存");
    }
}

// Disk 类
class Disk {
    public void start() {
        System.out.println("启动硬盘");
    }
}

// Computer 类（外观类）
class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.disk = new Disk();
    }

    public void start() {
        cpu.start();
        memory.start();
        disk.start();
        System.out.println("电脑启动完成");
    }
}

//使用外观模式
public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
    }
}
