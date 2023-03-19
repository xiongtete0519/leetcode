package LanQiaoBei.染色时间;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;

/**
 * 这里下标从1开始
 * 从(1,1)处开始染色，它的上下左右四个方向所使用的染色时间为：自身染色时间+(1,1)处的染色时间
 * (1,1)染色后的分布情况如下:
 * 0 3 3
 * 4 5 6
 * 由于案例中(1,2)比(2,1)处染色时间快，所以当(1,2)处染色完成之后的分布如下:
 * 0 0 6
 * 4 8 6
 * 所以，我们可以依次将染色的点加入队列中，每次取出耗时最短的点，然后将其上下左右四个位置
 * 加上自身染色所需的时间即可。可以使用优先级队列实现
 */
public class Main1 {
    public static int[][] dirs={
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
    };
    public static void main(String[] args) throws IOException {
        //使用java快读
        StreamTokenizer scan = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        scan.nextToken();
        int n = (int) scan.nval;
        scan.nextToken();
        int m = (int) scan.nval;
        int[][] a = new int[n + 1][m + 1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                scan.nextToken();
                a[i][j]=(int)scan.nval;
            }
        }
        //使用优先级队列，每次耗时最短的节点先出队，最后出队的就是耗时最久的。
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1,1,a[1][1]));//初始将第一个节点入队
        a[1][1]=0;  //代表这个位置已经染色过了
        int count=0;
        while(!queue.isEmpty()){    //当队列不为空时
            Node node = queue.poll();   //队首元素出队
            //将node四个方向的节点入队，并修改为0，标记自己已经染色
            for (int[] dir : dirs) {
                int x = node.x + dir[0];
                int y = node.y + dir[1];
                if(x>=1&&x<=n&&y>=1&&y<=m&&a[x][y]!=0){
                    queue.offer(new Node(x,y,a[x][y]+node.time));
                    //标记这个位置已经被访问过了
                    a[x][y]=0;
                }
            }
            //该位置已经染色
            a[node.x][node.y]=0;
            count=node.time;
        }
        System.out.println(count);
    }
}

