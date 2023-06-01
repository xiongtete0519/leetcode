package 国赛复习.大胖子走迷宫;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static int[][] dirs={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };
    public static boolean[][] visited;  //访问标记
    public static char[][] map; //存储地图
    public static int n;    //n*n
    public static int k;
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        k = Integer.parseInt(arr[1]);
        map=new char[n][n];
        visited=new boolean[n][n];
        for (int i = 0; i <n ; i++) {
            map[i]=br.readLine().toCharArray();
        }
        bfs();
    }

    public static void bfs() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node(2,2,0));   //起点入队列
        visited[2][2]=true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.x==n-3&&now.y==n-3){//下标从0开始，所以这里是n-3
                System.out.println(now.t);
                return;
            }
            //原地踏步+上下左右五个方向搜索
            queue.offer(new Node(now.x,now.y,now.t+1));
            for (int[] dir : dirs) {
                int tx=now.x+dir[0];
                int ty=now.y+dir[1];
                //根据时刻决定身形大小
                int fat=(now.t>=2*k?0:(now.t>=k?1:2));
                //加上肥胖的身躯是否越界
                if(tx-fat<0||ty-fat<0||tx+fat>=n||ty+fat>=n){
                    continue;
                }
                //中心节点是墙壁或者已经被访问过
                if(map[tx][ty]=='*'||visited[tx][ty]){
                    continue;
                }
                //判断(tx,ty)这条路是否可以走：身子有没有碰到墙壁
                if(check(tx,ty,fat)){
                    visited[tx][ty]=true;
                    queue.offer(new Node(tx,ty,now.t+1));
                }
            }
        }
    }
    //检测身子是否碰到墙壁
    public static boolean check(int x,int y,int fat){
        for (int i = x-fat; i <=x+fat; i++) {
            for (int j = y-fat; j <=y+fat ; j++) {
                if(map[i][j]=='*'){
                    return false;
                }
            }
        }
        return true;
    }
}
class Node{
    int x;
    int y;
    int t;
    public Node(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}
