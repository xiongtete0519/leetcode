package 模板题.走迷宫;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//BFS：广度优先搜索

/**
 * 输入：
 * 5 5
 * 1 0 1 1 0
 * 1 1 0 1 1
 * 0 1 0 1 1
 * 1 1 1 1 1
 * 1 0 0 0 1
 * 1 1 5 5
 * 输出：8
 * 将迷宫看成一个无向图，每个格子为一个节点，如果两个各自相邻且都是道路，则他们
 * 之间有一条边。将起始点加入队列，然后不断从队列中取出最先加入队列的节点，扩展它的
 * 邻居节点，再将这些邻居节点加入队列。这样，每次取出的节点都是到起点距离最远的节点，
 * 如果扩展到终点节点，则搜索结束，返回当前节点的距离
 *
 * 每次从队列中取出一个节点时，将它的所有邻居节点加入队列，同时更新这些邻居节点的距离
 * 和访问状态。如果扩展到终点节点，则搜索结束，返回当前节点的距离。如果队列为空仍未扩展
 * 到终点节点，则搜索失败，无法从起点到达终点。
 */
public class Main {
    //四个方向
    private static int[][] dirs={
            {0,1},//右
            {1,0},//下
            {0,-1},//左
            {-1,0}//上
    };
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] maze = new int[n + 1][m + 1];   //迷宫
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                maze[i][j]=scan.nextInt();
            }
        }
        //入口(startX,startY)和出口(endX,endY)位置
        int startX = scan.nextInt();
        int startY = scan.nextInt();
        int endX = scan.nextInt();
        int endY = scan.nextInt();
        //记录节点的距离
        int[][] dist = new int[n + 1][m + 1];
        //记录是否被访问过
        boolean[][] visited = new boolean[n + 1][m + 1];
        //存储要访问的节点
        Queue<int[]> queue =new LinkedList<>();
        //将起点加入到队列中
        queue.offer(new int[]{startX,startY});
        //将起点的visited值设置为true
        visited[startX][startY]=true;
        while(!queue.isEmpty()){    //BFS
            //取出队头节点
            int[] cur = queue.poll();
            //如果扩展到终点节点，则搜索结束，返回当前节点的距离
            if(cur[0]==endX&&cur[1]==endY){
                System.out.println(dist[cur[0]][cur[1]]);
                return;
            }
            //扩展当前节点的邻居节点
            for (int[] dir : dirs) {
                //计算邻居节点的坐标
                int nextX=cur[0]+dir[0];
                int nextY=cur[1]+dir[1];
                //检查邻居节点的坐标是否超出迷宫边界
                if(nextX<1||nextX>n||nextY<1||nextY>m){
                    continue;
                }
                //检查邻居节点是否是墙壁  0是墙壁，1是道路
                if(maze[nextX][nextY]==0){  //是墙壁就跳过该邻居节点
                    continue;
                }
                if(visited[nextX][nextY]){  //检查邻居节点是否已经被访问过
                    continue;
                }
                //标记该邻居节点已被访问
                visited[nextX][nextY]=true;
                //距离设置为当前节点的距离+1
                dist[nextX][nextY]=dist[cur[0]][cur[1]]+1;
                //将该邻居节点添加到队列中
                queue.offer(new int[]{nextX,nextY});
            }
        }
        //无法从起点到达终点
        System.out.println(-1);
    }
}
