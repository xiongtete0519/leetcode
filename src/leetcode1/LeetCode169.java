package leetcode1;

import java.util.*;

/**
 * 多数元素
 */
public class LeetCode169 {
    //方法一：哈希表
    public static int majorityElement(int[] nums) {
        //使用HashMap存储每个元素以及出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        //打擂台取得最大值的key
        Map.Entry<Integer,Integer> majorityEntry=null;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(majorityEntry==null||entry.getValue()>majorityEntry.getValue()){
                majorityEntry=entry;
            }
        }
        return majorityEntry.getKey();

    }
    /**
     * 方法二：排序
     * 如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，
     * 那么下标为n/2(下标从0开始)一定是众数
     */
    public static Integer majorityElement1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement1(new int[]{3, 2, 3}));
    }
}
