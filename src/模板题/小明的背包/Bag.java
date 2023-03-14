package 模板题.小明的背包;

import java.util.Scanner;
//5 20
//1 6
//2 5
//3 8
//5 15
//3 3
//小明的背包
public class Bag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); //物品数量
        int V = scan.nextInt(); //背包容量
        int[] w = new int[N + 1];//物品体积
        int[] v = new int[N + 1];//物品价值
        //记录最优解,我们的目标是f[N][V]
        int[][] f = new int[N + 1][V + 1];
        for (int i = 1; i <=N; i++) {
            w[i]=scan.nextInt();
            v[i]=scan.nextInt();
        }
        for (int i = 1; i <=N; i++) {   //i代表N件物品
            for (int j = 1; j <=V; j++) {   //j表示背包容量
                if(w[i]>j){ //太重，装不下
                    f[i][j]=f[i-1][j];
                }else{
                    //f[i][j]=max{不拿第i件，拿第i件}
                    f[i][j]=Math.max(f[i-1][j],f[i-1][j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(f[N][V]);
    }
}
