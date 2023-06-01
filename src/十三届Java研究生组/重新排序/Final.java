package 十三届Java研究生组.重新排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

//Main2
public class Final {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long[] a = new long[n + 1];       //原始数组
        long[] c = new long[n + 2];       //差分数组
        long[] s = new long[n + 1];       //前缀和数组
        long originalSum=0;//记录原始的和
        long finalSum=0;    //记录最大化之后的和
        for (int i = 1; i <=n; i++) {
            a[i]=nextLong();
        }
        int m = nextInt();
        for (int i = 0; i <m ; i++) {//m次询问
            int left = nextInt();
            int right = nextInt();
            c[left]++;
            c[right+1]--;
        }
        //对此刻的差分数组求前缀和统计出每个元素被加的次数
        for (int i = 1; i <=n ; i++) {
            s[i]=s[i-1]+c[i];
        }
        //记录原始的和
        for (int i = 1; i <=n; i++) {
            originalSum+=a[i]*s[i];
        }
        Arrays.sort(a,1,n+1);
        Arrays.sort(s,1,n+1);
        //记录重新排序之后的最大和
        for (int i = 1; i <=n; i++) {
            finalSum+=a[i]*s[i];
        }
        System.out.println(finalSum-originalSum);
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }

}
