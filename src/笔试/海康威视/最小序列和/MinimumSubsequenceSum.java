package 笔试.海康威视.最小序列和;

//dp[i]:以第i个位置结尾的自序列的最小和
public class MinimumSubsequenceSum {
    public static int calculateMinimumSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];//初始化dp
        int minSum = nums[0]; //初始化最小和为序列的第一个元素
        for (int i = 1; i < n; i++) {
            //状态转移方程：选择一当前位置结尾的自序列的最小和
            dp[i] = Math.min(dp[i - 1] + nums[i], nums[i]);
            //更新最小和
            minSum = Math.min(minSum, dp[i]);
        }
        //返回最终的最小和
        return minSum;
    }

    public static void main(String[] args) {
        int[] nums = {7, -6, 5, -9, 7};
        int minSum = calculateMinimumSum(nums);
        System.out.println("Minimum subsequence sum: " + minSum);
    }
}