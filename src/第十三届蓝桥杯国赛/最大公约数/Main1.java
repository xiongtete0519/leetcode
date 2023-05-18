package 第十三届蓝桥杯国赛.最大公约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
//75%
public class Main1 {
    public static int MAX_N = 1000010;
    public static int[] a = new int[MAX_N];
    public static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int tmp = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();
            if (a[i] == 1) {
                tmp++;  //统计1的个数
            }
        }
        if (tmp > 0) {  //有1可以直接返回结果
            System.out.println(n - tmp);
            return;
        }
        tmp = n;
        //判断是否无解
        int ans = a[1];
        for (int i = 2; i <= n; i++) { //判断区间所有数字的gcd是否为1
            ans = gcd(ans, a[i]);
        }
        if (ans != 1) { //无解
            System.out.println(-1);
            return;
        }
        for (int i = 1; i <= n; i++) {   //枚举左端点
            int d = a[i];
            for (int j = i + 1; j <= n; j++) {//枚举右端点
                d = gcd(d, a[j]);
                if (d == 1) {
                    //区间长度为j-i+1,但是我们将所有数字变成1的操作次数是j-i，这段区间的最后一个数字就是1
                    tmp = Math.min(tmp, j - i);
                    break;
                }
            }
        }
        //需要tmp次操作才能gcd出一个1，剩下的n-1个数再进行n-1次gcd即可
        System.out.println(n - 1 + tmp);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return gcd(min, max % min);
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
