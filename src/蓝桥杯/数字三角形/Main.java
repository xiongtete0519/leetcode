package 蓝桥杯.数字三角形;

import java.util.Arrays;
import java.util.Scanner;
//数字三角形：动态规划
//由于向左下和右下的次数不超过1，则最后会达到最后一行得到中间位置
//如果是奇数行，达到最后一行的中间
//如果是偶数行，会到达最后行中间的两个数,
//输出结果的时候需要判断下是奇数行还是偶数行
//dp[i][j]表示从(1,1)走到(i,j)位置的最大和
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] a = new int[n + 1][n+1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                a[i][j]=scan.nextInt();
            }
        }
        //初始化dp数组
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }
        dp[1][1]=a[1][1];
        //根据状态转移方程计算状态值
        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                //max(从左上下来，从上边下来)+a[i][j]
                //左下和右下在输入数据的时候就变成了下和右下
                dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+a[i][j];
            }
        }
        //输出结果
//        Arrays.stream(dp).forEach(x->{
//            System.out.println(Arrays.toString(x) +" ");
//        });

        //判断计奇数行和偶数行的输出情况
            if(n%2==0){ //偶数行的时候取中间两个中较大的
                System.out.println(Math.max(dp[n][n/2],dp[n][n/2+1]));
        }else{  //奇数行是走中间
            System.out.println(dp[n][n/2+1]);
        }
        scan.close();
    }
}
