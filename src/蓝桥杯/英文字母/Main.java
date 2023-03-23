package 蓝桥杯.英文字母;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        System.out.println('A'+1);
//        System.out.println((char)65);
        int n = scan.nextInt();
        System.out.println((char)('A'+n-1));

        scan.close();
    }
}
