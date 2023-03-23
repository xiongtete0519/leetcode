package 蓝桥杯.文件拷贝时间;

import java.util.Scanner;

//文件拷贝时间
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long t = scan.nextLong();
        long c = scan.nextLong();
        long s = scan.nextLong();

        System.out.println((s - c) * t / c);
    }
}
