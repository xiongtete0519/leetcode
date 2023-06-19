package leetcode2.同构字符串;

import java.util.HashMap;

public class Main {
    public static boolean isIsomorphic(String s, String t) {
        //存储x->y的映射
        HashMap<Character, Character> map1 = new HashMap<>();
        //存储y->x的映射
        HashMap<Character, Character> map2 = new HashMap<>();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            char x = chars1[i];
            char y = chars2[i];
            //如果映射已经存在，且存在冲突，那就直接false
            if(map1.containsKey(x)&&map1.get(x)!=y||map2.containsKey(y)&&map2.get(y)!=x){
                return false;
            }
            map1.put(x,y);
            map2.put(y,x);
        }
        return true;
    }

    public static void main(String[] args) {
        String s="egg";
        String t="add";
        System.out.println(isIsomorphic(s,t));
    }
}
