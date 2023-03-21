package 模拟题.跳跃.动态规划;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
//dp[i][j]表示从(1,1)到达(i,j)位置获得的最大权值
public class Main {
    //当前位置只能由前面9个位置到达，所以都填了负号
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
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[][] a = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m ; j++) {
                a[i][j]=nextInt();
            }
        }
        for (int[] ints : dp) {
            Arrays.fill(ints,Integer.MIN_VALUE);
        }
        dp[1][1]=a[1][1];//初始化
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m; j++) {
                for (int k = 0; k <9; k++) {//9个位置扩展
                    //扩展
                    int x = i + dirs[k][0];
                    int y = j + dirs[k][1];
                    if(x>=1&&x<=n&&y>=1&&y<=m){ //判断是否越界
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
}
//3 5
//-4 -5 -10 -3 1
//7 5 -9 3 -10
//10 -2 6 -10 -4

//15