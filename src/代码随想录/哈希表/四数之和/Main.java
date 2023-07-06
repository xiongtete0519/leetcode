package 代码随想录.哈希表.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//leetcode18:四数之和
public class Main {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        //解决求和之后的溢出问题
        long target1=(long)target;
        for (int i = 0; i < nums.length; i++) {
            //nums[i]>target直接返回，剪枝操作
            if(nums[i]>0&&nums[i]>target){
                return list;
            }
            //对nums[i]去重
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                //对nums[j]去重
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int left=j+1;
                int right=nums.length-1;
                long temp=target1-(nums[i]+nums[j]);
                while(left<right){
                    if(left>j+1&&nums[left]==nums[left-1]){
                        left++;
                        continue;
                    }
                    if(nums[left]+nums[right]==temp){
                        list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                    }else if(nums[left]+nums[right]>temp){
                            right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] nums ={1,0,-1,0,-2,2};
//        int target = 0;
        int[] nums={-1000000000,-1000000000,1000000000,-1000000000,-1000000000};
        int target=294967296;
        List<List<Integer>> list = fourSum(nums, target);
        System.out.println(list);


    }
}
