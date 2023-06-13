package Offer来了.设计模式.模板方法模式;
//存钱
public class SaveMoney extends AbstractTemplate {
    @Override
    public void handleBusiness() {
        System.out.println("save money to the bank.");
    }
}
