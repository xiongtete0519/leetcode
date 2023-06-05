package 国赛复习.部分省赛复习.走迷宫;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;

public class Main {
    public static int[][] dirs={
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
    };
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        int m=nextInt();
        int[][] a=new int[n+1][m+1];//迷宫
        boolean[][] visited=new boolean[n+1][m+1];
        LinkedList<Point> queue = new LinkedList<>();
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ; j++) {
                a[i][j]=nextInt();
            }
        }
        //起点和终点的坐标
        int startX=nextInt();
        int startY=nextInt();
        int endX=nextInt();
        int endY=nextInt();
        //标记是否找到中终点
        boolean flag=false;
        Point start = new Point(startX, startY, 0);
        //起点入队
        queue.add(start);
        visited[startX][startY]=true;   //标记起点已经被访问
        while(!queue.isEmpty()){
            //队首元素出队
            Point point = queue.remove();
            int x=point.x;
            int y=point.y;
            if(x==endX&&y==endY){
                System.out.println(point.step);//直接输出step
                flag=true;
                break;
            }
            //四个方向的扩展
            for (int[] dir : dirs) {
                int tx=x+dir[0];
                int ty=y+dir[1];
                //检查扩展节点是否超出边界
                if(tx<1||tx>n||ty<1||ty>m){
                    continue;
                }
                //检查扩展节点是否是墙壁||被访问过
                if(a[tx][ty]==2||visited[tx][ty]) {
                    continue;
                }
                if(a[tx][ty]==1&&!visited[tx][ty]){
                    queue.add(new Point(tx,ty,point.step+1));
                    visited[tx][ty]=true;
                }
            }
        }
        if(!flag){   //没找到终点
            System.out.println(-1);
        }
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }

}
class Point{
    int x;
    int y;
    int step;

    public Point(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
