package 十三届Java研究生组.排列字母;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "WHERETHEREISAWILLTHEREISAWAY";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s=String.valueOf(chars);
        System.out.println(s);
    }
}
