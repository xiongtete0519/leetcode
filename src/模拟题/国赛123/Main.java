package 模拟题.国赛123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static long[] sum = new long[1500010];
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        long t=0;
        for (int i = 1; i <=1500000; i++) {
            t+=i;
            sum[i]+=sum[i-1]+t;   //求前缀和
        }
        int n = nextInt();
        while(n-->0){
            long left = nextLong();
            long right = nextLong();
            System.out.println(fun(right)-fun(left-1));
        }
    }
    public static long fun(long x){
        int left=1;
        int right=1500000;
        while(left<right){  //二分法快速求出x位于sum中的哪一块
            int mid=(left+right)>>1;
            if(cutSum(mid)<x){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        left--; //求得前面块
        x-=cutSum(left);//当前块的位置
        return sum[left]+cutSum(x);//用前面块的和+当前块的位置前缀和

    }
    //计算等差数列前n项和
    public static long cutSum(long n){
        return n*(1L+n)/2;
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
