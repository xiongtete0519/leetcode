package 知识点复习.JDK动态代理;

public class Test {
    public static void main(String[] args) {
        SmsService smsService= (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}
