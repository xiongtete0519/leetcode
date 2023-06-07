package 第十二届蓝桥杯国赛.异或三角;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int t=nextInt();
        long[] arr = new long[t + 1];
        for (int i = 1; i <=t ; i++) {
            arr[i]=nextLong();
        }
        for (int i = 1; i <=t ; i++) {
            long count=check(arr[i]);
            System.out.println(count);
        }
    }
    public static long check(long x){
        long res=0;
        for (int a = 1; a <=x ; a++) {
            for (int b = 1; b <=x ; b++) {
                long c=a^b;
                if(c>=1&&c<=x&&a+b>c&&a+c>b&&b+c>a){
                    res++;
                }
            }
        }
        return res;
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
