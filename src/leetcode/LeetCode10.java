package leetcode;

//正则表达式匹配
//动态规划
public class LeetCode10 {
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;//默认dp[0][0]为true
        for (int i = 0; i < n; i++) {
            //如果p的第i+1个字符也就是p.charAt(i)是"*"的话，
            //那么他就可以把p的第i个字符给消掉（也就是匹配0次）。
            //我们只需要判断p的第i-1个字符和s的前0个字符是否匹
            //配即可。比如p是"a*b*"，如果要判断p的第4个字符
            //"*"和s的前0个字符是否匹配，因为字符"*"可以消去
            //前面的任意字符，只需要判断p的"a*"和s的前0个字
            //符是否匹配即可
            if(p.charAt(i)=='*'&&dp[0][i-1]){
                dp[0][i+1]=true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isMatch("aa", "a"));
//        System.out.println(isMatch("aa", "a."));
//        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("aab", "c*a*b*"));
    }
}
