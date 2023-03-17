package 模板题.绝世武功;

import java.util.Scanner;
//方法1：等差数列求和公式(超时)
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        long res=0;
        for (int i = 0; i <m ; i++) {
            long l = scan.nextLong();
            long r = scan.nextLong();
            long s = scan.nextLong();
            long e = scan.nextLong();
            res+=(s+e)*(r-l+1)/2;   //等差数列求和公式
        }
        System.out.println(res);
        scan.close();
    }
}
