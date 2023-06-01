package 国赛刷题挑战.砝码称重;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
//将问题转化为0-1背包

/**
 * Main2
 * 分两次进行0-1背包
 * [1]:第一次求解0-1背包：对每个砝码，考虑不放和加就是0-1背包问题，求解完毕，背包当成一种状态
 * [2]:第二次求解0-1背包：把上一次求解完毕的状态和减的情况当成0-1背包的两种状态
 * 对每个砝码，如果上一次求解完毕的状态是加这个砝码，那么减去就相当于不放，
 * 如果上次计算的状态是不放，那么减就是减去这个砝码的重量，相当于放在天平的另一边，这样不存在重复和漏算的情况
 *  不放这种情况其实是重复的，但是对最终结果没影响
 */
public class Main1 {
    public static int[] dp=new int[100010]; //砝码总的重量不超过100000，背包容量
    public static int[] w=new int[110]; //最多100个砝码，物品个数
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int n=nextInt();
        for (int i = 1; i <=n ; i++) {
            w[i]=nextInt();
        }
        dp[0]=1;    //重量为0的可以称出来
        //加或者不放
        for (int i = 1; i <=n ; i++) {  //先遍历物品
            //从大到小考虑每个称重j,j>=w[i]
            //如果从小到大，则意味着w[i]可以加很多次，j-w[i]+w[i]=j,j+w[i],...
            for(int j=100000;j>=w[i];j--){  //再遍历背包，砝码总重量不超过100000
                //如果此前dp[j-w[i]]为1，则加上w[i]重量，能达到j，所以dp[j]为1
                dp[j]=Math.max(dp[j],dp[j-w[i]]);
            }
        }
        //上面的情况和减
        for (int i = 1; i <=n ; i++) {
            int size=100000-w[i];
            //从小到大考虑每个称重j,j<=100000-w[i]
            //如果从大到小，则意味着w[i]可以减很多次，j+w[i]-w[i]=j,j-w[i],...
            for (int j = 1; j <=size; j++) {
                //如果此前dp[j+w[i]]为1，则减去w[i]重量，能达到j，所以dp[j]=1
                dp[j]=Math.max(dp[j],dp[j+w[i]]);
            }
        }
        long ans=0;
        for (int i = 1; i <=100000 ; i++) {//统计每一个1或者求和(从1开始)
            ans+=dp[i];
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
