package study.动态规划.最长上升子序列;

import java.util.Scanner;

public class LIS1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=scan.nextInt();
        }
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums){
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0]=1;
        int maxans=1;
        for (int i = 1; i <nums.length ; i++) {
            dp[i]=1;
            for (int j = 0; j <i ; j++) {
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxans=Math.max(maxans,dp[i]);
        }
        return maxans;
    }
}
