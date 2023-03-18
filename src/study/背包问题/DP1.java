package study.背包问题;


//0-1背包问题：一维DP
//本题条件是物品不能分割
import java.util.Arrays;

/**
 * 背包容量为8
 * 物品编号:1,2,3,4
 * 物品重量:2,3,4,5
 * 物品价值:3,4,5,8
 * DP[j]：表示容量为j的背包所能装物品的最大价值
 */
public class DP1 {
    //背包容量为8，4件物品
    public static void main(String[] args) {
        //这里下标从1开始
        int[] w={0,2,3,4,5};    //各物品的重量
        int[] v={0,3,4,5,8};    //各物品的价值
        int[] f=new int[9];
        for (int i = 1; i <5 ; i++) {
            for (int j = 8; j >=w[i]; j--) {
                f[j]=Math.max(f[j],f[j-w[i]]+v[i]);
            }
        }
        Arrays.stream(f).skip(1).forEach(x->{
            System.out.print(x+" ");
        });
    }
}
