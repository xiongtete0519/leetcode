package study.背包问题;


//0-1背包问题：二维DP
//本题条件是物品不能分割
//dp[k][w]:表示当背包容量为w,现在有前k件物品可放的情况下，背包所能装物品的最大价值

/**
 * 背包容量为8
 * 物品编号:1,2,3,4
 * 物品重量:2,3,4,5
 * 物品价值:3,4,5,8
 */
public class DP2 {
    //背包容量为8，4件物品
    public static void main(String[] args) {
        //这里下标从1开始
        int[] w={0,2,3,4,5};    //各物品的重量
        int[] v={0,3,4,5,8};    //各物品的价值
        int[][] f=new int[5][9];    //表示最优解 ，我们的目的是f[4][8]
        for (int i = 1; i <5 ; i++) {   //i代表四件物品
            for (int j = 1; j <9; j++) {   //j 表示背包容量
                if(w[i]>j){//装不下：第i件物品重量>背包容量
                    f[i][j]=f[i-1][j];
                }else{
                    //max{不拿第i件物品，拿第i件物品}
                  f[i][j]=Math.max(f[i-1][j],f[i-1][j-w[i]]+v[i]);
                }
            }
        }
        for (int[] ints : f) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println("-----最优方案-----");
        print(f,4,8,w);

    }
    public static void print(int[][] dp, int i, int j,int[] w){
        if(i==0){
            return;
        }
        if(dp[i][j]==dp[i-1][j]){
            print(dp,i-1,j,w);
        }else{
            print(dp,i-1,j-w[i],w);
            System.out.println(i+" ");
        }
    }
}
