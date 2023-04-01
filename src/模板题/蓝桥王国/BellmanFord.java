package 模板题.蓝桥王国;

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
    public static int[] prev;//记录节点前驱
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        dist=new int[m+1];
        prev=new int[m+1];
        for (int i = 0; i <m; i++) {
            int u = nextInt();
            int v = nextInt();
            int w = nextInt();
            edges.add(new int[]{u,v,w});
            edges.add(new int[]{v,u,w});
        }
        //初始化
        Arrays.fill(dist,Integer.MAX_VALUE>>1);
        Arrays.fill(prev,-1);
        int s=1;    //设置起点
        dist[s]=0;  //起点设置为0,其他设置为无穷大
        for (int i = 1; i <=n-1; i++) {//最多执行n-1次松弛
            for (int[] edge : edges) {  //枚举边
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if(dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    prev[v]=u;  //记录v的前驱为u
                }
            }
        }
        Arrays.stream(dist).skip(1).forEach(x->{// dist
            System.out.print(x+" ");
        });
        System.out.println();
        System.out.println(Arrays.toString(prev));//[-1,-1,1,2]

        //输出从起点出发到每个点的最短路径
        for (int i = 1; i <=n; i++) {
            print(s,i);
            System.out.println();
        }

    }
    //Bellmen-sord输出路径:倒着往回找路径，正着输出
    public static void print(int start,int end){
        if(start==end){
            System.out.print(start+" ");
            return;
        }
        print(start,prev[end]);//不断查找end的前驱，知道前驱节点为start
        System.out.print(end+" ");
    }
    public static int[] bellmanFord(int n,int s,int[][] edges){
        //dist[v]为s到v的最短距离
        int[] dist=new int[n];
        //pre[v]为v的前驱
        int[] prev=new int[n];

        for (int i = 0; i < n; i++) {
            dist[i]=Integer.MAX_VALUE>>1;
            prev[i]=-1;
        }
        dist[s]=0;

        for (int i = 0; i < n - 1; i++) {   //最多进行n-1次松弛操作
            for (int[] edge : edges) {  //枚举所有边
                int u = edge[0];
                int v= edge[1];
                int w = edge[2];
                //dist[v]=Math.min(dist[v],dist[u]+w)
                if(dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    prev[v]=u;
                }
            }
        }
        //检测是否存在负权回路
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(dist[u]+w<dist[v]){
                System.out.println("图中存在负权回路");
            }
        }
        return dist;
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
//3 3
//1 2 1
//1 3 5
//2 3 2

//0
//1
//3
