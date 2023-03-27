package 十二届Java研究生组.路径;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 2021;
        long[][] dist = new long[n + 1][n + 1];

        for (int i = 1; i <=n; i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i]=0;
        }

        //初始化距离
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
               if (Math.abs(i - j) <= 21) {
                    dist[i][j]=dist[j][i]=lcm(i,j);
                }
            }
        }
        //Floyd算法求解最短路径
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(dist[i][j]>dist[i][k]+dist[k][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        System.out.println(dist[1][2021]);
    }

    //最大公约数
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            return gcd(min, max % min);
        }
    }

    //最小公倍数，由于a*b=最大公约数*最小公倍数
    public static int lcm(int a, int b) {
        //先求最小公倍数
        return a * b / gcd(a, b);
    }
}
