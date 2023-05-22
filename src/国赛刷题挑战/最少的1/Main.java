package 国赛刷题挑战.最少的1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        long n = nextLong();
        String str = Long.toBinaryString(n);
        long res=0;
        res = str.length() - str.replaceAll("1", "").length();

        for (int i = 1; i <1000000; i++) {
            String s = Long.toBinaryString(n * i);
            if(s.contains("1")){
                int len=s.length()-s.replaceAll("1","").length();
                res=Math.min(res,len);
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
