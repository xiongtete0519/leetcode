package 国赛复习.最大公约数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
//暴力查询区间gcd:目的是找出能通过gcd操作算出1的最小区间
public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        int[] arr=new int[n+1];
        int count=0;
        for (int i = 1; i <=n; i++) {
            arr[i]=nextInt();
            if(arr[i]==1){
                count++;    //统计1的个数
            }
        }
        if(count>0){
            System.out.println(n-count);
            return;
        }
        //判断是否无解,计算整个区间的gcd
        int i1 = arr[1];
        for (int i = 2; i <=n ; i++) {
            i1=gcd(i1,arr[i]);
        }
        if(i1!=1){  //无解
            System.out.println(-1);
            return;
        }
        int tmp=n;
        for (int i = 1; i <=n ; i++) {  //枚举左端点
            int d=arr[i];
            for (int j = i+1; j <=n; j++) { //枚举右端点
                d=gcd(d,arr[j]);
                if(d==1){
                    //区间长度为j-i+1，但是我们将所有数字变成1的操作次数为j-i
                    tmp=Math.min(tmp,j-i);
                    break;
                }
            }
        }
        //tmp是凑出一个1的操作次数，1再依次和相邻的剩下n-1个数gcd
        System.out.println(n-1+tmp);
    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        int max=Math.max(a,b);
        int min=Math.min(a,b);
        return gcd(min,max%min);
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
