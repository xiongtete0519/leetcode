package 代码随想录.哈希表.赎金信;

import java.util.HashMap;
import java.util.Map;

//leetcode383
public class Main {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();
        for (char c : chars1) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : chars2) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (char c : chars1) {
            Integer nums1 = map1.get(c);
            Integer nums2 = map2.get(c);
            if (nums1 == null || nums2 == null || nums2 < nums1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote="aa";
        String magazine="aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
