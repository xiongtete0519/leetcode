package leetcode1;

import java.util.ArrayList;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class LeetCode125 {

    public static boolean isPalindrome(String s) {
        //接收转换成小写字母之后的结果
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9')){
                list.add(String.valueOf(c).toLowerCase());
            }
        }
//        list.forEach(System.out::print);
        if(list.size() == 0||list.size()==1){
            return true;
        }
        int right = list.size() - 1;
        int left=0;
        boolean flag=false;
        //验证是否是回文，头尾指针
        while(list.get(left).equals(list.get(right))&&left<=right){
            left++;
            right--;
            flag=true;
        }
        if(left<right){
            flag=false;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode125.isPalindrome("a"));
    }
}
