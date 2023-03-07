package LanQiaoBei.GCD;

import java.util.Scanner;

public class Main {
    // 规律1：设：c = max(gcd(a+k,b+k))   则：c = abs(a, b)
    // 规律2：设：c = max(gcd(a+k,b+k))   则：i = c - a % c
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextLong();
        long b = scan.nextLong();
        long c=Math.max(a,b)-Math.min(a,b);
        long k = c - (a % c);
        System.out.println(k);
    }
    //gcd(a,b)=gcd(b,a%b)  a>b
    public static long gcd(long a,long b){
        if(a%b==0){
            return b;
        }
        return gcd(b,a%b);
    }
}
