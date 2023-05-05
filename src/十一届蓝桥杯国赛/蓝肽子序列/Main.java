package 十一届蓝桥杯国赛.蓝肽子序列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 本题为最长公共子序列(LCS)的变形
 * LCS是判断字符相等，这里我们判断蓝肽是否相等即可。
 *将字符出分割为每个大写字母开头的蓝肽
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        //_$0表示在匹配到的大写字母前加一个下划线(作为我们的分隔符)  还要去除开头的下划线
        String str1 = s1.replaceAll("[A-Z]", "_$0").substring(1);
        String str2 = s2.replaceAll("[A-Z]", "_$0").substring(1);
        String[] a = str1.split("_");
        String[] b = str2.split("_");
        int n=a.length;
        int m=b.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(a[i-1].equals(b[j-1])){  //a和b下标都是从0开始的，所以这里用i-1和j-1下标比较
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
