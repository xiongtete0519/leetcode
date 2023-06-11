package Offer来了.设计模式.工厂模式;

public class Factory {
    public Phone createPhone(String phoneName){
        if("HuaWei".equals(phoneName)){
            return new HuaWei();
        }else if("Apple".equals(phoneName)){
            return new Iphone();
        }else{
            return null;
        }
    }
    //使用工厂模式
    public static void main(String[] args) {
        Factory factory = new Factory();
        Phone huaWei = factory.createPhone("HuaWei");
        Phone iphone = factory.createPhone("Apple");
        System.out.println(huaWei.brand());
        System.out.println(iphone.brand());
    }
}
