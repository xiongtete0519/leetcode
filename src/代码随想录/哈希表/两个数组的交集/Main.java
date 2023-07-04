package 代码随想录.哈希表.两个数组的交集;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//leetcode349:两个数组的交集
public class Main {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        for (int x: nums1) {
            set1.add(x);
        }
        for (int x: nums2) {
            if(set1.contains(x)){
                resSet.add(x);
            }
        }
        int[] ans=new int[resSet.size()];
        int i=0;
        for (Integer x : resSet) {
            ans[i++]=x;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        int[] intersection = intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }
}
