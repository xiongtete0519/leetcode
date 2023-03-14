package 模板题.蓝桥王国;
import java.util.Arrays;
import java.util.Scanner;

//最短路径，邻接矩阵实现
public class Dijkstra {
    public static int n,m,s;
    static int[][] mp;  //地图：邻接矩阵存储
    static int[] dis;   //dis[v]：从s到v的最短路径长度
    static boolean[] vis;//标记是否已经被访问
    static int[] pre;   //记录前驱，方便最后输出最短路径
    public static void initmp(){
        for (int[] ints : mp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
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
                if(!vis[i] &&dis[mini]+mp[mini][i]<dis[i]){
                    dis[i]=dis[mini]+mp[mini][i];
                    pre[i]=mini;//设置i的前驱为mini
                }
            }
        }
    }
    //求到z的最短路径的路线
    public static void output(int z){
        if(z==0){
            return;
        }
        output(pre[z]);
        System.out.print(z+"->");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n= scan.nextInt();
        m=scan.nextInt();
        mp=new int[n+1][n+1];
        dis=new int[n+1];
        vis=new boolean[n+1];
        pre=new int[n+1];
        initmp();   //刚开始都设置无穷大
        for (int i = 0; i <m ; i++) {
            //u到v的距离为w
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();
            if(mp[u][v]>w){
                mp[u][v]=mp[v][u]=w;    //无向图
            }
        }
        dijkstra(1);    //1为起始点
        //输出从皇宫到编号为1-N建筑的最短距离
        Arrays.stream(dis).skip(1).forEach(x->{
            System.out.print(x+" ");
        });

//        System.out.println();
//        //从起点出发到每一个点的最短路径如下：
//        for (int i = 1; i <=n ; i++) {
//            output(i);
//            System.out.println();
//        }

    }
}

