package 模拟题.最大数字;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * [1]我们使用操作1可以让该位置上的数字增加，由于贪心思想，我们尽可能让该位置上的值靠近9，由于剩余的操作1的次数可能不够增加到9，
 * 那我们再该位置上的操作次数为t=min(n,9-x)
 * [2]操作2只会让某个数字减小，唯一让数字增加的机会是减到0后再减一次，变成9，
 * 这样需要的操作2的次数是x+1,如果剩余的操作2次数<x+1,我们就不要用操作2，这样只会让数字变小。
 */
public class Main {
    public static String str;
    public static long sum;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        long N = nextLong();
        long n = nextLong();//1号操作n次
        long m = nextLong();//2号操作m次
        str = String.valueOf(N);
        dfs(0,n,m,0);
        System.out.println(sum);
    }
    public static void dfs(int i,long n,long m,long v){
        if(i<str.length()){
            long x = (long) str.charAt(i) - '0';
            long t = Math.min(n, 9 - x);    //执行操作1的最小次数
            dfs(i+1,n-t,m,v*10L+x+t);
            //考虑2号操作是否能够使用
            if(m>x){//操作2的次数可以减到0后再减一次到9，那就可以使用操作2
                dfs(i+1,n,m-x-1L,v*10L+9);
            }
        }else{
            sum=Math.max(sum,v);
        }
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }
}
