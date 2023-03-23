package 蓝桥杯.重新排序.官方题解;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static  StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] a = new int[n + 1];   //原数组
        int[] b = new int[n + 2];   //差分数组
        int[] s = new int[n + 1];   //前缀和数组
        for (int i = 1; i <=n ; i++) {
            a[i]=nextInt();
        }
        int m =nextInt();
        for (int i = 0; i <m ; i++) {
            int left = nextInt();
            int right = nextInt();
            //差分数组实现区间加法更新
            b[left]++;
            b[right+1]--;
        }
        //对差分数组求前缀和，得到每个数字的查询次数
        for (int i = 1; i <=n; i++) {
            s[i]=s[i-1]+b[i];
        }
        long sum1=0;    //原始和
        long sum2=0;    //重新排列数组之后的和
        for (int i = 1; i <=n; i++){   //计算原始和
            sum1+=(long)a[i]*s[i];    //元素值*查询次数
        }
        Arrays.sort(a);
        Arrays.sort(s);
        //sum2为贪心后的最大和
        for (int i = 1; i <=n ; i++) {
            sum2+=(long)a[i]*s[i];
        }
        System.out.println(sum2-sum1);
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
}
