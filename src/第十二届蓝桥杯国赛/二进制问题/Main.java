package 第十二届蓝桥杯国赛.二进制问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException{
        long n=nextLong();
        int k=nextInt();
        long res=0;
        //转换为二进制
        for (long i = 1; i <=n ; i++) {
            String str = Long.toBinaryString(i);
            int length = str.replaceAll("0", "").length();
            if(length==k){
                res++;
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
