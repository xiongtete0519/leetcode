package 国赛复习.蓝桥王国;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 对边进行枚举
 * 设s为起点，dist[v]:s到v的最短距离
 */
public class BellmanFord {
    public static List<int[]> edges=new ArrayList<>();
    public static int[] dist;//
    public static int[] prev;//记录节点前驱，方便最后输出路径
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();    //n个点
        int m=nextInt();    //m条边
        dist=new int[m+1];
        prev=new int[m+1];
        for (int i = 0; i <m ; i++) {
            int u=nextInt();
            int v=nextInt();
            int w=nextInt();
            //无向图
            edges.add(new int[]{u,v,w});
            edges.add(new int[]{v,u,w});
        }
        Arrays.fill(dist,Integer.MAX_VALUE>>1);
        Arrays.fill(prev,-1);
        int s=1;//设置起点
        dist[s]=0;  //起点的dist设置为0，其他设置为无穷大
        for (int i = 0; i <=n-1; i++) { //最多执行n-1次松弛操作
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if(dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    prev[v]=u;  //记录v的前驱为u
                }
            }
        }
        Arrays.stream(dist).skip(1).forEach(x->{
            System.out.print(x+" ");
        });
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
