package 模拟题.数组切分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * 区间内是连续自然数的意思是：
 * 区间最大值-区间最小值=区间长度
 * max-min=j-i
 * dp[i]:只考虑前i个数能切分的情况数
 */
public class Main {
    public static final int MOD=1000000007;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <=n ; i++) {
            a[i]=nextInt();
        }
        dp[0]=1;
        for (int i = 1; i <=n ; i++) {
            int max=a[i];
            int min=a[i];
            for (int j = i; j >0; j--) {//从后往前求dp
                max=Math.max(max,a[j]);
                min=Math.min(min,a[j]);
                if(max-min==i-j){   //符合要求：最大值-最小值=区间长度
                    dp[i]=(dp[i]+dp[j-1])%MOD;
                }
            }
        }
        System.out.println(dp[n]);
//        System.out.println(Arrays.toString(dp));
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
