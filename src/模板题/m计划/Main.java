package 模板题.m计划;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //n块石头
        int m = scan.nextInt(); //m计划
        int[] a = new int[n + 1];
        for (int i = 1; i <=n ; i++) {
            a[i]=scan.nextInt();
        }


    }
}
