package Offer来了.设计模式.状态模式;
//存储状态和执行不同状态下的行为
public class Context {
    private AbstractState state;

    public Context(AbstractState state) {
        this.state = state;
    }

    public AbstractState getState() {
        return state;
    }

    public void setState(AbstractState state) {
        this.state = state;
    }
    public void action(){
        this.state.action(this);
    }

    //使用状态模式
    public static void main(String[] args) {
        //定义当前状态为工作状态
        Context context = new Context(new WorkState());
        context.action();
        //切换当前状态为假期状态
        context.setState(new HolidayState());
        context.action();
    }
}
