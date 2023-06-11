package 国赛刷题挑战.寻找黄金宝藏;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException{
        int n = nextInt();
        int k = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        int l = 1, r = 1000000000;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check(a, k, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(l);
    }

    private static boolean check(int[] a, int k, int mid) {
        int n = a.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (a[i - 1] >= mid ? 1 : -1);
        }
        int min = 0;
        for (int i = k; i <= n; i++) {
            if (sum[i] - min >= 0) {
                return true;
            }
            min = Math.min(min, sum[i - k + 1]);
        }
        return false;
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }
}
