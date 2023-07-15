package 知识点复习.JDK动态代理;
//实现发送短信的接口
public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println("send message:"+message);
        return message;
    }
}
