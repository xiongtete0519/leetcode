package study.动态规划.BFS;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入行数");
        int n = scanner.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {  //将数字三角形放入二维数组
            for (int j = 0; j <= i; j++) {//控制第几行有几个数字
                array[i][j] = scanner.nextInt();
            }
        }
        //从下到上
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                //某个数字（i,j)的左下是（i+1,j),右下是（i+1,j+1)
                array[i - 1][j] += Math.max(array[i][j], array[i][j + 1]);
            }
        }
        System.out.println(array[0][0]);
    }
}
