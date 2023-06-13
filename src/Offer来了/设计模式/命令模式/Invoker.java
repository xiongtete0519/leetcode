package Offer来了.设计模式.命令模式;
//命令调用者类
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(String commandMessage){
        System.out.println("command sending...");
        command.exe(commandMessage);
    }
}
