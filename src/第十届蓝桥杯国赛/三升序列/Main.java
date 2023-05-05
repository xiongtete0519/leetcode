package 第十届蓝桥杯国赛.三升序列;

import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int res;
    public static int[][] move={
            {1,0},  //下
            {1,-1}, //左下
            {1,1},  //右下
            {0,1},  //右
            {-1,1}  //右上
    };
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n=30;
        m=50;
        char[][] a = new char[n][m];
        for (int i = 0; i <n; i++) {
            a[i]=scan.nextLine().toCharArray();
        }
        scan.close();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m; j++) {
                dfs(a,i,j);
            }
        }
        System.out.println(res);
    }
    public static void dfs(char[][] a, int x,int y){
        char first=a[x][y];
        for (int i = 0; i <move.length ; i++) { //五个方向上搜索
            int tmpX=x+move[i][0];
            int tmpY=y+move[i][1];
            while(tmpX>=0&&tmpX<n&&tmpY>=0&&tmpY<m){
                if(a[tmpX][tmpY]>first){
                    char second=a[tmpX][tmpY];
                    int tempX=tmpX+move[i][0];
                    int tempY=tmpY+move[i][1];
                    while(tempX>=0&&tempX<n&&tempY>=0&&tempY<m){
                        if(a[tempX][tempY]>second){
                            res++;
                        }
                        //第三个点不满足条件，继续搜索
                        tempX+=move[i][0];
                        tempY+=move[i][1];
                    }
                }
                //第二个点不满足条件，继续搜索
                tmpX+=move[i][0];
                tmpY+=move[i][1];
            }
        }
    }
}
