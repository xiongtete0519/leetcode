package 国赛复习.最大公约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 70%
 * 如果数组中有1，那就一次和相邻的元素进行GCD操作即可
 * 如果没有1，想办法用一个最小的区间凑出来一个1
 * 如果整个数组的gcd不等于1，无解
 */
public class Test {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
        int n=nextInt();
        int[] arr = new int[n + 1];
        int count=0;    //记录1的个数
        for (int i = 1; i <=n ; i++) {
            arr[i]=nextInt();
            if(arr[i]==1){
                count++;
            }
        }
        if(count>0){
            System.out.println(n-count);
            return;
        }
        int tmp=n;
        //判断是否无解
        int d=arr[1];
        for (int i = 2; i <=n; i++) {
            d=gcd(d,arr[i]);
        }
        if(d!=1){   //无解
            System.out.println(-1);
            return;
        }
        //找出能凑出一个1的最小区间
        for (int i = 1; i <=n ; i++) {  //枚举左端点
            d=arr[i];
            for (int j = i+1; j <=n ; j++) {    //枚举右端点
                d=gcd(d,arr[j]);
                if(d==1){
                    //区间长度为j-i+1，但是执行gcd的次数是j-i次
                    tmp=Math.min(tmp,j-i);
                }
            }
        }
        //通过tmp次gcd操作凑出了一个1，还剩n-1个数依次gcd即可
        System.out.println(tmp+n-1);
    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        int max=Math.max(a,b);
        int min=Math.min(a,b);
        return gcd(min,max%min);
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
}
