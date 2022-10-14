package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//leetcode18:四数之和
public class LeetCode18 {
    //暴力法
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> first = new HashSet<>();
        HashSet<Integer> second = new HashSet<>();
        HashSet<Integer> third = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if(!first.contains(nums[i])){
                first.add(nums[i]);
                for (int j = i+1; j <nums.length-2 ; j++) {
                    if(!second.contains(nums[j])){
                        second.add(nums[j]);
                        for (int k = j+1; k < nums.length - 1; k++) {
                            if(!third.contains(nums[k])){
                                third.add(nums[k]);
                                long sum=(long)nums[i]+nums[j]+nums[k]; //解决整型溢出
                                for (int l = k+1; l <nums.length ; l++) {
                                    if(sum+nums[l]>target){
                                        break;
                                    }else if(sum+nums[l]==target){
                                        ArrayList<Integer> list = new ArrayList<>();
                                        list.add(nums[i]);
                                        list.add(nums[j]);
                                        list.add(nums[k]);
                                        list.add(nums[l]);
                                        result.add(list);
                                        break;
                                    }
                                }
                            }
                        }
                        third.clear();
                    }
                }
                second.clear();
            }
        }
        return result;
    }
    //双指针法优化
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length<4){
            return result;
        }
        Arrays.sort(nums);//排序
        int length=nums.length;
        for (int i = 0; i < nums.length-3; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if((long)nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                //此时剩下的三个数无论取什么值，和一定大于target，直接退出第一重循环
                break;
            }
            if((long)nums[i]+nums[length-3]+nums[length-2]+nums[length-1]<target){
                //此时剩下的三个数无论取什么值，和一定小于target，进入下一轮
                continue;
            }
            for (int j = i+1; j <nums.length-2 ; j++) {
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                if((long)nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    //此时剩下的两个数无论取什么值，和一定大于target,退出第二重循环
                    break;
                }
                if((long)nums[i]+nums[j]+nums[length-2]+nums[length-1]<target){
                    //此时剩下的两个数无论取什么值，和一定小于target，第二重循环进入下一轮
                    continue;
                }
                int left=j+1;
                int right=length-1;
                while(left<right){
                    long sum=(long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        //保存四个数
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //左指针右移知道遇到不同的数
                        while(left<right&&nums[left]==nums[left+1]){    //去重
                            left++;
                        }
                        left++;
                        //右指针左移知道遇到不同的数
                        while(left<right&&nums[right]==nums[right-1]){  //去重
                            right--;
                        }
                        right--;
                    }else if(sum<target){//和小于target
                        left++; //左指针右移一位
                    }else{
                        right--;//右指针左移一位
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,0,-1,0,-2,2};
        int target=0;
        System.out.println(fourSum(nums, target));
        System.out.println(fourSum1(nums, target));
//        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
//        System.out.println(1000000000*4);
    }

}
