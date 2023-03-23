package 蓝桥杯.技能升级.官方题解;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//技能升级
public class Main {
    public static long[] a = new long[100010];
    public static long[] b = new long[100010];
    public static long n;
    public static long m;

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n = (long) st.nval;    //n个技能
        st.nextToken();
        m = (long) st.nval;    //可以升级m次
        for (int i = 1; i <= n; i++) {  //读取每一个等差数列首项Ai和公差-Bi
            st.nextToken();
            a[i] = (long) st.nval;    //首次升级提升a[i]点攻击力
            st.nextToken();
            b[i] = (long) st.nval;    //之后每次都减少b[i]点攻击力
        }
        int left = 0;
        int right = 1000000;
        int x = 0;
        //二分法求出第m大的数值
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
                //此时假设的第M大的数值太小了，需要调整左端点l
                x = mid;
                left = mid + 1;
            } else {
                //此时假设的第M大的数值为x太大了，没几个数字大于x，需要调整右端点r
                right = mid - 1;
            }
        }
        //已经求出第M大为x,求解前M大和
        long num = 0; //大于x的数字个数num
        long ans = 0; //数字之和ans
        for (int i = 1; i <= n; i++) {
            if (a[i] < x) {
                continue;
            }
            //找一个最大的满足k:a[i]-k*b[i]>x
            //这里k是为了计算每个等差数列有多少项是大于x的
            int k = (int) ((a[i] - x) / b[i]);
            if (k * b[i] != (a[i] - x)) {
                k += 1;
            }
            //等差数列求和
            //a[i]+(a[i]-b[i])+...+(a[i]-(k-1)*b[i])
            ans += (a[i] + a[i] - (k - 1) * b[i]) * k / 2;
            num += k;
        }
        //(m-num)*x表示M个最大的项包含m-num个重复的x
        ans += (m - num) * x;
        System.out.println(ans);
    }

    //假设第m大为x,求存在多少个数字>=x
    public static boolean check(long x) {
        long count = 0;   //n个递减的等差数列中有count个数>=x
        for (int i = 1; i <= n; i++) {
            if (a[i] < x) {
                continue;
            }
            int k = (int) ((a[i] - x) / b[i]);   //公差为b[i]的递减等差数列
            count += k + 1; //a[i]到x之间有k+1个数
        }
        return count >= m;
    }

}
//3 6
//10 5
//9 2
//8 1