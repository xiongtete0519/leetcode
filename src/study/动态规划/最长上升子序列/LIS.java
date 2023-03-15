package study.动态规划.最长上升子序列;

import java.util.Scanner;
//最长上升子序列
public class LIS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <=n ; i++) {
            a[i]= scan.nextInt();
        }
        for (int i = 1; i <=n; i++) {
            dp[i]=1;
            for (int j = 1; j <i; j++) {
                if(a[j]<a[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            System.out.printf("dp[%d]=%d\n",i,dp[i]);
        }
    }
}
