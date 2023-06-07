package 第十二届蓝桥杯国赛.和与乘机;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException{
        int n=nextInt();
        long[] arr=new long[n+1];
        long[] sum=new long[n+1];   //前缀和数组
        long[] mult=new long[n+1];  //前缀积数组
        Arrays.fill(sum,0);
        Arrays.fill(mult,1);
        for (int i = 1; i <=n ; i++) {
            arr[i]=nextInt();
            sum[i]=sum[i-1]+arr[i]; //计算前缀和
            mult[i]=mult[i-1]*arr[i];
        }
        long res=0;
        //计算区间(i,j)的和与积是否相等
        for (int i = 1; i <=n ; i++) {
            for (int j = i; j <=n ; j++) {
                if(sum[j]-sum[i-1]==mult[j]/mult[i-1]){
                   res++;
                }
            }
        }
        System.out.println(res);
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
