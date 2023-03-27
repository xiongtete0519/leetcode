package 模拟题.对局匹配;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashSet;
//dp[i]:前i个可以选择出的最大人数
public class Main1 {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException{
        int n = nextInt();
        int k = nextInt();
        int ans=0;
        int[] cnt = new int[100010];
        int[] a = new int[100010];
        int[] dp = new int[100010];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <=n ; i++) {
            int x = nextInt();
            set.add(x); //为了快速统计出k==0的情况
            cnt[x]++;   //记录积分为x的人数
        }
        if(k==0){
            ans=set.size();
        }else{
            for (int i = 0; i <k; i++) {    //分为k组
                int m=0;
                Arrays.fill(dp,0);
                for (int j = i; j <=100000; j+=k) {
                    a[++m]=cnt[j];
                }
                for (int j = 1; j <=m ; j++) {
                    if(j==1){
                        dp[j]=a[j];
                    }else{      //max(选择i(相邻的不能选),不选择i)
                        dp[j]=Math.max(dp[j-2]+a[j],dp[j-1]);
                    }
                    ans+=dp[m]; //加上该组可选的最大人数
                }
            }
        }
        System.out.println(ans);
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }
}
