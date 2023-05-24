package 国赛刷题挑战.迷宫;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;
//根据样例可知：步数期望其实就是每个点走到(n,n)的最小步数的和，除以n*n
//每个点的传送门个数可能不止一个，用一个List去存
//从终点出发，跑一遍全图BFS找最短路
public class Main {
    static int N = 2010;
    static Map<Integer, List<int[]>> map=new HashMap<>();//记录传送门
    static boolean[][] vis=new boolean[N][N];//访问标记
    static int[][] dis=new int[N][N];   //存每个点到终点的最短步数
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int n;
    static int m;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        n=nextInt();
        m=nextInt();
        for (int i = 0; i <m; i++) {
            int x1=nextInt()-1;
            int y1=nextInt()-1;
            int x2=nextInt()-1;
            int y2=nextInt()-1;
            //双向传送门
            add(x1,y1,x2,y2);
            add(x2,y2,x1,y1);
        }
        //将终点入队列，从终点向各个点BFS
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n-1,n-1});
        vis[n-1][n-1]=true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            //走传送门
            if(map.containsKey(x*n+y)){
                List<int[]> list=map.get(x*n+y);
                for (int[] g : list) {
                    if(!vis[g[0]][g[1]]){
                        queue.offer(g);
                        dis[g[0]][g[1]]=dis[x][y]+1;
                        vis[g[0]][g[1]]=true;
                    }
                }
            }
            //上下左右
            for (int i = 0; i <4 ; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX>=0&&newX<n&&newY>=0&&newY<n&&!vis[newX][newY]){
                    queue.offer(new int[]{newX,newY});
                    dis[newX][newY]=dis[x][y]+1;
                    vis[newX][newY]=true;
                }
            }
        }
        //累加各个位置到终点的最小步数
        int ans=0;
        for (int x = 0; x <n ; x++) {
            for (int y = 0; y <n ; y++) {
                ans+=dis[x][y];
            }
        }
        System.out.printf("%.2f",ans*1.0/(n*n));
    }

    public static void add(int x1,int y1,int x2,int y2){
        if(!map.containsKey(x1*n+y1)){  //把二维的坐标映射到一维的数字上
            map.put(x1*n+y1,new ArrayList<>());
        }
        map.get(x1*n+y1).add(new int[]{x2,y2});
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long) st.nval;
    }
}
