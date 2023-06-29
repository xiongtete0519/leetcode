package 代码随想录.数组.有序数组的平方;

import java.util.Arrays;

public class Main {

    public static int[] sortedSquares(int[] nums) {
       return  Arrays.stream(nums).map(x->x*x).sorted().toArray();
    }

    //双指针法
    public static int[] sortedSquares1(int[] nums) {
        int right=nums.length-1;
        int left=0;
        int[] result=new int[nums.length];
        int index=result.length-1;
        while(left<=right){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                //正数的位置是相对不变得，需要调整得是负数平方后得相对位置
                result[index--]=nums[left]*nums[left];
                left++;
            }else{
                result[index--]=nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] ints = sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(ints));
    }
}
