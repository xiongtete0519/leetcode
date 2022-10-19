package leetcode;

import java.util.Arrays;

//leetcode34:在排序数组中查找元素的第一个和最后一个位置
//要求时间复杂度:O(log n)
public class LeetCode34 {
    public int[] searchRange(int[] nums,int target){
        //左边界：寻找第一个>=target的索引
        int leftIdx=search(nums,target);
        //右边界：寻找第一个>=target+1的索引
        int rightIdx=search(nums,target+1);
        if(leftIdx<nums.length&&nums[leftIdx]==target){
            return new int[]{leftIdx,rightIdx-1};
        }
        return new int[]{-1,-1};
    }
    //寻找第一个>=目标值的索引，找不到则返回数组长度
    public int search(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int ans=nums.length;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>=target){
                right=mid-1;
                ans=mid;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target=8;
        LeetCode34 leetCode34 = new LeetCode34();
//        System.out.println(Arrays.toString(leetCode34.searchRange(nums, target)));
        System.out.println(Arrays.toString(leetCode34.searchRange(new int[]{2,2,3}, 3)));
    }
}
