package leetcode;

public class LeetCode58 {
    public static int lengthOfLastWord(String s){
        String trim = s.trim(); //去除首尾空格
        String[] split = s.split("\\s+");//匹配一个或多个空格
        return split[split.length-1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello world"));
        System.out.println(lengthOfLastWord(" fly me   to  the moon"));

    }
}
