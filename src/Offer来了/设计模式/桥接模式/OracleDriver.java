package Offer来了.设计模式.桥接模式;

public class OracleDriver implements Driver {
    @Override
    public void executeSQL() {
        System.out.println("execute sql by oracle driver");
    }
}
