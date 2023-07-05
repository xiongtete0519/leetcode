package 代码随想录.哈希表.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//leetcode15:三数之和:双指针
//本题要求不能有重复的三元组(三元组中的元素可以重复)
public class Main {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                break;
            }
            //去重
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int target=-nums[i];
            int right=nums.length-1;    //右指针
            int left=i+1;   //左指针
            while(left<right){
                if(left>i+1&&nums[left]==nums[left-1]){ //去重
                    left++;
                    continue;
                }
                if(nums[left]+nums[right]==target){//符合条件
                    ArrayList<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[left]);
                    list1.add(nums[right]);
                    list.add(list1);
                    left++;
                }else if(nums[left]+nums[right]>target){
                    right--;    //右指针左移
                }else{//nums[left]+nums[right]<target
                    left++;     //左指针右移
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
