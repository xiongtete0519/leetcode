package 模拟题.跳跃.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
//深度优先遍历，我们对可扩展的方向进行DFS，每次找到(n,m)终点的时候更新最大权值
public class Main {
    //这里是往右下方向走，所以坐标都是正的
    public static int[][] dirs={
            {0,1},
            {0,2},
            {0,3},
            {1,0},
            {1,1},
            {1,2},
            {2,0},
            {2,1},
            {3,0}
    };
    public static int n;
    public static int m;
    public static int[][] a;
    public static int cnt=0;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        n = nextInt();
        m = nextInt();
        a = new int[n + 1][m + 1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m ; j++) {
                a[i][j]=nextInt();
            }
        }
        dfs(1,1,a[1][1]);
        System.out.println(cnt);

    }
    public static void dfs(int x,int y,int res){
        if(x==n&&y==m){ //到达终点之后，更新权值和
            cnt=Math.max(cnt,res);
            return;
        }
        //开始扩展
        for (int[] dir : dirs) {
            //(x,y)下一个位置的坐标(ex,ey)
            int ex = x + dir[0];
            int ey = y + dir[1];
            if(ex>=1&&ex<=n&&ey>=1&&ey<=m){ //判断是否越界
                dfs(ex,ey,res+a[ex][ey]);
            }
        }
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
}
