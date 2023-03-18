package 模板题.小明的背包2;


import java.util.Arrays;
import java.util.Scanner;
//一维DP
public class DP1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); //物品数量
        int V = scan.nextInt(); //背包容量
        int[] w = new int[N + 1];   //物品重量
        int[] v = new int[N + 1];   //物品价值
        int[] dp = new int[V + 1];
        for (int i = 1; i <=N ; i++) {
            w[i]=scan.nextInt();
            v[i]=scan.nextInt();
        }
        for (int i = 1; i <=N ; i++) {  //先遍历物品
            for (int j = w[i]; j <=V; j++) {    //再遍历背包
                dp[j]=Math.max(dp[j],dp[j-w[i]]+v[i]);
            }
        }
        System.out.println(dp[V]);
        Arrays.stream(dp).forEach(x->{
            System.out.print(x+" ");
        });
        scan.close();
    }
}
