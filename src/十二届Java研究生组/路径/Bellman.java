package 十二届Java研究生组.路径;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bellman {
    public static List<int[]> edges=new ArrayList<>();
    public static int[] dist;//记录源点到终点的距离
    public static int[] prev;//记录当前节点的前驱
    public static final int n = 2021;
    public static int m=0;//计算有多少条边
    public static void main(String[] args) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(Math.abs(i-j)<=21){
                    m++;
                    edges.add(new int[]{i,j,gbs(i,j)});
                    edges.add(new int[]{j,i,gbs(i,j)});
                }
            }
        }
        dist=new int[m+1];
        prev=new int[m+1];
        Arrays.fill(dist,Integer.MAX_VALUE>>1);
        Arrays.fill(prev,-1);
        int s=1;//设置起点
        dist[s]=0;//起点的dist设置为0，其他未无穷大
        for(int i=1;i<=n-1;i++){//n-1次松弛操作
            for (int[] edge : edges) {
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];
                if(dist[v]>dist[u]+w){
                    dist[v]=dist[u]+w;
                    prev[v]=u;
                }
            }
        }
        System.out.println(dist[2021]);
    }
    public static int gbs(int a,int b) {
        return a*b/gcd(a,b);
    }
    public static int gcd(int a,int b) {
        if(b==0) {
            return a;
        }
        int min=Math.min(a,b);
        int max=Math.max(a,b);
        return gcd(min,max%min);
    }
}
