package 国赛复习.必拿下.蓝肽子序列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String str1 = s1.replaceAll("[A-Z]", "_$0");
        String str2 = s2.replaceAll("[A-Z]", "_$0");
        String[] a = str1.split("_");
        String[] b = str2.split("_");
        int n=a.length-1;
        int m=b.length-1;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m; j++) {
                if(a[i].equals(b[j])){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][m]);
        br.close();
    }
}
