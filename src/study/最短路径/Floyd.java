package study.最短路径;

import java.util.Arrays;
import java.util.Scanner;

//Floyd算法求最短路径
public class Floyd {
    public static int[][] a=new int[101][3];
    public static double[][] f=new double[101][101];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //n个点，m条边
        int n = scan.nextInt();
        for (int i = 1; i <=n; i++) {
            a[i][1]=scan.nextInt();
            a[i][2]=scan.nextInt();
        }
        int m = scan.nextInt();
        for (int i = 0; i <f.length ; i++) {    //初始化f数组为最大值
            Arrays.fill(f[i],Double.MAX_VALUE);
        }
        for (int i = 1; i <=m ; i++) {  //预处理出x、y的距离
            int x = scan.nextInt();
            int y = scan.nextInt();
            //两点距离公式((x1-x2)^2+(y1-y2)^2)^(1/2)
            //由于是无向图，x->y和y->x的距离是一样的
            f[y][x]=f[x][y]=Math.sqrt(Math.pow((double)a[x][1]-a[y][1],2)+Math.pow((double)a[x][2]-a[y][2],2));
        }
        int s = scan.nextInt();
        int e = scan.nextInt();
        for (int k = 1; k <=n ; k++) {
            for (int i = 1; i <=n ; i++) {
                for (int j = 1; j <=n; j++) {
                    if(f[i][j]>f[i][k]+f[k][j]){
                        f[i][j]=f[i][k]+f[k][j];
                    }
                }
            }
        }
        System.out.printf("%.2f\n",f[s][e]);
    }
}
