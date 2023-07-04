package 代码随想录.哈希表.两数之和;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    //暴力法
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
    //使用哈希表
    public static int[] twoSum1(int[] nums,int target){
        int[] res=new int[2];
        if(nums==null||nums.length==0){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                res[0]=map.get(temp);
                res[1]=i;
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] ints1 = twoSum1(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
    }
}
