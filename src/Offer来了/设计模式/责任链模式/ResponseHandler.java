package Offer来了.设计模式.责任链模式;
//定义请求反馈类
public class ResponseHandler extends AbstractHandler implements Handler{
    private String name;
    public ResponseHandler(String name){
        this.name=name;
    }
    @Override
    public void operator() {
        System.out.println("message response...");
        if(getHandler()!=null){ //执行责任链的下一个流程
            getHandler().operator();
        }
    }

    //使用责任链模式
    public static void main(String[] args) {
        AuthHandler authHandler = new AuthHandler("auth");
        BusinessHandler businessHandler = new BusinessHandler("business");
        ResponseHandler responseHandler = new ResponseHandler("response");
        authHandler.setHandler(businessHandler);
        businessHandler.setHandler(responseHandler);
        authHandler.operator();
    }
}
