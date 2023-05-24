package 国赛刷题挑战.最大公约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static int[] arr;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
       int n=nextInt();
       arr=new int[n+1];
       int countOne=0;
        for (int i = 1; i <=n ; i++) {
            arr[i]=nextInt();
            if(arr[i]==1){
                countOne++; //统计1的个数
            }
        }
        if(countOne>0){ //有1可以直接返回
            System.out.println(n-countOne);
            return;
        }
        //判断是否有解，对整个区间进行gcd
        int tmp = arr[1];
        for (int i = 2; i <=n; i++) {
            tmp=gcd(tmp,arr[i]);
        }
        if(tmp!=1){ //无解
            System.out.println("-1");
            return;
        }

        int res=n;
        //枚举
        for (int i = 1; i <=n ; i++) {  //枚举左端点
            int ans=arr[i];
            for (int j = i+1; j <=n ; j++) {    //枚举右端点
                ans=gcd(ans,arr[j]);
                if(ans==1){
                    res=Math.min(res,j-i);
                    break;
                }
            }
        }
        //需要res次gcd才能凑出一个1,剩下的n-1个数只需要n-1次gcd
        System.out.println(res+n-1);
    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return gcd(min,max%min);
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long) st.nval;
    }
}
