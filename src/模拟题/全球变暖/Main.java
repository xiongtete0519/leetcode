package 模拟题.全球变暖;

import java.io.*;
import java.util.LinkedList;

/**
 * 方案一：BFS
 * 统计不会被淹没的岛屿个数
 * 每次搜索的时候，判断是否存在上下左右都是陆地，若是，则这个岛屿不会被淹没
 *
 * 最后被淹没的岛屿数量=岛屿总数-不会被淹没的岛屿个数
 *
 * 开始的时候找到一个陆地并且没有访问过的时候就将岛屿总数+1,然后BFS，
 * 因为BFS会将其周围的点设置为已经访问，一次BFS会将一个岛屿的节点都扩展完毕
 * 注意：这里被海洋覆盖之后，不会被淹没的岛屿数量可能会增加。
 */
public class Main {
    public static long sum;//总岛屿数量
    public static long ans;//不会被淹没的岛屿数量
    public static boolean sign=false;//不会被淹没的岛屿标记
    public static char[][] map;//标记数据是海洋还是陆地
    public static boolean[][] visited;//标记是否已经访问过
    public static int n;
    //定义方向
    public static int[][] dirs={
            {0,1},  //右
            {1,0},  //下
            {0,-1}, //左
            {-1,0}  //上
    };
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(in.readLine());
        map = new char[n][n];
        visited=new boolean[n][n];
        for (int i = 0; i <n ; i++) {
            map[i]=in.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //该点是陆地且没有被访问过
                if(map[i][j]=='#'&&!visited[i][j]){ //其实是在搜索岛屿
                    sum++;  //计算岛屿总数
                    sign=false;
                    bfs(i,j);
                    if(sign){
                        ans++;  //统计不会被淹没的岛屿数量
                    }
                }
            }
        }
        //会被淹没的岛屿数量=总岛屿数量-不会被淹没的岛屿数量
        ans=sum-ans;
        out.print(ans);
        in.close();
        out.flush();
        out.close();
    }
    public static void bfs(int x,int y){
        LinkedList<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        visited[x][y]=true;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(check(point.x,point.y)){
               sign=true;  //不会被淹没
            }
            for (int[] dir : dirs) {
                int tx = point.x + dir[0];
                int ty = point.y + dir[1];
                if(tx<0||tx>n-1||ty<0||ty>n-1){//判断是否越界
                    continue;
                }
                if(map[tx][ty]=='.'||visited[tx][ty]){//如果是海洋或者已经访问过了
                    continue;
                }
                visited[tx][ty]=true;
                queue.offer(new Point(tx,ty));
            }
        }
    }
    //校验岛屿是否不会被淹没：只有和海洋乡里你的都会被淹没
    //true:不会被淹没  false:会被淹没
    public static boolean check(int x,int y){
        for (int[] dir : dirs) {
            int tx = x + dir[0];
            int ty = y + dir[1];
            if(tx<0||tx>n-1||ty<0||ty>n-1){
                continue;
            }
            if(map[tx][ty]=='.'){
                return false;
            }
        }
        return true;
    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
//10
//..........
//.....##...
//......#...
//..........
//.....##...
//......###.
//......###.
//......###.
//..#....##.
//..........

//2