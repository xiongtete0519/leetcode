package 国赛打游击.最小权值;

import java.util.Arrays;
/**
 * dp[i]:有i个节点的最小权值
 * dp[i]=min{dp[i],1+2*dp[j]+3*dp[i-1-j]+j*j*(i-1-j)}
 * j表示左子树的节点数,j=0,1,...i-1
 * i-1-j表示右子树的节点数
 */
public class Main {
    public static void main(String[] args) {
        long[] dp = new long[2022];
        //数组全部设置为最大值
        Arrays.fill(dp, Long.MAX_VALUE);
        //初始值为零
        dp[0] = 0;
        for (int i = 1; i <= 2021; i++) {
            //左子树节点j个，右子树节点i-1-j个
            for (int j = 0; j < i; j++) {
                dp[i]=Math.min(dp[i],1+2*dp[j]+3*dp[i-1-j]+j*j*(i-1-j));
            }
        }
        System.out.println(dp[2021]);
    }
}
