package leetcode2.L121买卖股票的最佳时机;

public class Main {
    public static int maxProfit(int[] prices) {
        int ans=0;
        for (int i = 0; i <prices.length; i++) {
            for (int j = i+1; j <prices.length; j++) {
                ans=Math.max(ans,prices[j]-prices[i]);
            }
        }
        return ans;
    }
    //dp[i]:截止到第i天，价格的最低点是多少
    //dp[i]=min(dp[i-1],nums[i])
    public static int maxProfit1(int[] prices) {
        int max=0;
        int[] dp=new int[prices.length];
        dp[0]=prices[0];
        for (int i = 1; i <prices.length ; i++) {
            dp[i]=Math.min(dp[i-1],prices[i]);
            //卖掉最低价格买入的那张股票的收益
            max=Math.max(prices[i]-dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit1(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
