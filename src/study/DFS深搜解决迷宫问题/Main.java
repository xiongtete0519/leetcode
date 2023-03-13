package study.DFS深搜解决迷宫问题;

import java.util.Scanner;

/**
 * 5 4
 * 1 1 2 1
 * 1 1 1 1
 * 1 1 2 1
 * 1 2 1 1
 * 1 1 1 2
 * 1 1 4 3
 */
public class Main {
    public static int endX;
    public static int endY;
    public static int min=Integer.MAX_VALUE; //最小路径长度
    //迷宫：1表示空地，2表示障碍物
//    public static int[][] a=new int[100][100];
    public static int[][] a;
    //false表示未访问，true表示访问
//    public static boolean[][] visited=new boolean[100][100];
    public static boolean[][] visited;
    //定义四个方向
    public static int[][] dirs={
            {0,1},//右
            {1,0},//下
            {0,-1},//左
            {-1,0}//上
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //n行m列
        int n = scan.nextInt();
        int m = scan.nextInt();
        a=new int[n+1][m+1];
        visited=new boolean[n+1][m+1];
        //初始化迷宫
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                a[i][j]=scan.nextInt();//1表示空地，2表示障碍物
            }
        }
        //起点和终点坐标
        int startX = scan.nextInt();
        int startY = scan.nextInt();
         endX = scan.nextInt();
         endY = scan.nextInt();
        //从起点开始深度优先搜素，所以先将起点设置为已访问
        visited[startX][startY]=true;
//        dfs(startX,startY,0);
        dfs1(startX,startY,0);
        System.out.println(min);

    }

    /**
     * @param x 当前点的x坐标
     * @param y 当前点的y坐标
     * @param step 经过的步数
     */
//    public static void dfs(int x,int y,int step){
//        if(x==endX&&y==endY){   //判断是否走到终点
//            if(step<min){   //如果比最短路径小，更新最短路径
//                min=step;
//            }
//            return; //回溯
//        }
//        //顺时针试探：右、下、左、上
//        //右
//        if(a[x][y+1]==1&& !visited[x][y + 1]){  //是道路且没有被访问过
//            visited[x][y+1]=true;   //将右边的点设置为已访问
//            dfs(x,y+1,step+1);//继续从右边这个点进行深度优先搜索
//            //当上一步dfs执行完，回退的时候需要将这个点设置为未访问
//            visited[x][y+1]=false;
//        }
//        //下
//        if(a[x+1][y]==1&& !visited[x + 1][y]){
//            visited[x+1][y]=true;   //将下边的点设置为已访问
//            dfs(x+1,y,step+1);//继续从下边这个点进行深度优先搜索
//            //当上一步dfs执行完，回退的时候需要将这个点设置为未访问
//            visited[x+1][y]=false;
//        }
//        //左
//        if(a[x][y-1]==1&& !visited[x][y - 1]){
//            visited[x][y-1]=true;   //将左边的点设置为已访问
//            dfs(x,y-1,step+1);//继续从左边这个点进行深度优先搜索
//            //当上一步dfs执行完，回退的时候需要将这个点设置为未访问
//            visited[x][y-1]=false;
//        }
//        //上
//        if(a[x-1][y]==1&& !visited[x-1][y]){
//            visited[x-1][y]=true;   //将上边的点设置为已访问
//            dfs(x-1,y,step+1);//继续从上边这个点进行深度优先搜索
//            //当上一步dfs执行完，回退的时候需要将这个点设置为未访问
//            visited[x-1][y]=false;
//        }
//        return;//回退
//    }
   //优化版本
    public static void dfs1(int x,int y,int step){
        if(x==endX&&y==endY){   //判断是否走到终点
            if(step<min){   //如果比最短路径小，更新最短路径
                min=step;
            }
            return; //回溯
        }
        //顺时针试探：右、下、左、上
        for (int[] dir : dirs) {
            //计算出下一个试探位置
            int tx=x+dir[0];
            int ty=y+dir[1];

            //判断是否超出边界
            if(tx<1||tx>a.length-1||ty<1||ty>a[0].length-1){
                continue;
            }
            //判断是否是墙
            if(a[tx][ty]==2){
                continue;
            }
            //如果试探位置未被访问，且是空地
            if(a[tx][ty]==1&& !visited[tx][ty]){
                visited[tx][ty]=true;//设置已访问
                dfs1(tx,ty,step+1);
                visited[tx][ty]=false;
            }
        }
        return;//回退
    }

}
