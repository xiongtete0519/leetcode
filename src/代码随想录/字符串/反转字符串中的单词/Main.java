package 代码随想录.字符串.反转字符串中的单词;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode151:反转字符串中的单词
public class Main {
    public static String reverseWords(String s) {
        //除去开头和末尾的空白字符
        s=s.trim();
        //正则匹配连续的空白字符作为分隔符分割
        String[] split = s.split("\\s+");
        List<String> wordList = Arrays.asList(split);
        Collections.reverse(wordList);
        //将字符串集合拼接成一个字符串
        //delimiter：分隔符，用于连接字符串。
        //elements：要连接的元素集合，必须实现 Iterable 接口
        String join = String.join(" ", wordList);
        return join;
    }

    public static void main(String[] args) {
//        String s="the sky is blue";
        String s="a good  example";
        System.out.println(reverseWords(s));
    }

}
