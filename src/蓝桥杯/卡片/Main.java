package 蓝桥杯.卡片;


import java.util.Scanner;

public class Main {

    //解法一：一直进行分卡片的操作，用count记录卡片分给了多少人
    //做最后人数达到了n,输出人数i就行。
    public static void sum1(){
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();   //给定的人数
        int count=0;    //统计卡片分给了多少人
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            for (int j =1; j <=i; j++) {
                count++;
                if(count>=n){
                    System.out.println(i);//输出卡片的种类
                    return;
                }
            }
        }
        scan.close();
    }
    /**
     * 方法二：
     * 1:(1,1)->1
     * 2:(1,1)(1,2)(2,2)->3=1+2
     * 3:(1,1),(1,2),(1,3),(2,2),(2,3),(3,3)->6=3+3
     * sum(k)=sum(k-1)+k
     */
    public static void sum2(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sum=0;  //sum(0)=0   sum(1)=sum(0)+1=1
        int k=1;
        while(sum<n){
            sum=sum+k;  //sum(k)=sum(k-1)+k
            if(sum>=n){
                break;
            }
            k++;
        }
        System.out.println(k);
        scan.close();
    }
    public static void main(String[] args) {
        sum2();
    }
}
