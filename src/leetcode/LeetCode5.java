package leetcode;

/**
 * leetcode4:最长回文子串
 */
public class LeetCode5 {

    //中心扩展法:向左扩展、向右扩展、向两边同时扩展
    public static String longestPalindrome(String s) {
        int left=0; //左扩展指针
        int right=0; //右扩展指针
        int len=1;  //记录最大回文串的长度
        int maxStart=0; //记录最大回文串的起始位置
        int maxLen=0;   //记录最大回文串的长度
        for (int i = 0; i < s.length(); i++) {  //将每个字符逐个当作中心字符
            left=i-1;
            right=i+1;
            //向左边扩展：如果不超过左边界并且与中心字符相等，就继续扩展
            while(left>=0&&s.charAt(i)==s.charAt(left)){
                len++;  //回文串长度+1
                left--; //继续左边扩展
            }
            //向右边扩展：如果不超过有边界并且与中心字符相等，就继续扩展
            while(right<=s.length()-1&&s.charAt(i)==s.charAt(right)){
                len++;  //回文串长度+1
                right++;//继续向右边扩展
            }
            //向两边扩展
            while(left>=0&&right<=s.length()-1&&s.charAt(left)==s.charAt(right)){
                len+=2; //回文串长度+2
                left--; //继续向左边扩展
                right++; //继续向右边扩展
            }
            if(len>maxLen){ //始终取得最长回文串的左边界-1和最大长度
                maxLen=len;
                maxStart=left;
            }
            len=1;  //重置回文串的长度
        }
        //这块maxStart+1是因为最后有一次left--,
        // 而maxStart+maxLen+1是因为substring的左闭右开规则
        return s.substring(maxStart+1,maxStart+maxLen+1);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
