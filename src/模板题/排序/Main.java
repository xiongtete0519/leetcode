package 模板题.排序;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] a = new int[N];
        for (int i = 0; i <N; i++) {
            a[i]=scan.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i <N ; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        for (int i = N-1; i>=0; i--) {
            System.out.print(a[i]+" ");
        }
    }
}
