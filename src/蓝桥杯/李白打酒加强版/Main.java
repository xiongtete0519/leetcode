package 蓝桥杯.李白打酒加强版;

import java.util.Scanner;

/**
 * a代表店、b代表花、c代表初始酒量
 */
public class Main {
    private static int count=0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        System.out.println(fun(n,m,2));
    }

    public static int fun(int a,int b,int c){
        //出口：最后一次遇到花，说明店没有了，酒剩最后一抖，最后一次赏花后会喝完
        if(a==0&&b==1&&c==1){
            count++;
        }
        if(a>0){//碰到店了  酒量加倍
            fun(a-1,b,c*2);
        }
        //碰到花了，花-1，酒量-1
        if(b>1){
            fun(a,b-1,c-1);
        }
        return count;
    }
}
