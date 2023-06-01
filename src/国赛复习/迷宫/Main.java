package 国赛复习.迷宫;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static boolean[][] visited;//访问标记
    public static int[][] dis;//存储每个点到终点得最短步数
    public static Map<Integer, List<int[]>> map = new HashMap<>();  //传送门(键是将二维坐标转为一维的数值x*n+y)
    public static int[][] dirs=new int[][]{
            {-1,0}, //上
            {1,0},  //下
            {0,-1}, //左
            {0,1}   //右
    };
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        n=nextInt();
        m=nextInt();
        visited=new boolean[n+1][n+1];
        dis=new int[n+1][n+1];
        for (int i = 0; i <m; i++) {
            int x1=nextInt();
            int y1=nextInt();
            int x2=nextInt();
            int y2=nextInt();
            //双向传送门
            add(x1,y1,x2,y2);
            add(x2,y2,x1,y1);
        }
        //从终点向各个点BFS，找出每个点到终点的最短步数
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n,n});
        visited[n][n]=true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x=curr[0];
            int y=curr[1];
            //是否可以走传送门
            if(map.containsKey(x*n+y)){
                //可以走的传送门列表
                List<int[]> list = map.get(x * n + y);
                //传送门可能不止一个 (g[0],g[1])是可以传送的点
                for (int[] g : list) {
                    if(!visited[g[0]][g[1]]){
                        queue.offer(g);
                        dis[g[0]][g[1]]=dis[x][y]+1;
                        visited[g[0]][g[1]]=true;
                    }
                }
            }
            //上下左右
            for (int[] dir : dirs) {
                int newX=x+dir[0];
                int newY=y+dir[1];
                if(newX>=1&&newX<=n&&newY>=1&&newY<=n&&!visited[newX][newY]){
                    queue.offer(new int[]{newX,newY});
                    dis[newX][newY]=dis[x][y]+1;
                    visited[newX][newY]=true;
                }
            }
        }
        //累加各个位置到终点的最小步数
        long ans=0;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                ans+=dis[i][j];
            }
        }
        System.out.printf("%.2f",ans*1.0/(n*n));
    }
    public static void add(int x1,int y1,int x2,int y2){
        if(!map.containsKey(x1*n+y1)){
            map.put(x1*n+y1,new ArrayList<>());
        }
        map.get(x1*n+y1).add(new int[]{x2,y2});
    }

    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
