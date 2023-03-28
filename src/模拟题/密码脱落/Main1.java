package 模拟题.密码脱落;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 求字符串中有几个单泵字符，在现在的字符串中，找那个最长回文子串，
 * 不在最长回文子串中的字符就是单泵字符。
 * 将字符串逆置，找两个串的最长公共子序列，这个最长的公共子序列一定是回文，
 * 且字符串的长度-最长公共子序列的长度=最小掉落的种子
 * dp[i][j]表示a[0:i]和b[0:j]的最长公共子序列的长度
 * dp[0][j]=0,dp[i][0]=0
 */
public class Main1 {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        String str = nextString();
        String str1 = new StringBuffer(str).reverse().toString();
//        System.out.println(str);
//        System.out.println(str1);
        char[] c1 = str.toCharArray();
        char[] c2 = str1.toCharArray();
        int n=str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n ; j++) {
                if(c1[i-1]==c2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        //求出最长公共子序列的长度
        int len = dp[n][n];
        //最小调用的种子=字符串长度-最长公共子序列的长度
        int min = str.length() - len;
        System.out.println(min);
    }

    public static String nextString() throws IOException{
        st.nextToken();
        return st.sval;
    }
}
