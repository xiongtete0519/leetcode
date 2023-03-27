package 模拟题.排列数;


import java.util.Scanner;

/**
 * dp[i][j]表示填了前i个数，且填出来的排列是j单调序列的方案数
 */
public class Main {
    public static final int MOD=123456;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        scan.close();
        int[][] dp = new int[n + 1][k + 1];
        dp[1][1]=1;
        dp[2][1]=2;
        for (int i = 3; i <=n; i++) {
            for (int j = 1; j <=i&&j<=k; j++) {
                dp[i][j]+=dp[i-1][j]*j;
                dp[i][j]%=MOD;
                dp[i][j]+=dp[i-1][j-1]*2;
                dp[i][j]%=MOD;
                if(j>1){
                    dp[i][j]+=dp[i-1][j-2]*(i-j);
                    dp[i][j]%=MOD;
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
