package leetcode;
import java.util.*;

//leetcode17:电话号码的字母组合
public class LeetCode17 {
    //使用HashMap建立映射
    private static Map<Character,List<String>> map = new HashMap<Character,List<String>>(){{
       put('2',Arrays.asList("a","b","c"));
       put('3',Arrays.asList("d","e","f"));
       put('4',Arrays.asList("g","h","i"));
       put('5',Arrays.asList("j","k","l"));
       put('6',Arrays.asList("m","n","o"));
       put('7',Arrays.asList("p","q","r","s"));
       put('8',Arrays.asList("t","u","v"));
       put('9',Arrays.asList("w","x","y","z"));
    }};
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();
        if(digits==null||digits.length()==0)
            return list;
        if(digits.length()==1)
            return map.get(digits.charAt(0));
        //从字符获取对应的Map中对应的list
        list= new ArrayList<>(map.get(digits.charAt(0)));
        //然后遍历进行归并即可
        for (int i = 1; i < digits.length(); i++) {
            list=merge(list,map.get(digits.charAt(i)));
        }
        return list;
    }
    //合并
    public static ArrayList<String> merge(List<String> list1, List<String> list2) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                list.add(list1.get(i)+list2.get(j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
