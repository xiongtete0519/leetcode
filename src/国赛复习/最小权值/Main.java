package 国赛复习.最小权值;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long[] dp=new long[2022];
        Arrays.fill(dp,Long.MAX_VALUE>>1);
        dp[0]=0;
        for (int i = 1; i <=2021 ; i++) {   //i个节点的最小权值
            //左子树节点j个，右子树节点i-1-j个
            for (int j = 0; j <i; j++) {    //枚举左子树个数
                dp[i]=Math.min(dp[i],1+2*dp[j]+3*dp[i-1-j]+j*j*(i-1-j));
            }
        }
        System.out.println(dp[2021]);
    }
}
