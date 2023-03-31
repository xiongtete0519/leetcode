package 十三届Java研究生组.最优清零方案;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * 我们的目的是更多地执行操作2
 */
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int k = nextInt();
        long[] a = new long[n + 1];
        for (int i = 1; i <=n; i++) {
            a[i]=nextLong();
        }
        long openation2=0;  //操作2的执行次数
        //滑动窗口找到连续k个大于0的数字
        int left=1;
        while(left+k-1<=n){
            long min=Integer.MAX_VALUE;
            int index=-1;   //记录最小值的索引
            //找到当前窗口的最小值
            for (int i=left;i<left+k;i++) {
                if(a[i]<=min){
                    min=a[i];
                    index=i;    //记录最小值最靠右边的索引
                }
            }
            //给指定区间都减去这个最小值：其实就是执行了min次操作2
            for (int i = left; i <left+k ; i++) {
                a[i]-=min;
            }
            openation2+=min;
            //此时该窗口中已经不存在连续k个大于0的整数
            left=index+1;//从先置零的下一个位置继续
        }
        //走到这里数列已经没有连续k个大于0的整数了，只能执行操作1
        //我们直接求和就是操作1的执行次数
        long operation1 = Arrays.stream(a).skip(1).sum();
        long res = openation2 + operation1;
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
