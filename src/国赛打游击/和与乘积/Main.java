package 国赛打游击.和与乘积;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
//20%
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long[] arr = new long[n + 1];
        long[] sum = new long[n + 1];   //前缀和数组
        long[] mult = new long[n + 1];  //前缀积数组
        Arrays.fill(mult,1);
        long res=0;//记录合法区间的个数
        for (int i = 1; i <=n ; i++) {
            arr[i]=nextLong();
            sum[i]=sum[i-1]+arr[i];
            mult[i]=mult[i-1]*arr[i];
        }
//        System.out.println(Arrays.toString(sum));
//        System.out.println(Arrays.toString(mult));

        for (int i = 1; i <=n; i++) {
            for (int j = i; j <=n ; j++) {
                //计算区间[i,j]的和与积是否相等
                long sum1 = sum[j] - sum[i - 1];
                long mult1 = mult[j] / mult[i - 1];
                if(sum1==mult1){
//                    System.out.println("i="+i+",j="+j);
                    res++;
                }
            }
        }
        System.out.println(res);
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
