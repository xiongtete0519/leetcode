package Offer来了.设计模式.责任链模式;
//定义AbstractHandler类
public abstract class AbstractHandler {
    private Handler handler;

    public Handler getHandler(){
        return handler;
    }
    public void setHandler(Handler handler){
        this.handler=handler;
    }
}
