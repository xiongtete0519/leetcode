package LanQiaoBei.统计子矩阵;

import java.util.Arrays;
import java.util.Scanner;

//统计子矩阵：前缀和+滑动窗口
public class Final {
    public static int[][] a;
    public static int[][] s;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        long count=0;
        a = new int[n + 1][m + 1];
        s = new int[n + 1][m + 1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                a[i][j]=scan.nextInt();
            }
        }
        //计算二维数组前缀和
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m; j++) {
                s[i][j]=s[i][j-1]+s[i-1][j]-s[i-1][j-1]+a[i][j];
            }
        }
//        Arrays.stream(s).forEach(x->{
//            System.out.println(Arrays.toString(x));
//        });
        //开始统计符合条件的子矩阵个数
        //前两重循环确定左上角坐标，后两重循环确定右下角坐标
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                for (int l = i; l <=n ; l++) {
                    for (int o = j; o <=m ; o++) {
                        if(sumMatrix(i,j,l,o)<=k){
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);

    }
    //根据左上角坐标和右下角坐标求子矩阵的和
    public static int sumMatrix(int x1,int y1,int x2,int y2){
        return s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1];
    }
}
