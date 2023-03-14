package 模板题.蓝桥骑士;

import java.util.Scanner;

/**
 * dp[i]=max(dp[j])+1
 * 定义dp[i]为考虑前i个元素，以第i个数字结尾的最长上升子序列的长度，注意nums[i]必须被选取
 * 从小到大计算dp数组的值，在计算dp[i]之前，我们已经计算出dp[0,,,i-1]的值，则
 * 状态转移方程为:dp[i]=max(dp[j])+1,其中0<=j<i且num[j]<num[i]
 * 即考虑往dp[0...i-1]中最长的上升子序列后面再加一个nums[i]。
 * 最后，整个数组的最长上升子序列即所有dp[i]中的最大值
 * length(LIS)=max(dp[i]),0<=i<n
 */
public class DP {
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
