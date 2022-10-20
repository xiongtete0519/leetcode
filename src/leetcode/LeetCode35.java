package leetcode;
//leetcode35:搜索插入位置
public class LeetCode35 {
    public static int searchInsert(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int result=nums.length;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>=target){
                right=mid-1;
                result=mid;
            }else{
                left=mid+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
    }
}
