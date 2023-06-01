package 国赛刷题挑战.近似gcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 若一个数组的近似gcd为g,那么该数组最多只能有一个数字不是g的倍数
 */
public class Main {
    public static long ans=0;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        int g=nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <=n ; i++) {
            arr[i]=nextInt();
        }
        //记录上一个不符合条件的数
        int last=0;
        //记录符合子数组的左区间
        int l=1;
        for (int r = 1; r <=n; r++) {
            //判断它是否是符合条件的数
            boolean t=arr[r]%g==0;
            if(!t){
                //时刻保证区间内不符合条件的数只能有一个
                l=last+1;
                last=r;
            }
            //累加答案
            ans+=r-l;
        }
        System.out.println(ans);
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
