package Offer来了.设计模式.命令模式;
//命令接收和执行者类
public class Receiver {
    //接收并执行命令
    public void action(String command){
        System.out.println("command received,now execute command");
    }

    public static void main(String[] args) {
        //定义命令接收和执行者
        Receiver receiver = new Receiver();
        //定义命令实现类
        Command cmd=new ConcreteCommand(receiver);
        //定义命令调用者
        Invoker invoker = new Invoker(cmd);
        //命令调用
        invoker.action("command1");
    }
}
