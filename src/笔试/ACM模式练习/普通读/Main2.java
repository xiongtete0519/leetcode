package 笔试.ACM模式练习.普通读;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int m = scan.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[i] = scan.nextInt();
            }
            System.out.println(Arrays.stream(arr).sum());
            System.out.println();
        }
    }
}
