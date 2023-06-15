package Offer来了.设计模式.访问者模式;

import java.util.Date;

public class ProjectElement implements Element {
    private String projectName;
    private String projectContent;
    private String visitorName;
    private Date visitorTime;

    public ProjectElement(String projectName, String projectContent) {
        this.projectName = projectName;
        this.projectContent = projectContent;
    }
    public void signature(String visitorName,Date visitorTime){
        this.visitorName=visitorName;
        this.visitorTime=visitorTime;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public Date getVisitorTime() {
        return visitorTime;
    }

    public void setVisitorTime(Date visitorTime) {
        this.visitorTime = visitorTime;
    }

    //使用访问者模式
    public static void main(String[] args) {
        Element element=new ProjectElement("mobike","share bicycle");
        element.accept(new CTOVisitor());
        element.accept(new CEOVisitor());
    }
}
