package leetcode;

import java.util.Arrays;

//leetcode1
public class AddTest {
    public int[] twoSum(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if(nums[i]+nums[j]==target){
//                    System.out.println("i="+i+",j="+j);
//                }
//            }
//        }
        AddTest addTest = new AddTest();
        int[] ints = addTest.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));


    }
}
