package 十三届Java研究生组.数位排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException{
        int n = nextInt();
        int m = nextInt();
        Integer[] a = new Integer[n+1];
        for (int i = 1; i <=n ; i++) {
            a[i]=i;
        }
        //数位排序
        Arrays.sort(a, 1, n + 1, (o1, o2) -> numSum(o1)-numSum(o2));
        System.out.println(a[m]);
    }
    public static int numSum(int x){
        int ans=0;
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            ans+=Integer.parseInt(String.valueOf(aChar));
        }
        return ans;
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
