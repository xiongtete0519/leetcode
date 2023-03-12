package study.BFS广搜解决迷宫问题;


import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * 5 4
 * 1 1 2 1
 * 1 1 1 1
 * 1 1 2 1
 * 1 2 1 1
 * 1 1 1 2
 * 1 1 4 3
 */
public class Main {
    //定义四个方向
    static int[][] dirs={
            {0,1},//右
            {1,0},//下
            {0,-1},//左
            {-1,0}//上
    };

    public static void main(String[] args) {
        //输入
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] a=new int[n+1][m+1];    //迷宫
        boolean[][] visited=new boolean[n+1][m+1];  //记录访问状态
        LinkedList<Point> queue=new LinkedList<>();//申请队列
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                a[i][j]=scan.nextInt();
            }
        }
        //起点和终点坐标
        int startX = scan.nextInt();
        int startY = scan.nextInt();
        int endX = scan.nextInt();
        int endY = scan.nextInt();
        boolean flag=false;//标记是否找到终点

        //BFS
        Point start = new Point(startX, startY, 0);
        //起点入队
        queue.add(start);
        visited[startX][startY]=true;//设置起点已经被访问

        while(!queue.isEmpty()){
            //队首元素出队
            Point point = queue.remove();
            int x = point.x;
            int y = point.y;
            if(x==endX&&y==endY){   //找到终点
                System.out.println(point.step);//直接输出step
                flag=true;//标记找到终点
                break;
            }
            //进行四个方向的扩展
            for (int[] dir : dirs) {
                int tx = x + dir[0];    //扩展点x坐标
                int ty = y + dir[1];    //扩展点y坐标
                //检查扩展节点坐标是否超出边界
                if(tx<1||tx>n||ty<1||ty>m){
                    continue;
                }
                //检查扩展节点是否是墙壁
                if(a[tx][ty]==2){   //是墙壁就跳过该节点
                    continue;
                }
                //检查扩展节点是否已经被访问过
                if(visited[tx][ty]){
                    continue;
                }
                if(a[tx][ty]==1&& !visited[tx][ty]){//如果是空地且未访问，则入队
                    queue.add(new Point(tx,ty,point.step+1));//步数为队首步数+1
                    visited[tx][ty]=true; //设置这个入队的点已经访问
                }
            }
        }
        //没找到终点
       if(!flag){
           System.out.println("没找到终点");
       }
    }
}
class Point{
     int x;
     int y;
     int step; //步数

    public Point(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
