package 蓝桥杯;

import java.util.*;
//单词分析
public class Word {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int maxCount=0;
        String result="";
        HashMap<String, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if(map.containsKey(String.valueOf(c))){
               map.put(String.valueOf(c),map.get(String.valueOf(c))+1);
            }else{
                map.put(String.valueOf(c),1);
            }
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(value>maxCount){
                maxCount=value;
                result=key;
            }
        }
        //如果有多个字母出现的次序相等，输出字典序最小的那个

        System.out.println(result);
        System.out.println(maxCount);
        scan.close();
    }
}
