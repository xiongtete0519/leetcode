package 模板题.解立方根;

import java.util.Scanner;

public class Main {
    public static final double PE=1e-6;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i <T; i++) {
            int N = scan.nextInt();
            midSearch(N);
        }
    }
    //二分法求解
    public static void midSearch(int x){
        double left=0;
        double right=x;
        while(right-left>PE){
            double mid = (left + right) / 2;
            if(mid*mid*mid<x){
                left=mid;
            }else{
                right=mid;
            }
        }
        //满足精度的时候输出：保留三位小数
        System.out.printf("%.3f\n",left);
    }
}
