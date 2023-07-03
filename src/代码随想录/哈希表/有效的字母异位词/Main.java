package 代码随想录.哈希表.有效的字母异位词;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (char c : charS) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c : charT) {
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
            }else{
                return false;
            }
        }
        //检查values是否都是0
        boolean flag = map.values().stream().allMatch(x -> x==0);
        return flag;
    }

    public static void main(String[] args) {
//        String s="anagram";
        String s="aacc";
        String t="ccac";
//        String t="nagaram";
        System.out.println(isAnagram(s, t));
    }
}
