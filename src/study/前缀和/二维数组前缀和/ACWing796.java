package study.前缀和.二维数组前缀和;

import java.util.ArrayList;
import java.util.Scanner;
//二维数组的前缀和
public class ACWing796 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int q = scan.nextInt();
        int[][] arr = new int[n + 1][m + 1];
        int[][] s = new int[n + 1][m + 1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                arr[i][j]=scan.nextInt();
            }
        }
        //计算前缀和
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                //s[i,j]表示
                s[i][j]=s[i-1][j]+s[i][j-1]-s[i-1][j-1]+arr[i][j];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <q ; i++) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            //求(x1,y1)~(x2,y2)子矩阵的和
            int sum = s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1];
            list.add(sum);
        }
        list.forEach(System.out::println);


    }
}
