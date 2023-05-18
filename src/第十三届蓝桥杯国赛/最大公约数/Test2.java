package 第十三届蓝桥杯国赛.最大公约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Test2 {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        int[] arr=new int[n+1];
        int count=0;
        for (int i = 1; i <=n ; i++) {
            arr[i]=nextInt();
            if(arr[i]==1){
                count++;    //统计输入数据中1得个数
            }
        }
        if(count>0){    //有1可以直接返回结果
            System.out.println(n-count);
            return;
        }
        //判断无解的情况
        int tmp=arr[1];
        for (int i = 2; i <=n; i++) {
            tmp=gcd(tmp,arr[i]);
        }
        if(tmp!=1){ //无解
            System.out.println(-1);
            return;
        }
        int ans=n;
        for (int i = 1; i <=n; i++) {   //枚举左端点
            int t=arr[i];
            for (int j = i+1; j <=n ; j++) {    //枚举右端点
                t=gcd(t,arr[j]);
                if(t==1){
                    ans=Math.min(ans,j-i);
                    break;
                }
            }
        }
        //最少需要ans次gcd操作才能凑出一个1，剩余的n-1次数在经过n-1次gcd变成1
        System.out.println(n-1+ans);
    }

    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return gcd(min,max%min);
    }

    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
