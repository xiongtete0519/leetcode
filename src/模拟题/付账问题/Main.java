package 模拟题.付账问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * 贪心：为了使得标准差最小，每一个出的钱bi必须接近平均值s/n
 * [1]第i个人带的钱不够平均数avg,那么他只能出自己全部的钱ai
 * [2]第i个人带的钱比平均数avg多，那么他可以多付一些。
 *
 * 基本步骤如下：
 * 1、对ai从小到大排序
 * 2、排序后前一部分人的钱不够，那么就出他们所有的钱
 * 3、从总付钱数中扣除前一部分人出的钱，得剩余需要出得钱数为S',
 * 以及剩余得后一部分人的出钱平均数avg'
 * 4、后一部分人的钱多，他们多出一些：
 * (1)比较有钱的，但是他的钱也不够avg'，那么他的钱也是全部出
 * (2)非常有钱的，不管怎么付他都有富余
 */
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long s = nextLong();
        long[] a = new long[n];

        //每个人带的钱数
        for (int i = 0; i <n ; i++) {
            a[i]=nextLong();
        }
        //开始贪心选择
        Arrays.sort(a);//排序，从小到大
        double avg=1.0*s/n;
        double sum=0;
        for (int i = 0; i <n; i++) {
            if(a[i]*(n-i)<s){   //把钱全部拿出的人
                sum+=(a[i]-avg)*(a[i]-avg); //为标准差做准备
                s-=a[i];    //更新还差多少钱
            }else{  //不需要把钱全部拿出的人。剩下的人中，钱最少的人都可以达到cur_avg
                double cur_avg=1.0*s/(n-i);//注意这里的s是还差多少钱
                //如果这个人有钱付，那么后面的人一定也能付，所以直接乘后面的人数(n - i)即可
                sum+=(cur_avg-avg)*(cur_avg-avg)*(n-i);
                break;
            }
        }
        System.out.printf("%.4f",Math.sqrt(sum/n)); //计算标准差
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
