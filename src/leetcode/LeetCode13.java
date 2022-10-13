package leetcode;

import java.util.HashMap;

//leetcode13:罗马数字转整数
public class LeetCode13 {
    private static HashMap<Character, Integer> symbolValues = new HashMap<Character, Integer>(){{
        put('I',1);
        put('V',5);
        put('X',10);
        put('L',50);
        put('C',100);
        put('D',500);
        put('M',1000);
    }};

    /**
     * 小的数字一般在大的数字的右边，若存在小的数字在大的数字的左边的情况，
     * 需要减去小的数字。对于这种情况，我们也可以将每个字符视作一个单独的值，若
     * 一个数字右侧的数字比它大，则该数字的符号取反。
     * XIV=X-I+V=10-1+5=14
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int result=0;
        int n=s.length();
        for (int i = 0; i < n; i++) {
            Integer value = symbolValues.get(s.charAt(i));
            if(i<n-1&&value<symbolValues.get(s.charAt(i+1))){
                result-=value;
            }else{
                result+=value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
