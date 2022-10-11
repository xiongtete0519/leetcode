package leetcode;
//回文数
public class LeetCode9 {
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuilder builder = new StringBuilder(str);
        StringBuilder reverse = builder.reverse();
        boolean flag=false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==reverse.charAt(i)){
                flag=true;
            }else{
                return false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
}
