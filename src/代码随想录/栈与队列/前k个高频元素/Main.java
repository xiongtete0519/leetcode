package 代码随想录.栈与队列.前k个高频元素;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //key:数字 value:出现次数
//            map.put(num,map.getOrDefault(num,0)+1);
            map.merge(num, 1, Integer::sum);
        }
        //定制比较器：根据出现次数排序
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
