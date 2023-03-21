package 模拟题.蓝肽子序列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        //_$0表示在匹配到的大写字母前加一个下划线(作为我们的分隔符)  还要去除第一个下划线
        String str1 = s1.replaceAll("[A-Z]", "_$0").substring(1);
        String str2 = s2.replaceAll("[A-Z]", "_$0").substring(1);
        String[] a = str1.split("_");
        String[] b = str2.split("_");
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
        int n = a.length;
        int m = b.length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if(a[i-1].equals(b[j-1])){
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
