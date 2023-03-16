package 模拟题.方阵;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sqrt = (int) Math.sqrt(n);
        System.out.println(sqrt);
        scan.close();
    }
}
