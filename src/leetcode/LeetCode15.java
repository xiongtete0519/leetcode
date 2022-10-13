package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//三数之和
public class LeetCode15 {
    public static List<List<Integer>> threeSum(int[] nums){
        ArrayList<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0)   //第一个都大于0，后面加起来肯定不等于0了
                break;
            if(i>0&&nums[i]==nums[i-1]){    //去掉重复情况
                continue;
            }
            int target=-nums[i];
            int right=nums.length-1;    //右指针
            int left=i+1;               //左指针
            while(left<right){
                if(left>i+1&&nums[left]==nums[left-1]){//还是去重
                    left++;
                    continue;
                }
                if(nums[left]+nums[right]==target){ //满足条件，加入集合
                    ArrayList<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[left]);
                    list1.add(nums[right]);
                    list.add(list1);
                    left++;
                }else if(nums[left]+nums[right]<target){
                    left++; //左指针右移
                }else{  //nums[left]+nums[right]>target
                    right--;//右指针左移
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
