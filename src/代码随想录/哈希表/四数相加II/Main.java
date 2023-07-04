package 代码随想录.哈希表.四数相加II;

import java.util.HashMap;

public class Main {

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //统计前两个数组中的元素之和以及出现的次数
        for (int x : nums1) {
            for (int y : nums2) {
                int sum=x+y;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        //统计剩余的两个元素的和，在map中找是否粗壮乃相加为0的情况，同时记录次数
        for (int x : nums3) {
            for (int y : nums4) {
                res+=map.getOrDefault(0-x-y,0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1={1,2};
        int[] num2={-2,-1};
        int[] num3={-1,2};
        int[] num4={0,2};
        System.out.println(fourSumCount(num1, num2, num3, num4));

    }
}
