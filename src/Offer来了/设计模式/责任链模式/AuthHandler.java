package Offer来了.设计模式.责任链模式;
//定义用户授权类AuthHandler
public class AuthHandler extends AbstractHandler implements Handler{

    private String name;

    public AuthHandler(String name){
        this.name=name;
    }
    @Override
    public void operator() {
        System.out.println("user auth...");
        if(getHandler()!=null){
            //执行责任链的下一个流程
            getHandler().operator();
        }
    }
}
