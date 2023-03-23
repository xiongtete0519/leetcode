package 蓝桥杯.排列字母;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s="WHERETHEREISAWILLTHEREISAWAY ";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
    }
}
