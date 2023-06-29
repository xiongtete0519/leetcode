package 代码随想录.数组.二分查找;

public class Main {
    public static int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid;
        while(left<=right){
            mid=(left+right)>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                //这里nums[mid]已经比target大了，下一次区间就不用包含mid了，到mid-1就行
                right=mid-1;
            }else{
                //这里nums[mid]已经比target小了，下一次直接从mid的右边开始就行
                left=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
}
