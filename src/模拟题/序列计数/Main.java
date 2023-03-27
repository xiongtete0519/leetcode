package 模拟题.序列计数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
//dp[old][now]:old为之前的元素，now为当前的元素的序列总和。
//dp(old,now)=dp(now,1)+...+dp(now,|old-now|-1)+1
//有2、3条件得出：dp(old,now)=1+dp(old,now-1)+dp(now,|old-now|-1)
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static int n;
    public static final int MOD=10000;
    public static int[][] dp;
    public static void main(String[] args) throws IOException{
        n= nextInt();
        dp=new int[n+1][n+1];
        System.out.println(dfs(n,n));
    }
    public static int dfs(int old,int now){
        if(now<=0){
            return 0;
        }
        if(dp[old][now]!=0){
            return dp[old][now];
        }
        //
        dp[old][now]=(1+dfs(old,now-1)+dfs(now,Math.abs(old-now)-1))%MOD;
        return dp[old][now];
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
