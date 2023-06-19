package leetcode2.L191位1的个数;

public class Main {
    public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        return s.replaceAll("0", "").length();
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }
}
