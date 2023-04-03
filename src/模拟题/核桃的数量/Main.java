package 模拟题.核桃的数量;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        System.out.println(gbs(a,gbs(b,c)));
    }
    public static int gbs(int a,int b){
        return a*b/gcd(a,b);
    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return gcd(min,max%min);
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
