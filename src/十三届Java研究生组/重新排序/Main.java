package 十三届Java研究生组.重新排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
//80%
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long[] a = new long[n + 1];       //原始数组
        long[] count = new long[n + 1];   //统计各个元素被加的次数
        long originalSum=0;//记录原始的和
        long finalSum=0;    //记录最大化之后的和
        for (int i = 1; i <=n; i++) {
            a[i]=nextLong();
        }
        int m = nextInt();
        for (int i = 0; i <m ; i++) {//m次询问
            int left = nextInt();
            int right = nextInt();
            for (int j = left; j <=right ; j++) {
                count[j]++; //统计各个元素被加的次数
            }
        }
//        System.out.println(Arrays.toString(count));
        //原始的和
        for (int i = 1; i <=n; i++) {
            originalSum+=a[i]*count[i];
        }
        Arrays.sort(a);
        Arrays.sort(count);
        for (int i = 1; i <=n; i++) {
            finalSum+=a[i]*count[i];
        }
        System.out.println(finalSum-originalSum);
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
