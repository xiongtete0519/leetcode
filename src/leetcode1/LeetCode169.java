package leetcode1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 多数元素
 */
public class LeetCode169 {
    public static int majorityElement(int[] nums) {
        //使用HashMap存储每个元素以及出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        //打擂台取得最大值的key
        Map.Entry<Integer,Integer> majorityEntry=null;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(majorityEntry==null||entry.getValue()>majorityEntry.getValue()){
                majorityEntry=entry;
            }
        }
        return majorityEntry.getKey();

    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }
}
