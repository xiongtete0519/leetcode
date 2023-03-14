package study.最短路径;

import java.util.Arrays;
import java.util.Scanner;

//最短路径，邻接矩阵实现
public class Dijkstra {
//    public static int M=10000;
//    public static int N = 10000;
    public static int n,m,s;
    static int[][] mp;  //地图：邻接矩阵存储
    static int[] dis;   //dis[v]：从s到v的最短路径长度
    static boolean[] vis;//标记是否已经被访问
    public static void initmp(){
        for (int i = 0; i <mp.length ; i++) {
            Arrays.fill(mp[i],Integer.MAX_VALUE);
        }
    }
    //求源点s到其他点的最短路径
    public static void dijkstra(int s){
        //false表示蓝点(未确定最短路径的带能),true表示白点(确定路径的点)
        Arrays.fill(vis,false);
        //默认情况下设置为无穷大
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[s]=0;   //自己到自己的距离是0
        while(true){
            int mini=0;
            int min_=Integer.MAX_VALUE;
            for (int j = 1; j <=n ; j++) {
                if(!vis[j]&&min_>dis[j]){//从蓝点触发找出最小的点
                    mini=j;
                    min_=dis[j];
                }
            }
            //如果没找到蓝点，说明结束
            if(mini==0){
                break;
            }
            vis[mini]=true; //将当前点mini设置为白点
            for (int i = 1; i <=n ; i++) {
                if(!vis[i] &&dis[i]>dis[mini]+mp[mini][i]){
                    dis[i]=dis[mini]+mp[mini][i];
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n= scan.nextInt();
        m=scan.nextInt();
        mp=new int[n+1][n+1];
        dis=new int[n+1];
        vis=new boolean[n+1];
        initmp();
        for (int i = 0; i <m ; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();
            if(mp[u][v]>w){
                mp[u][v]=mp[v][u]=w;
            }
        }
        dijkstra(1);
//        System.out.printf("%d\n",dis[n]);
        Arrays.stream(dis).skip(1).forEach(x->{
            System.out.print(x+" ");
        });

    }
}
