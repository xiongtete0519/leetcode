package 国赛复习.循环小数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int p=nextInt();
        int q=nextInt();
        long decimal=nextLong();
        if(p==1){   //纯循环小数
            //分子
            long x=decimal;
            //分母
            long y = (long)Math.pow(10, q) - 1;
            System.out.println(x/gcd(x,y)+" "+y/gcd(x,y));
        }else{  //混合循环小数
            //取出decimal的前(p-1)位
            String s = String.valueOf(decimal);
            String sub = s.substring(0, p - 1);
            long tmp = Long.parseLong(sub);
            //分子
            long x=decimal-tmp;
            //分母
            long y=(long)Math.pow(10,q)-(long)Math.pow(10,p-1);
            System.out.println(x/gcd(x,y)+" "+y/gcd(x,y));
        }
    }
    public static long gcd(long a,long b){
        if(b==0){
            return a;
        }
        long max=Math.max(a,b);
        long min = Math.min(a, b);
        return gcd(min,max%min);
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
