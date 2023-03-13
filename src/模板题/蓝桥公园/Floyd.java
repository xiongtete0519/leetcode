package 模板题.蓝桥公园;

import java.util.Arrays;
import java.util.Scanner;

public class Floyd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();//N个景点
        int M = scan.nextInt();//经典之间共M条路
        int Q = scan.nextInt();//Q个观景计划
        long[][] dist = new long[N + 1][N + 1];
        for (int i = 1; i <=M ; i++) {  //初始化为最大值
            Arrays.fill(dist[i],Long.MAX_VALUE);
            dist[i][i]=0; //对角线赋值0即可(自己到自己)
        }
        for (int i = 1; i <=M; i++) {  //初始化两点距离
            int u = scan.nextInt();
            int v = scan.nextInt();
            long w = scan.nextLong();
            dist[u][v]=Math.min(dist[u][v],w);
            dist[v][u]=Math.min(dist[v][u],w);
        }
        //Floyd算法
        for (int k = 1; k <=N; k++) {
            for (int i = 1; i <=N ; i++) {
                for (int j = 1; j <=N; j++) {
                    if(dist[i][j]>dist[i][k]+dist[k][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        //查询
        for (int i = 0; i <Q ; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            if(dist[start][end]>=Long.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(dist[start][end]);
            }
        }
    }
}
