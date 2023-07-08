package 代码随想录.字符串.重复的子字符串;
//leetcoded459:重复的子字符串
public class Main {
    //将两个s连接在一起，并移除第一个和最后一个字符。
    //如果s是该字符串的子串，那么s就满足题目要求
    public static boolean repeatedSubstringPattern(String s) {
//        System.out.println((s+s).indexOf(s,1));
        return (s+s).indexOf(s,1)!=s.length();
    }
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("abc"));
    }
}
