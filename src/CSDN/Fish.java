package CSDN;

import java.util.Scanner;

public class Fish {

    /**
     *
     * @param x 星期，周几
     * @param n 天数
     * @return 小鱼总共游乐多少公里
     */
    public static int solution(int x,int n){
        int result=0;
        for (int i = 0; i < n; i++) {
           if(x!=6&&x!=7){
               result+=250;
           }
           if(x==7){
               x=1;
           }else{
               x++;
           }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x=scanner.nextInt();
        int n=scanner.nextInt();
        System.out.println(Fish.solution(x, n));
    }
}
