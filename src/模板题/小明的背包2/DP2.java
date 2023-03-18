package 模板题.小明的背包2;

import java.util.Arrays;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class DP2 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int V = sc.nextInt();
      int[] w = new int[N+1];
      int[] v = new int[N+1];
      for(int i = 1;i <= N;i++){
        w[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }

      int[][] dp = new int[N+1][V+1];
      for(int i = 1;i <= N;i++){
        for(int j = 1;j <=V;j++){
          if(j >= w[i]){
            dp[i][j] = Math.max(v[i]+dp[i][j-w[i]],dp[i-1][j]);
          }else{
            dp[i][j] = dp[i-1][j];
          }
        }
      }
      System.out.println(dp[N][V]);

      Arrays.stream(dp).forEach(x->{
        System.out.println(Arrays.toString(x));
      });
      sc.close();

    }
}