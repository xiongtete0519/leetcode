package Offer来了.设计模式.外观模式;
//门面类
public class Starter {
    private Dashboard dashboard;
    private Engine engine;
    private SelfCheck selfCheck;

    public Starter() {
        this.dashboard=new Dashboard();
        this.engine=new Engine();
        this.selfCheck=new SelfCheck();
    }

    public void startup(){
        System.out.println("car begin startup");
        engine.startup();
        dashboard.startup();
        selfCheck.startupCheck();
        System.out.println("car startup finished");
    }

    public void shutdown(){
        System.out.println("car begin shutdown");
        selfCheck.shutdownCheck();
        engine.shutdown();
        dashboard.shutdown();
        System.out.println("car shutdown finished");
    }
    //使用外观模式
    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.startup();
        System.out.println("************");
        starter.shutdown();
    }
}
