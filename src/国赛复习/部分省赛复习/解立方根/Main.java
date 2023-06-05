package 国赛复习.部分省赛复习.解立方根;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//解立方根：二分法
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static final double PE=1e-6;
    public static void main(String[] args) throws IOException {
        int t=nextInt();
        for (int i = 0; i < t; i++) {
            int N=nextInt();
            midSearch(N);
        }
    }
    public static void midSearch(int x){
        double left=0;
        double right=x;
        while(right-left>PE){
            double mid=(left+right)/2;
            if(mid*mid*mid<x){
                left=mid;
            }else{
                right=mid;
            }
        }
        //满足精度的时候输出：保留三位小数
        System.out.printf("%.3f\n",left);
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
