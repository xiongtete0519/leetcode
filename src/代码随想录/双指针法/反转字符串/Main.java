package 代码随想录.双指针法.反转字符串;

import java.util.Arrays;

//leetcode344.反转字符串
public class Main {
    public static void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        while(left<right){
            char c=s[left];
            s[left]=s[right];
            s[right]=c;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        reverseString(new char[]{'h','e','l','l','o'});
    }
}
