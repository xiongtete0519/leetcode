package 笔试.快手.最长连续子序列;

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode128 {
    //朴素揭发
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int len = 1;
        int largeLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                len++;
            } else {
                len = 1;
            }
            largeLen = Math.max(largeLen, len);
        }
        return largeLen;
    }

    //哈希表
    public static int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int largeLen = 1;
        for (Integer x : set) {
            //不是连续子序列的第一个就跳过
            if (set.contains(x - 1)) {
                continue;
            }
            int y = x;
            while (set.contains(y + 1)) {
                y++;
            }
            largeLen = Math.max(largeLen, y - x + 1);
        }
        return largeLen;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive1(nums1));
    }
}
