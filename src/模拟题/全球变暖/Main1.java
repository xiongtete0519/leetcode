package 模拟题.全球变暖;

import java.io.*;

/**
 * 方案一：DFS
 * 一共有多少座岛屿：dfs搜索岛屿
 * 搜索的过程中统计不会被淹没的岛屿数量，最后用岛屿总数-不会被淹的岛屿数量
 * 就得到了被淹没的岛屿总数
 */
public class Main1 {
    public static boolean sign=false;//标记该岛屿是否不被淹没
    public static long num=0;//岛屿数
    public static long ans=0;//被淹没的岛屿数量
    public static char[][] map;//标记数据是海洋还是陆地
    public static boolean[][] visited;//标记是否已经访问过
    public static int n;    //地图边长
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
                if(map[i][j]=='#'&&!visited[i][j]){
                    sign=false;
                    dfs(i,j,num);
                    if(sign){
                        ans++; //统计不会被淹没的岛屿数量
                    }
                    num++;  //统计岛屿总数
                }
            }
        }
        //被淹的数量=岛屿总数-不会被淹的岛屿数量
        out.println(num-ans);
        in.close();
        out.flush();
        out.close();
    }
    public static void dfs(int x,int y,long num){
        if(x<0||x>n-1||y<0||y>n-1){
            return;
        }
        if(map[x][y]=='.'||visited[x][y]){
            return;
        }
        if(check(x,y)){//该岛屿是否不会被淹没
            sign=true;
        }
        //设置为已访问
        visited[x][y]=true;
        //四个方向扩展
        for (int[] dir : dirs) {
            int tx = x + dir[0];
            int ty = y + dir[1];
            dfs(tx,ty,num);
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