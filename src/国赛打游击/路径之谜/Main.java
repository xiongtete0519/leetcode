package 国赛打游击.路径之谜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static int[] path;   //记录走位置对应的编号
    public static int n;    //n*n的矩阵
    public static int[] countLeft;//左边箭靶上的箭
    public static int[] countUp;//上边箭靶上的箭
    public static boolean[][] visited;  //访问标记
    public static boolean success=false; //走到终点的标记
    public static int[][] dirs = {
            {-1, 0},    //上
            {1, 0},     //下
            {0, -1},    //左
            {0,1}       //右
    };

    public static void main(String[] args) throws IOException{
        n=nextInt();  //n*n的矩阵
        countLeft=new int[n];
        countUp=new int[n];
        path=new int[n*n];
        visited=new boolean[n][n];
        for (int i = 0; i <n ; i++) {
            countLeft[i]=nextInt();
        }
        for (int i = 0; i <n ; i++) {
            countUp[i]=nextInt();
        }
        //从起点开始dfs
        dfs(0,0,0);
    }

    public static void dfs(int x,int y,int step){
        path[step]=y*n+x;   //将该点编号记录到路径中
        visited[x][y]=true; //访问标记
        countLeft[x]--; //拔掉当前行左边的箭
        countUp[y]--;   //拔掉当前列上边的箭
        if(x==n-1&&y==n-1&&check()){    //是否到达终点
            success=true;   //标记已经走到终点
            //输出答案
            for (int i = 0; i <=step ; i++) {
                System.out.print(path[i]+" ");
            }
            return;
        }
        for (int[] dir : dirs) {    //四个方向搜索
            int tmpX=x+dir[0];
            int tmpY=y+dir[1];
            //没有到达终点且不越界，且(tmpX,tmpY)没有被访问过
            if(!success&&tmpX>=0&&tmpX<=n-1&&tmpY>=0&&tmpY<=n-1&&!visited[tmpX][tmpY]){
                if(countLeft[tmpX]>0&&countUp[tmpY]>0){//左边和上边还有箭
                    dfs(tmpX,tmpY,step+1);//搜索下一步
                    visited[tmpX][tmpY]=false;  //复原，回溯
                    countLeft[tmpX]++;
                    countUp[tmpY]++;
                }
            }
        }
    }
    public static boolean check(){
        for (int i = 0; i < n; i++) {
            //到终点的时候箭还没有拔完
            if(countLeft[i]!=0||countUp[i]!=0){
                return false;
            }
        }
        //到终点时箭刚好拔完
        return true;
    }

    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
