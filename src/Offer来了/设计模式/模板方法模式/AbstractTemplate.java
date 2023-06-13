package Offer来了.设计模式.模板方法模式;

public abstract class AbstractTemplate {

    //模板方法，用于核心流程和算法的定义
    public void templateMethod(){
        checkNumber();
        queueUp();
        handleBusiness();
        serviceEvaluation();
    }
    //1:抽号
    public void checkNumber(){
        System.out.println("checkNumber......");
    }
    //2:排队
    public void queueUp(){
        System.out.println("queue up......");
    }
    //3:办理业务
    public abstract void handleBusiness();
    //4:服务评价
    public void serviceEvaluation(){
        System.out.println("business finished,service evaluation......");
    }
}
