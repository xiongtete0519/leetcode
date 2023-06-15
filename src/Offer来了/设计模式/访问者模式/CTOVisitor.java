package Offer来了.设计模式.访问者模式;

import com.alibaba.fastjson2.JSON;

import java.util.Date;

public class CTOVisitor implements Visitor {
    @Override
    public void visit(ProjectElement element) {
        System.out.println("CTO Visitor Element");
        element.signature("CTO",new Date());
        System.out.println(JSON.toJSON(element));
    }
}
