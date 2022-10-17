package leetcode;
//leetcode26:删除有序数组中的重复项
public class LeetCode26 {
    //设立一个计数k即可
    public static int removeDuplicates(int[] nums){
        int n=nums.length;
        if(n==0)
            return 0;
        int k=0;
        for (int i = 1; i < n; i++) {
            if(nums[i]!=nums[k]){
                k++;
                nums[k]=nums[i];
            }
        }
        return k+1;
    }
    //方法二：快慢指针
    public static int removeDuplicates1(int[] nums){
        int n=nums.length;
        if(n==0)
            return 0;
        int fast=1;
        int slow=1;
        while(fast<n){
            if(nums[fast]!=nums[fast-1]){
                nums[slow]=nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2};
        int[] nums1={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates(nums1));
    }
}
