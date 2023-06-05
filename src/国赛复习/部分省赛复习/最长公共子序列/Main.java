package 国赛复习.部分省赛复习.最长公共子序列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException{
        int n=nextInt();
        int m=nextInt();
        int[] a=new int[n+1];
        int[] b=new int[m+1];
        int[][] dp=new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            a[i]=nextInt();
        }
        for (int i = 1; i <=m ; i++) {
            b[i]=nextInt();
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m ; j++) {
                if(a[i]==b[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }
}
