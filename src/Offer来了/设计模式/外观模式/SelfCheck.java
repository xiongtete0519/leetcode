package Offer来了.设计模式.外观模式;
//汽车自检器
public class SelfCheck {
    //启动后的自检
    public void startupCheck(){
        System.out.println("startup check finished.");
    }
    //关闭前的自检
    public void shutdownCheck(){
        System.out.println("shutdown check finished.");
    }
}
