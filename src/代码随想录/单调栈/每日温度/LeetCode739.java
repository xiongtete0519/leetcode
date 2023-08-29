package 代码随想录.单调栈.每日温度;

import java.util.Arrays;

public class LeetCode739 {
    //暴力
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode739 code739 = new LeetCode739();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = code739.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }
}
