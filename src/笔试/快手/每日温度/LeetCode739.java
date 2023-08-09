package 笔试.快手.每日温度;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode739 {
    //超时
    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int cur = temperatures[i];
            for (int j = i + 1; j < len; j++) {
                if (temperatures[j] > cur) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    //单调栈，这道题栈中存的是下标(方便计算天数的差值)
    public static int[] dailyTemperatures1(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int temperature = temperatures[i];
            //只有遍历的当前元素大于栈顶元素的时候才会出栈(一直满足就一直出栈)
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(temperatures);
        int[] res1 = dailyTemperatures1(temperatures);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res1));
    }
}
