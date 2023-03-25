package 模拟题.格子刷油漆;


import java.util.Scanner;

public class Main {
    public static final long MOD= 1000000007L;
    public static long[] a=new long[1005];
    public static long[] b=new long[1005];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n==1){
            System.out.println(2);
            return;
        }
        a[1]=1;
        a[2]=6;
        b[1]=1;
        b[2]=2;
        // 打表，递推求出a数组和b数组在不同长度情况下的值=
        for(int i=3;i<=n;i++)
        {
            b[i]=(2*b[i-1])%MOD;
            a[i]=(2*a[i-1]+b[i]+4*a[i-2])%MOD;
        }
        // 4个顶点
        // 特别注意这里sum的数据类型需要用long long，否则有可能在乘以4后发生数据溢出
        long sum=4*a[n] % MOD;
        // 根据前面算出的a[ ]数组和b[ ]数组，递推出从中间出发时的方案数
        // 注意i的范围是大于1小于n
        for(int i=2;i<n;i++){
            sum = (sum+4*(b[i]*a[n-i]+b[n-i+1]*a[i-1]))%MOD;
        }
        System.out.println(sum);
    }
}
