package 国赛刷题挑战.六六大顺;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        BigInteger sum = BigInteger.ZERO;
        BigInteger[] arr = new BigInteger[n+1];
        BigInteger[] b = new BigInteger[n+1];
        Arrays.fill(arr,BigInteger.ZERO);
        Arrays.fill(b,BigInteger.ZERO);
        for (int i = 1; i <=n ; i++) {
            arr[i]=new BigInteger("10").multiply(arr[i-1]).add(new BigInteger("6"));
            b[i]=arr[i].multiply(arr[i]);
            sum=sum.add(b[i]);
        }
        System.out.println(sum);
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
