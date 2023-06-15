package Offer来了.设计模式.中介者模式;

public class ConcreteMediator extends Mediator {
    public ConcreteMediator(Colleague colleagueTenant, Colleague colleagueLandlord) {
        super(colleagueTenant, colleagueLandlord);
    }

    //向房客传递信息
    @Override
    public boolean notifyColleagueTenant(String message) {
        if(colleagueTenant!=null){
            return colleagueTenant.operation(message);
        }
        return false;
    }
    //向房东传递信息
    @Override
    public boolean notifyColleagueLandlord(String message) {
        if(colleagueLandlord!=null){
            return colleagueLandlord.operation(message);
        }
        return false;
    }

    //使用中介者模式
    public static void main(String[] args) {
        //定义房同事类
        Colleague colleagueTenant=new ColleagueTenant();
        //定义房东同事类
        Colleague colleagueLandlord=new ColleagueLandlord();
        //创建一个具体的中间者，这里可以将其理解为房屋中介
        ConcreteMediator concreteMediator=new ConcreteMediator(colleagueTenant,colleagueLandlord);
        boolean result = concreteMediator.notifyColleagueTenant("想租两室一厅的吗？");
        if(result){
            concreteMediator.notifyColleagueLandlord("租客对面积满意");
        }else {
            concreteMediator.notifyColleagueLandlord("租客对面积不满意");
        }
    }
}
