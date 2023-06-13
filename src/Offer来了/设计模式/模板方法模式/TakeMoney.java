package Offer来了.设计模式.模板方法模式;
//取钱
public class TakeMoney extends AbstractTemplate{

    @Override
    public void handleBusiness() {
        System.out.println("take money from bank.");
    }

    //使用模板模式
    public static void main(String[] args) {
        //办理取钱流程
        AbstractTemplate template1=new TakeMoney();
        template1.templateMethod();
        //办理存钱流程
        AbstractTemplate template2=new SaveMoney();
        template2.templateMethod();
    }
}
