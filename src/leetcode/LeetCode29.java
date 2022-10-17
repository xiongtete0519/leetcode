package leetcode;

//leetcode29:两数相除
public class LeetCode29 {
    public static int divide(int dividend,int divisor){
        if(dividend==0)
            return 0;
        long count=0;
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        long a=Math.abs((long)dividend);
        long temp=a;
        long b=Math.abs((long)divisor);
        while(temp>=b){
            temp-=b;
            count++;
        }
        return (int) (((dividend>0)==(divisor>0)||(dividend<0)==(divisor<0))?count:-count);
    }
    // 因为将 -2147483648 转成正数会越界，但是将 2147483647 转成负数，则不会
    // 所以，我们将 a 和 b 都转成负数
    // 时间复杂度：O(n)，n 是最大值 2147483647 --> 10^10 --> 超时
    public static int divide2(int a, int b) {
        // 32 位最大值：2^31 - 1 = 2147483647
        // 32 位最小值：-2^31 = -2147483648
        // -2147483648 / (-1) = 2147483648 > 2147483647 越界了
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        // 环境只支持存储 32 位整数
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;
    }
    //采用二分法的思想，dividend每次减去2^n个divisor(尽可能多)，
    //同时，result每次加2*n
    //因为将 -2147483648 转成正数会越界，但是将 2147483647 转成负数，则不会
    public static int divide3(int dividend,int divisor){
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
        int result=0;
        dividend=-Math.abs(dividend);
        divisor=-Math.abs(divisor);
        while(dividend<=divisor){
            int temp=divisor;
            int c=1;
            while(dividend-temp<=temp){
                temp=temp<<1;
                c=c<<1;
            }
            dividend-=temp;
            result+=c;
        }
        //根据被除数和除数是否同号决定结果的正负号
        return k?result:-result;
    }

    public static void main(String[] args) {
//        System.out.println(divide(10, 3));
//        System.out.println(divide(7, -3));
//        System.out.println(divide(1, 1));
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide2(-2147483648, -1));
        System.out.println(divide3(-2147483648, -1));

        System.out.println(12<<1);
        System.out.println(12>>1);
    }
}
