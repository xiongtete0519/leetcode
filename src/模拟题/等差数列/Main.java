package 模拟题.等差数列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int[] a = new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=nextInt();
        }
        Arrays.sort(a);
        int min=Integer.MAX_VALUE;
        //找到相邻项的最小差值,这个差值就是公差d
        for (int i = 1; i <n ; i++) {
            min=Math.min(min,a[i]-a[i-1]);
        }
        if(min==0){
            System.out.println(n);
        }else{
            //An=A1+(n-1)*d=>n=(An-A1)/d=1
            int res = (a[n - 1] - a[0]) / min + 1;
            System.out.println(res);
        }
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
