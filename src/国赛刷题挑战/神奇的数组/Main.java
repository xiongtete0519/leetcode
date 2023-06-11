package 国赛刷题挑战.神奇的数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n=nextInt();
        long[] arr=new long[n+1];
        long[] sum=new long[n+1];   //前缀和数组
        long[] xor=new long[n+1];
        for (int i = 1; i <=n ; i++) {
            arr[i]=nextLong();
            sum[i]=sum[i-1]+arr[i]; //计算前缀和
            xor[i]=xor[i-1]^arr[i]; //前缀异或和
        }
        long res=0;
         long d;
        for (int i = 1; i <=n ; i++) {
            for (int j = i; j <=n; j++) {
                if((xor[j]^xor[i-1])==sum[j]-sum[i-1]){
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
