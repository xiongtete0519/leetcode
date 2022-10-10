package leetcode;

import java.util.ArrayList;

//无重复字符的最长子串
public class LeetCode3 {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ArrayList<Character> characters = new ArrayList<>();
            for(int j=i;j<chars.length;j++){
                if(characters.contains(chars[j])){
                    break;
                }
                characters.add(chars[j]);
                maxLength= Math.max(characters.size(), maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

        int length = lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);
    }
}
