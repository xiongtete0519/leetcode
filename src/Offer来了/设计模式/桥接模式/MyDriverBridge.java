package Offer来了.设计模式.桥接模式;

public class MyDriverBridge extends DriverManagerBridge {
    @Override
    public void execute() {
        getDriver().executeSQL();
    }

    //使用桥接模式
    public static void main(String[] args) {
        DriverManagerBridge driverManagerBridge=new MyDriverBridge();
        //设置MySQL驱动
        driverManagerBridge.setDriver(new MysqlDriver());
        driverManagerBridge.execute();

        //切换到oracle驱动
        driverManagerBridge.setDriver(new OracleDriver());
        driverManagerBridge.execute();
    }
}
