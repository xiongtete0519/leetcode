package 国赛打游击.和与乘积;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.Arrays;
//30%
public class Main1 {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long[] arr = new long[n + 1];
        BigInteger[] sum = new BigInteger[n + 1];   //前缀和数组
        BigInteger[] mult = new BigInteger[n + 1];  //前缀积数组
        Arrays.fill(sum,BigInteger.ZERO);
        Arrays.fill(mult,BigInteger.ONE);
        long res=0;//记录合法区间的个数
        for (int i = 1; i <=n ; i++) {
            arr[i]=nextLong();
            //sum[i]=sum[i-1]+arr[i];
            BigInteger val = new BigInteger(String.valueOf(arr[i]));
            sum[i]=sum[i-1].add(val);
//            mult[i]=mult[i-1]*arr[i];
            mult[i]=mult[i-1].multiply(val);
        }


        for (int i = 1; i <=n; i++) {
            for (int j = i; j <=n ; j++) {
                //计算区间[i,j]的和与积是否相等
                BigInteger sum1 = sum[j].subtract(sum[i - 1]);
//                long sum1 = sum[j] - sum[i - 1];
//                long mult1 = mult[j] / mult[i - 1];
                BigInteger mult1 = mult[j].divide(mult[i - 1]);
                if(sum1.compareTo(mult1)==0){
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
