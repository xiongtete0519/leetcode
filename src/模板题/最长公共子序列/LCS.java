package 模板题.最长公共子序列;

import java.util.Scanner;
//动态规划解法
//dp[i][j]表示a[0:i]和b[0:j]的最长公共子序列的长度
//dp[0][j]=0,dp[i][0]=0
public class LCS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[m + 1];
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <=n ; i++){
            a[i]=scan.nextInt();
        }
        for (int i = 1; i <=m; i++){
           b[i]=scan.nextInt();
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m; j++) {
                if(a[i]==b[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][m]);
//        for (int i = 1; i <=n ; i++) {
//            for (int j = 1; j <=m ; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//        }
        scan.close();
    }
}
