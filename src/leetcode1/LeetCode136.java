package leetcode1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 * 实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class LeetCode136 {

    //key是元素，value是出现次数
    //每次没出现过就put,出现过就移除这个key，最后map中只会剩余一个键值对
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.remove(nums[i]);
            }
        }
        Integer next = map.keySet().iterator().next();
        return next;
    }
    //异或运算,与零按位异或的结果为该值本身，两个相同的值异或操作结果为零
    //由于每个元素重复两次，则他们在按位异或后相互抵消，唯一的元素只出现一次
    public static int singleNumber1(int[] nums) {
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            result^=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
        System.out.println(singleNumber1(new int[]{2,2,1}));

    }
}
