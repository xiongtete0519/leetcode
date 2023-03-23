package 蓝桥杯.重复的数;

import java.util.HashMap;
import java.util.Scanner;
//20%
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //数列中数字个数
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
        int m = scan.nextInt();//询问次数
        //使用HashMap存储每个数字在指定区间的出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int left = scan.nextInt();
            int right = scan.nextInt();
            int count = scan.nextInt();
            for (int j = left; j <= right; j++) {
                if (map.containsKey(a[j])) {
                    map.put(a[j], map.get(a[j]) + 1);
                } else {
                    map.put(a[j], 1);
                }
            }
            if (map.entrySet().size() == 0) {
                System.out.println(0);
            } else {
                long count1 = map.values()
                        .stream()
                        .filter(integer -> integer == count)
                        .count();
                System.out.println(count1);
            }
            map.clear();
        }
    }
}
