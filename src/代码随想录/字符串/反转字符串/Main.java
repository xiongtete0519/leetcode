package 代码随想录.字符串.反转字符串;
//leetcode344:反转字符串
public class Main {
    //双指针
    public static void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        while(left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        String s="hello";
        reverseString(s.toCharArray());
    }
}
