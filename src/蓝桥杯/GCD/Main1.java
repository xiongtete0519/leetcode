package 蓝桥杯.GCD;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextLong();
        long b = scan.nextLong();
        long a1= Math.max(a, b);
        long b1= Math.min(a, b);
        long k = gcd(a1,b1);
        for (int i = 1; i <Long.MAX_VALUE; i++) {
            long temp = gcd(a1 + i, b1 + i);
            if(temp>k){
                System.out.println(i);
                break;
            }
        }


    }
    //gcd(a,b)=gcd(b,a%b)  a>b
    public static long gcd(long a,long b){
        if(a%b==0){
            return b;
        }
        return gcd(b,a%b);
    }
}
