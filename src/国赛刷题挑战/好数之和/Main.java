package 国赛刷题挑战.好数之和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
//40%
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        long sum=0;
        long left=nextLong();
        long right=nextLong();
        for (long i = left; i <=right ; i++) {
            if(check(i)){
                sum+=i;
            }
        }
        System.out.println(sum);
    }
    public static boolean check(long x){
        String s = String.valueOf(x);
        if(s.contains("2022")){
            return true;
        }else{
            return false;
        }
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
