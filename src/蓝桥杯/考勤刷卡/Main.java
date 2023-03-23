package 蓝桥杯.考勤刷卡;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String next = scan.next();
            int number = scan.nextInt();
            set.add(number);
        }
        set.stream().sorted().forEach(System.out::println);

        scan.close();
    }
}
