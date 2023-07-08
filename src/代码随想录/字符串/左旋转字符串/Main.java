package 代码随想录.字符串.左旋转字符串;

public class Main {
    public static String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0, n);
        String s2 = s.substring(n);
        return s2+s1;
    }

    public static void main(String[] args) {
        String s="abcdefg";
        int k=2;
        System.out.println(reverseLeftWords(s, k));
    }
}
