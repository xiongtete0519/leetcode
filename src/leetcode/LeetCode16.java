package leetcode;

import java.util.Arrays;

//leetcode16:最接近的三数之和
public class LeetCode16 {
    /**
     * 暴力解法：一边求和一边比较。
     * 和target接近的意思就是两者之间差的绝对值最小
     */
    public static int threeSumClosest(int[] nums, int target) {
        int min=0;
        int result=nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j <nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int num=nums[i]+nums[j]+nums[k];
                    if(Math.abs(num-target)<Math.abs(result-target)){
                       result=num;
                    }
                }
            }
        }
        return result;
    }
    //优化：双指针
    public static int threeSumClosest1(int[] nums,int target){
        Arrays.sort(nums);//先排序
        int result=nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int left=i+1;               //左指针
            int right=nums.length-1;    //右指针
            while(left!=right){
                int sum=nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target)<Math.abs(result-target)){
                    result=sum;
                }
                if(sum>target){ //如果相加的结果比target大
                    right--;    //右指针左移
                }else{          //如果相加的结果比target小
                    left++;     //左指针右移
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={-1,2,1,-4};
        System.out.println(threeSumClosest(nums, 1));
        System.out.println(threeSumClosest1(nums, 1));

    }
}
