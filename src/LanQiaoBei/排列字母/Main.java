package LanQiaoBei.排列字母;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String s="WHERETHEREISAWILLTHEREISAWAY ";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
    }
}
