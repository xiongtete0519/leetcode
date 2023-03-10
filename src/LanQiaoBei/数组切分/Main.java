package LanQiaoBei.数组切分;

import java.util.Scanner;

/*
方法：DP
技巧：如何判断区间[i,j]是否可以组成一段连续的自然数？
    只需区间最大值 - 区间最小值 == j - i (区间长度)即可

思路：这里设两层循环，一层i表示左端点，第二层j表示右端点。
    因为是连续的所以在所取的[l，r]范围中寻找最大值，最小值。
    然后相减，最后和r-l（区间长度）作比较即可。
 */
public class Main {
    public static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
        }
        //dp[i]:以arr[i]结尾的切分合法数组的方法数量
        int[] dp = new int[n + 1];
        dp[0] = 1;    //初始化
        for (int i = 1; i <= n; i++) {
            int max = arr[i];
            int min = arr[i];
            for (int j = i; j > 0; j--) {   //从后往前求dp[i]
                max = Math.max(max, arr[j]);    //维护最大值
                min = Math.min(min, arr[j]);    //维护最小值
                if (max - min == i - j) {   //符合要求：最大值-最小值=区间长度
                    dp[i] = (dp[i] + dp[j - 1]) % mod;
                }
            }
        }
        System.out.println(dp[n]);
    }
}
