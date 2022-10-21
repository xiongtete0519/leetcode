package leetcode1;

public class LeetCode70 {
    //递归，超时了
    public int climbStairs(int n){
        if(n==0||n==1){
            return 1;
        }else{
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }
    //动态规划

    /**
     *爬第n阶楼梯的方法数量，等于两部分之和
     * 1、爬上第n-1阶楼梯的方法数量，因为再爬1阶就能到第n阶
     * 2、爬上第n-2阶楼梯的方法数量，因为再爬2阶就能到第n阶
     * dp[n]=dp[n-1]+dp[n-2]
     * dp[0]=1,dp[1]=1
     */
    public int climbStairs1(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        LeetCode70 leet = new LeetCode70();
        System.out.println(leet.climbStairs(4));
    }
}
