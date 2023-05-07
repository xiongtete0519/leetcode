package 国赛打游击.背包问题2022;

/**
 * 将每个数字看作物品，物品的重量就是数字本身的大小，容积看成1
 * 最多选10个数字
 * 问题转化成容积为10，背包容量为2022的背包问题，问现在有多少种方案填满背包
 * 定义f[i][j]为只选择i个数，且总和为j的方案数。
 * 假设当前数为x,我们将当前数作为第i个数，总和为j的时候，那么方案数应该加上前面
 * i-1个数总和为j-x的方案数.
 * 于是得到转移方程:
 * f[j][k]+=f[j-1][k-i]
 *
 */
public class Main {

    public static void main(String[] args) {
        int m=10;
        int n=2022;
        long[][] dp=new long[m+1][n+1];

        dp[0][0]=1;
        for (int i = 1; i <=2022 ; i++) {   //枚举每个物品的体积
            for (int j = 10; j >=1; j--) {  //物品数量
                for (int k = 1; k <=2022; k++) {    //背包容量
                    if(k-i>=0){ //放得下就放
                        dp[j][k]+=dp[j-1][k-i];
                    }
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
