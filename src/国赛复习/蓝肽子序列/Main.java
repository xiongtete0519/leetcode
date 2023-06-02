package 国赛复习.蓝肽子序列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//dp[i][j]:A串前i个元素和B串前j个元素的最长公共子序列的长度
public class Main {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s1 = br.readLine();
        String s2 = br.readLine();
        //_$0表示在匹配到的大写字母前加一个下划线(作为我们的分隔符)，最后用substring去除开头的下划线
        String str1 = s1.replaceAll("[A-Z]", "_$0").substring(1);
        String str2 = s2.replaceAll("[A-Z]", "_$0").substring(1);
//        System.out.println(str1);
//        System.out.println(str2);
        String[] a = str1.split("_");
        String[] b = str2.split("_");
        int n=a.length;
        int m=b.length;
        int[][] dp=new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m; j++) {
                if(a[i-1].equals(b[j-1])){//a和b下标都是从0开始，所以这里用i-1和j-1下标比较
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
