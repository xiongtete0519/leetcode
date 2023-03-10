package AcWing.beibao;

import java.util.Arrays;
import java.util.Scanner;

//AcWing2
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); //物品数量
        int V = scan.nextInt(); //背包容量
        int[] w=new int[N+1];   //物品体积
        int[] v=new int[N+1];   //物品价值
        int[][] dp=new int[N+1][V+1];//存储最优解，我们的目的是f[N][V]
        for (int i = 1; i <=N; i++) {
            w[i]=scan.nextInt();
            v[i]=scan.nextInt();
        }
        for (int i = 1; i <=N; i++) {  //i代表物品
            for (int j = 1; j <=V; j++) {    //j代表背包容量
                if(w[i]>j){//装不下
                    dp[i][j]=dp[i-1][j];
                }else{
                    //max{不拿第i件物品，拿第i件物品}
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }
            }
        }
//        for (int[] ints : dp) {
//            for (int anInt : ints) {
//                System.out.print(anInt+" ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[N][V]);
        
    }
}
