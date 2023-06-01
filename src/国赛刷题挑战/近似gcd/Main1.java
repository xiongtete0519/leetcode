package 国赛刷题挑战.近似gcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 前缀和优化：40%
 * pre[i]:表示1-i区间类不是g倍数的数字个数
 * 若一个数组的近似gcd为g,那么该数组最多只能有一个数字不是g的倍数
 */
public class Main1 {
    public static long ans=0;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        int g=nextInt();
        int[] arr = new int[n + 1];
        int[] pre = new int[n + 1]; //前缀和数组
        for (int i = 1; i <=n ; i++) {
            arr[i]=nextInt();
        }
        for (int i = 1; i <=n; i++) {
            pre[i]+=pre[i-1];
            if(arr[i]%g!=0){
                pre[i]++;
            }
        }
        for (int l = 1; l <=n ; l++) {  //区间左端点
            for (int r = l+1; r <=n ; r++) {    //区间右端点
                if(pre[r]-pre[l-1]<=1){
                    ans++;
                }
            }
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
