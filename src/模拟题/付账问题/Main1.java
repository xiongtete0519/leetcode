package 模拟题.付账问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main1 {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n=nextInt();
        long s=nextLong();
        long[] a = new long[n];

        //每个人带的钱数
        for (int i = 0; i <n; i++) {
            a[i]=nextLong();
        }
        //开始贪心选择
        Arrays.sort(a);
        double avg=1.0*s/n;//平均值
        double sum=0;
        for (int i = 0; i <n; i++) {
            //当前的平均值
            double avg_cur = 1.0*s / (n - i);
            if(a[i]<avg_cur){   //需要将钱全部拿出的人
                sum+=(a[i]-avg)*(a[i]-avg);
                s-=a[i];
            }else{  //不需要全部拿出的人
                sum+=(avg_cur-avg)*(avg_cur-avg)*(n-i);
                break;
            }
        }
        //计算标准差
        System.out.printf("%.4f",Math.sqrt(sum/n));

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
