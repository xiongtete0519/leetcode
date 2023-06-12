package Offer来了.设计模式.代理模式;

import java.util.HashMap;
import java.util.Map;

public class Proxy implements Company {
    private HR hr;

    public Proxy() {
        super();
        this.hr=new HR();
    }

    //需要代理的方法
    @Override
    public void findWoker(String title) {
        hr.findWoker(title);
        //通过猎头找候选人
        String worker = getWorker(title);
        System.out.println("find a worker by proxy,worker name is :"+worker);
    }

    private String getWorker(String title){
        Map<String,String> workerList=new HashMap<String,String>(){
            {
                put("Java","张三");
                put("Python","李四");
                put("Php","王五");
            }
        };
        return workerList.get(title);
    }

    //使用代理模式
    public static void main(String[] args) {
        Company company=new Proxy();
        company.findWoker("Java");
    }
}
