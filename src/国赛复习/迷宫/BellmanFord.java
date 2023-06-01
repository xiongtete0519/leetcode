package 国赛复习.迷宫;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    public static List<int[]> edges=new ArrayList<>();
    public static int[] dist;
    public static int[] prev;
    public static int[] g;  //g[i]表示到达i城市需要隔离的时间
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        int m=nextInt();
        dist=new int[m+1];
        prev=new int[m+1];
        g=new int[n+1];
        //每个城市的隔离时间
        for (int i = 1; i <= n; i++) {
            g[i]=nextInt();
        }
        g[n]=0; //终点的隔离时间不需要考虑
        for (int i = 1; i <=m; i++) {
            int u=nextInt();
            int v=nextInt();
            int c=nextInt();
            //需要在权值的基础上加上隔离时间
            edges.add(new int[]{u,v,c+g[v]});
            edges.add(new int[]{v,u,c+g[u]});
        }
        //初始化
        Arrays.fill(dist,Integer.MAX_VALUE>>1);
        Arrays.fill(prev,-1);
        int s=1;//起点
        dist[s]=0;
        for (int i =1; i <=n-1 ; i++) {
            for (int[] edge : edges) {
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];
                if(dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    prev[v]=u;
                }
            }
        }
        System.out.println(dist[n]);
        System.out.println(Arrays.toString(dist));
        System.out.println(Arrays.toString(prev));
        //输出从起点出发到每个点的最短路径
        for (int i = 1; i <=n ; i++) {
            print(s,i);
            System.out.println();
        }
    }
    //Bellman-Ford输出路径：倒着往回找路径，正着输出
    public static void print(int start,int end){
        if(start==end){
            System.out.print(start+" ");
            return;
        }
        print(start,prev[end]);//不断查找end的前驱，直到前驱节点为start
        System.out.print(end+" ");
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
