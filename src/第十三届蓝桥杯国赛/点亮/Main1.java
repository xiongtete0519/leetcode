package 第十三届蓝桥杯国赛.点亮;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static int MAX_N=10;
    public static int[][] dir={   //方向
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
    };
    public static char[][] g=new char[MAX_N][MAX_N];    //原图
    public static char[][] ans=new char[MAX_N][MAX_N];  //答案图
    public static boolean[][] vis=new boolean[MAX_N][MAX_N];//白色格子是否完全被点亮
    public static List<int[]> black=new ArrayList<>();  //黑色格子坐标
    public static List<int[]> white=new ArrayList<>();  //白色格子坐标
    public static List<int[]> light=new ArrayList<>();  //灯泡坐标

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();//过滤换行
        //读入数据
        for (int i = 0; i <n; i++) {
            g[i]=in.nextLine().toCharArray();
            for (int j = 0; j <n ; j++) {
                if(g[i][j]=='.'){
                    white.add(new int[]{i,j});
                }else{
                    black.add(new int[]{i,j});
                }
            }
        }

        for(int o=0;o<(1<<white.size());++o){
            init(n);
            for (int i = 0; i <white.size(); i++) {
                //二进制0代表没有灯，1代表有灯
                if(((o>>i)&1)==1){
                    int[] p=white.get(i);
                    ans[p[0]][p[1]]='O';
                    light.add(p);
                    vis[p[0]][p[1]]=true;
                }
            }
            if(judgeBlack(n)&&judgeWhite(n)){
                break;
            }
        }
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }

    }

    public static void init(int n){
        light.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j]=g[i][j];//ans先赋值为原图
                vis[i][j]=false;    //初始时白色格子没有被点亮
            }
        }
    }

    public static boolean judgeBlack(int n){
        for (int[] p : black) {
            int cnt=0;
            int x=p[0];
            int y=p[1];
            for (int i = 0; i < 4; i++) {
                int tx=x+dir[i][0];
                int ty=y+dir[i][1];
                if(tx<0||tx>=n||ty<0||ty>=n){   //越界判断
                    continue;
                }
                if(ans[tx][ty]=='O'){   //判断上下左右灯的数量
                    cnt++;
                }
            }
            if(ans[x][y]!='x'&&cnt!=ans[x][y]-'0'){
                return false;
            }
        }
        return true;
    }

    public static boolean judgeWhite(int n){
        for (int[] p : light) {
            int x=p[0];
            int y=p[1];
            //上下左右枚举
            for(int tx=x-1;tx>=0;tx--){
                if(ans[tx][y]=='O'){    //碰到灯泡
                    return false;
                }else if(ans[tx][y]=='.'){  //碰到不是灯泡的白格
                    vis[tx][y]=true;
                }else{//黑色格子会隔断灯
                    break;
                }
            }

            for(int tx=x+1;tx<n;tx++){
                if(ans[tx][y]=='O'){    //
                    return false;
                }else if(ans[tx][y]=='.'){
                    vis[tx][y]=true;
                }else{
                    break;
                }
            }

            for(int ty=y-1;ty>=0;ty--){
                if(ans[x][ty]=='O'){
                    return false;
                }else if(ans[x][ty]=='.'){
                    vis[x][ty]=true;
                }else{
                    break;
                }
            }

            for(int ty=y+1;ty<n;ty++){
                if(ans[x][ty]=='O'){
                    return false;
                }else if(ans[x][ty]=='.'){
                    vis[x][ty]=true;
                }else{
                    break;
                }
            }
        }
        //判断每个白色格子是否都被点亮
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if(!vis[i][j]&&ans[i][j]=='.'){
                    return false;
                }
            }
        }
        return true;
    }

}
