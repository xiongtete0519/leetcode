package 笔试.大疆.输出无重复三位数;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public int[] ThreeDigitNumbers(int[] selectedDigits) {
        Set<Integer> res = new HashSet<>();
        int length = selectedDigits.length;
        //暴力
        for (int i = 0; i < length; i++) {
            int x = selectedDigits[i];
            for (int j = 0; j < length; j++) {
                int y = selectedDigits[j];
                for (int k = 0; k < length; k++) {
                    int z = selectedDigits[k];
                    if (x != y && x != z && y != z) {
                        int tmp = x * 100 + y * 10 + z;
                        res.add(tmp);
                    }
                }
            }
        }
        return res.stream().sorted((o1, o2) -> o1 - o2).mapToInt(Integer::valueOf).sorted().toArray();

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int selectedDigitSize = in.nextInt();
        int[] selectedDigits = new int[selectedDigitSize];
        for (int i = 0; i < selectedDigitSize; i++) {
            selectedDigits[i] = in.nextInt();
        }
        int[] res = new Main().ThreeDigitNumbers(selectedDigits);
        for (int x : res) {
            System.out.print(x + " ");
        }

    }
}
