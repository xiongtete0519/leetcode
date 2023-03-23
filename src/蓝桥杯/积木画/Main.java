package 蓝桥杯.积木画;

import java.util.Scanner;
//找规律DP
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int N=10000010;
        int mod=1000000007;
        long[] dp = new long[N];
        dp[1]=dp[0]=1;
        dp[2]=2;
        for (int i = 3; i <=n ; i++) {
            dp[i]=(2*dp[i-1]+dp[i-3])%mod;
        }
        System.out.println(dp[n]);
        scan.close();

    }
}
