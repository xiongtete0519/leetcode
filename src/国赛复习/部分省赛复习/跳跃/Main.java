package 国赛复习.部分省赛复习.跳跃;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static int[][] dirs={
            {0,-1},
            {0,-2},
            {0,-3},
            {-1,0},
            {-1,-1},
            {-1,-2},
            {-2,0},
            {-2,-1},
            {-3,0}
    };
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException{
        int n=nextInt();
        int m=nextInt();
        int[][] a=new int[n+1][m+1];
        int[][] dp=new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                a[i][j]=nextInt();
            }
        }
        for (int[] ints : dp) {
            Arrays.fill(ints,Integer.MIN_VALUE);
        }
        dp[1][1]=a[1][1];//初始化
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= m; j++) {
                for (int[] dir : dirs) {
                    int x=i+dir[0];
                    int y=j+dir[1];
                    if(x>=1&&x<=n&&y>=1&&y<=m){
                        dp[i][j]=Math.max(dp[i][j],dp[x][y]+a[i][j]);
                    }
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
