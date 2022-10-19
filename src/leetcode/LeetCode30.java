package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode30:串联所有单词的子串
public class LeetCode30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        int wordNum = words.length;
        if(wordNum==0)
            return res;
        int wordLen=words[0].length();
        //HashMap1存所有单词
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String w : words) {
            Integer value = allWords.getOrDefault(w, 0);
            allWords.put(w,value+1);
        }
        //遍历字符串
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            //HashMap2存当前扫描的字符串含有的单词
            HashMap<String, Integer> hasWords = new HashMap<>();
            int num=0;
            //判断该子串是否符合
            while(num<wordNum){
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                //判断该单词在HashMap1中
                if(allWords.containsKey(word)){
                    Integer value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word,value+1);
                    //判断当前单词的value和HashMap1中该单词的value
                    if(hasWords.get(word)>allWords.get(word)){
                        break;
                    }
                }else{
                    break;
                }
                num++;
            }
            //判断是不是所有的单词都符合条件
            if(num==wordNum){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words={"foo","bar"};
        System.out.println(findSubstring("barfoothefoobarman", words));
    }

}
