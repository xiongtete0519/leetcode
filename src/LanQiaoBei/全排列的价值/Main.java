package LanQiaoBei.全排列的价值;

import java.util.Scanner;

public class Main {
    public static final Integer MOD=998244353;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long dp=0;
        long f=1;
        int n = scan.nextInt();
        for (int i = 2; i <=n ; i++) {
            dp=(dp*i+f*i*(i-1)/2)%MOD;
            f=(f*i)%MOD;
        }
        System.out.println(dp);
    }
}
