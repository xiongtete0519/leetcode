package Offer来了.设计模式.代理模式;

public class HR implements Company {

    @Override
    public void findWoker(String title) {
        System.out.println("i neet find a worker,title is :"+title);
    }
}
