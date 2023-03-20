package LanQiaoBei.重新排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
//差分+前缀和+贪心思想：100%
public class Main1 {
    public static long sum=0;
    public static long result=0;
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        long[] a = new long[n+1];
        long[] pre = new long[n+1];   //前缀和数组
        long[] g = new long[n+2]; //差分数组
        for (int i = 1; i <=n ; i++) {
            st.nextToken();
            a[i]=(long)st.nval;
            pre[i]=pre[i-1]+a[i];//求前缀和
        }
        st.nextToken();
        long m = (long) st.nval;
        //m次查询
        for (int i = 0; i <m ; i++) {
            st.nextToken();
            int left = (int) st.nval;
            st.nextToken();
            int right = (int) st.nval;
            sum+=pre[right]-pre[left-1];    //统计排序之前的sum
            g[left]+=1;         //差分思想
            g[right+1]-=1;
        }
        for (int i = 1; i <=n ; i++) {
            g[i]+=g[i-1];   //对差分数组求前缀和，统计每个元素被加过的次数
        }
        Arrays.sort(a);
        Arrays.sort(g);
        for (int i = n; i >=1 ; i--) {
            if(g[i+1]>=1){
                result+=a[i]*g[i+1];
            }
        }
        System.out.println(result-sum);
    }
}
