package LanQiaoBei.全排列的价值;

import java.util.Scanner;

public class Main1 {
    public static long[] f = new long[1000010];
    public static long[] g = new long[1000010];
    public static final int MOD=998244353;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        init(n);
        for (int i = 2; i <=n ; i++) {
            f[i]=(f[i-1]*i%MOD+(long)i*(i-1)/2%MOD*g[i-1]%MOD)%MOD;
        }
        System.out.println(f[n]);
    }
    //计算g数组中每个位置上的阶乘,也就是n全排列的数量
    public static void init(int n){
        long h=1;
        for (int i = 1; i <=n ; i++) {
            h=(h*i)%MOD;
            g[i]=h;
        }
    }

}
