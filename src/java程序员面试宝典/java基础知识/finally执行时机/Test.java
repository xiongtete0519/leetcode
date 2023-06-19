package java程序员面试宝典.java基础知识.finally执行时机;

public class Test {
    public static int testFinally(){
        try{
            return 1;
        }catch (Exception e){
            return 0;
        }finally {
            System.out.println("execute finally");
        }
    }
    public static void main(String[] args) {
        int result=testFinally();
        System.out.println(result);
    }
}
