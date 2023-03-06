package study.动态规划.青蛙跳阶问题;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println(ways(10));
    }
    public static int ways(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int a=1;
        int b=2;
        int temp=0;
        for (int i = 3; i <=n ; i++) {
            temp=a+b;
            a=b;
            b=temp;
        }
        return temp;
    }
}
